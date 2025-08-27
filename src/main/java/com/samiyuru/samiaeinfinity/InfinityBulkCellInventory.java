package com.samiyuru.samiaeinfinity;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import appeng.api.config.Actionable;
import appeng.api.crafting.IPatternDetails;
import appeng.api.networking.security.IActionSource;
import appeng.parts.automation.ExportBusPart;
import appeng.parts.automation.IOBusPart;
import appeng.blockentity.storage.IOPortBlockEntity;
import appeng.api.stacks.AEItemKey;
import appeng.api.stacks.AEKey;
import appeng.api.stacks.KeyCounter;
import appeng.api.storage.cells.CellState;
import appeng.api.storage.cells.ISaveProvider;
import appeng.api.storage.cells.StorageCell;

import com.samiyuru.samiaeinfinity.misc.CompressionChain;
import com.samiyuru.samiaeinfinity.misc.CompressionService;

public class InfinityBulkCellInventory implements StorageCell {
    // ThreadLocal to track if we're in an IO port context
    private static final ThreadLocal<Boolean> IO_PORT_CONTEXT = new ThreadLocal<>();
    
    private final ISaveProvider container;
    private final ItemStack stack;

    private AEItemKey storedItem;
    private final AEItemKey filterItem;

    private final boolean compressionEnabled;
    private CompressionChain compressionChain;
    private BigInteger unitCount;
    private BigInteger unitFactor;
    private int compressionCutoff;

    private Map<AEItemKey, Long> compressedStacks;
    private boolean needsStackUpdate;
    private List<IPatternDetails> decompressionPatterns;

    private boolean isPersisted = true;

    InfinityBulkCellInventory(ItemStack stack, ISaveProvider container) {
        this.stack = stack;
        this.container = container;

        var cell = (InfinityBulkCellItem) stack.getItem();
        filterItem = (AEItemKey) cell.getConfigInventory(stack).getKey(0);
        var compressionCard = BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("megacells", "compression_card"));
        compressionEnabled = compressionCard != null && cell.getUpgrades(stack).isInstalled(compressionCard);

        storedItem = (AEItemKey) stack.get(InfinityComponents.BULK_CELL_ITEM);
        
        // For infinity cells, initialize with filter item if available, otherwise cobblestone
        if (storedItem == null) {
            storedItem = filterItem != null ? filterItem : AEItemKey.of(Items.COBBLESTONE);
            stack.set(InfinityComponents.BULK_CELL_ITEM, storedItem);
        }
        unitCount = stack.getOrDefault(InfinityComponents.BULK_CELL_UNIT_COUNT, BigInteger.valueOf(Long.MAX_VALUE));

        var determiningItem = storedItem != null ? storedItem : (filterItem != null ? filterItem : AEItemKey.of(Items.COBBLESTONE));
        compressionChain = CompressionService.getChain(determiningItem);
        
        System.out.println("InfinityBulkCellInventory Debug:");
        System.out.println("  Stored Item: " + storedItem);
        System.out.println("  Filter Item: " + filterItem);
        System.out.println("  Determining Item: " + determiningItem);
        System.out.println("  Compression Enabled: " + compressionEnabled);
        System.out.println("  Compression Chain Size: " + compressionChain.size());
        System.out.println("  Compression Chain Empty: " + compressionChain.isEmpty());

        unitFactor = compressionChain.unitFactor(determiningItem);
        var recordedFactor = stack.getOrDefault(InfinityComponents.BULK_CELL_UNIT_FACTOR, unitFactor);

        if (!unitFactor.equals(recordedFactor)) {
            unitCount = unitCount.multiply(unitFactor).divide(recordedFactor);
            stack.set(InfinityComponents.BULK_CELL_UNIT_COUNT, unitCount);
            stack.set(InfinityComponents.BULK_CELL_UNIT_FACTOR, unitFactor);
        }

        // Load or initialize compression cutoff
        compressionCutoff = stack.getOrDefault(InfinityComponents.BULK_CELL_COMPRESSION_CUTOFF, Math.max(0, compressionChain.size() - 1));
        System.out.println("  INFINITY CELL: Initializing compressed stacks...");
        
        // Initialize compressed stacks manually - infinite amount up to compression cutoff
        compressedStacks = new HashMap<>();
        if (!compressionChain.isEmpty()) {
            for (int i = 0; i <= compressionCutoff && i < compressionChain.size(); i++) {
                var variant = AEItemKey.of(compressionChain.getItem(i));
                compressedStacks.put(variant, Long.MAX_VALUE);
                System.out.println("  Adding infinite (up to cutoff " + compressionCutoff + "): " + variant);
            }
        } else if (determiningItem != null) {
            compressedStacks.put(determiningItem, Long.MAX_VALUE);
            System.out.println("  Adding infinite fallback: " + determiningItem);
        }
        
        System.out.println("  Final Compressed Stacks Size: " + compressedStacks.size());
        needsStackUpdate = true; // Ensure stacks get updated on first access
    }

    @Override
    public CellState getStatus() {
        if (storedItem == null || unitCount.signum() < 1) {
            return CellState.EMPTY;
        }

        if (isFilterMismatched()) {
            return CellState.FULL;
        }

        return CellState.NOT_EMPTY;
    }

    AEItemKey getStoredItem() {
        return storedItem;
    }

    long getStoredQuantity() {
        return Long.MAX_VALUE; // Always infinite
    }

    AEItemKey getFilterItem() {
        return filterItem;
    }

    private boolean isFilterMismatched() {
        // Infinity cells never have filter mismatches - they're pre-configured
        return false;
    }

    private boolean isIOPortAccess(IActionSource source) {
        // Check if the action source is from an IO Port
        var machine = source.machine();
        if (machine.isPresent()) {
            var machineObject = machine.get();
            return machineObject instanceof IOPortBlockEntity ||
                   machineObject instanceof IOBusPart ||
                   machineObject instanceof ExportBusPart;
        }
        return false;
    }
    
    private static void setIOPortContext(boolean isIOPort) {
        if (isIOPort) {
            IO_PORT_CONTEXT.set(true);
        } else {
            IO_PORT_CONTEXT.remove();
        }
    }
    
    private static boolean isInIOPortContext() {
        return Boolean.TRUE.equals(IO_PORT_CONTEXT.get());
    }

    public boolean isCompressionEnabled() {
        return compressionEnabled;
    }

    public boolean hasCompressionChain() {
        return !compressionChain.isEmpty();
    }

    long getTraceUnits() {
        return CompressionChain.clamp(unitCount.remainder(unitFactor), Long.MAX_VALUE);
    }

    public List<IPatternDetails> getDecompressionPatterns() {
        if (filterItem == null || !compressionEnabled || !hasCompressionChain() || isFilterMismatched()) {
            return List.of();
        }

        if (decompressionPatterns == null) {
            decompressionPatterns = compressionChain.getDecompressionPatterns(compressionCutoff);
        }

        return decompressionPatterns;
    }

    @Override
    public double getIdleDrain() {
        return 5.0f;
    }

    @Override
    public long insert(AEKey what, long amount, Actionable mode, IActionSource source) {
        if (amount == 0 || !(what instanceof AEItemKey item)) {
            return 0;
        }

        if (isFilterMismatched()) {
            return 0;
        }

        // For infinity cells, accept the stored item or anything in its compression chain
        if (!item.equals(storedItem) && (!compressionEnabled || !compressionChain.containsVariant(item))) {
            return 0;
        }

        var factor = compressionChain.unitFactor(item);
        var units = BigInteger.valueOf(amount).multiply(factor);

        if (mode == Actionable.MODULATE) {
            if (storedItem == null) {
                storedItem = item; // Use the inserted item as the stored item
                stack.set(InfinityComponents.BULK_CELL_ITEM, storedItem);
            }

            // For infinity cells, we don't actually increase the count - it stays infinite
            // unitCount = unitCount.add(units); // Commented out for infinity
            saveChanges();
            needsStackUpdate = true;
        }

        return amount;
    }

    @Override
    public long extract(AEKey what, long amount, Actionable mode, IActionSource source) {
        boolean isIOPort = isIOPortAccess(source);
        
        System.out.println("=== EXTRACT DEBUG ===");
        System.out.println("  What: " + what);
        System.out.println("  Amount requested: " + amount);
        System.out.println("  Mode: " + mode);
        System.out.println("  Is IO Port Access: " + isIOPort);
        
        // Set the IO port context so getAvailableStacks can use it
        try {
            setIOPortContext(isIOPort);
            
            if (storedItem == null || unitCount.signum() < 1 || !(what instanceof AEItemKey item)) {
                System.out.println("  Early return 0: storedItem=" + storedItem + ", unitCount=" + unitCount);
                return 0;
            }

        // IO Port restriction: only allow extraction of the BASE item in the compression chain
        if (isIOPortAccess(source)) {
            // Get the base (uncompressed) item from the compression chain
            AEItemKey baseItem = null;
            if (!compressionChain.isEmpty() && compressionChain.size() > 0) {
                var baseItemStack = compressionChain.getItem(0); // Index 0 is always the base uncompressed item
                if (!baseItemStack.isEmpty()) {
                    baseItem = AEItemKey.of(baseItemStack);
                }
            }
            
            // If no compression chain, the stored item IS the base item
            if (baseItem == null) {
                baseItem = storedItem;
            }
            
            if (!item.equals(baseItem)) {
                System.out.println("  IO Port access denied: requested " + item + " but base item is " + baseItem);
                return 0;
            }
            System.out.println("  IO Port access allowed: requesting base item " + baseItem);
        } else {
            // Non-IO Port access: allow compression chain variants
            if (!compressionChain.containsVariant(item) && !item.equals(storedItem)) {
                System.out.println("  Item not in compression chain and not stored item");
                return 0;
            }
        }

        if (isFilterMismatched()) {
            long availableAmount = getAvailableStacks().get(item);
            amount = Math.min(amount, availableAmount);
            System.out.println("  Filter mismatched, limited to: " + amount + " (available: " + availableAmount + ")");
        } else if (!compressionEnabled && !item.equals(storedItem)) {
            System.out.println("  Compression disabled and item not stored item");
            return 0;
        }

        // For IO ports, treat as if compression doesn't exist
        BigInteger factor;
        BigInteger units;
        if (isIOPortAccess(source)) {
            factor = BigInteger.ONE; // No compression factor for IO ports
            units = BigInteger.valueOf(amount); // Direct amount, no multiplication
            System.out.println("  IO Port: Using factor 1 (no compression)");
            System.out.println("  IO Port: Direct units = " + units);
        } else {
            factor = compressionChain.unitFactor(item);
            units = BigInteger.valueOf(amount).multiply(factor);
            System.out.println("  Compression factor: " + factor);
            System.out.println("  Units calculated: " + units);
        }

        if (mode == Actionable.MODULATE) {
            System.out.println("  MODULATE mode - actually extracting");
            // For infinity cells, we don't actually decrease the count - it stays infinite
            // unitCount = unitCount.subtract(units).max(BigInteger.ZERO); // Commented out for infinity

            // Don't let the cell become empty for infinity cells
            // if (unitCount.signum() < 1) {
            //     storedItem = null;
            //     var filterChain = CompressionService.getChain(filterItem);
            //
            //     if (compressionChain != filterChain) {
            //         compressionChain = filterChain;
            //         compressionCutoff = Math.max(0, compressionChain.size() - 1);
            //     }
            // }

            saveChanges();
            needsStackUpdate = true;
        } else {
            System.out.println("  SIMULATE mode - not extracting");
        }

        // For IO ports, return the direct amount (no compression math)
        long result;
        if (isIOPortAccess(source)) {
            result = amount; // Direct amount for IO ports
            System.out.println("  IO Port: Returning direct amount: " + result);
        } else {
            result = CompressionChain.clamp(units.divide(factor), Long.MAX_VALUE);
            System.out.println("  Final result: " + result);
        }
            System.out.println("===================");
            return result;
        } finally {
            // Always clear the IO port context
            setIOPortContext(false);
        }
    }

    private void saveChanges() {
        isPersisted = false;

        if (container != null) {
            container.saveChanges();
        } else {
            persist();
        }
    }

    @Override
    public void persist() {
        if (isPersisted) {
            return;
        }

        if (storedItem == null || unitCount.signum() < 1) {
            stack.remove(InfinityComponents.BULK_CELL_ITEM);
            stack.remove(InfinityComponents.BULK_CELL_UNIT_COUNT);
            stack.remove(InfinityComponents.BULK_CELL_UNIT_FACTOR);
            stack.remove(InfinityComponents.BULK_CELL_COMPRESSION_CUTOFF);
        } else {
            stack.set(InfinityComponents.BULK_CELL_ITEM, storedItem);
            stack.set(InfinityComponents.BULK_CELL_UNIT_COUNT, unitCount);
            stack.set(InfinityComponents.BULK_CELL_UNIT_FACTOR, unitFactor);
            stack.set(InfinityComponents.BULK_CELL_COMPRESSION_CUTOFF, compressionCutoff);
        }

        isPersisted = true;
    }

    public void switchCompressionCutoff(boolean backwards) {
        if (!hasCompressionChain()) {
            return;
        }
        
        if (backwards) {
            compressionCutoff = Math.max(0, compressionCutoff - 1);
        } else {
            compressionCutoff = Math.min(compressionChain.size() - 1, compressionCutoff + 1);
        }
        
        // Save the new cutoff and trigger stack update
        stack.set(InfinityComponents.BULK_CELL_COMPRESSION_CUTOFF, compressionCutoff);
        needsStackUpdate = true;
        saveChanges();
        
        System.out.println("Compression cutoff changed to: " + compressionCutoff + " (item: " + getCutoffItem() + ")");
    }

    public ItemStack getCutoffItem() {
        if (!hasCompressionChain() || compressionCutoff >= compressionChain.size()) {
            return ItemStack.EMPTY;
        }
        return compressionChain.getItem(compressionCutoff);
    }

    ItemStack getHighestVariant() {
        return hasCompressionChain() ? compressionChain.getItem(compressionChain.size() - 1) : ItemStack.EMPTY;
    }

    ItemStack getLowestVariant() {
        return hasCompressionChain() ? compressionChain.getItem(0) : ItemStack.EMPTY;
    }

    @Override
    public void getAvailableStacks(KeyCounter out) {
        if (needsStackUpdate) {
            var determiningItem = storedItem != null ? storedItem : filterItem;
            // Regenerate infinite compressed stacks up to cutoff
            compressedStacks = new HashMap<>();
            if (!compressionChain.isEmpty()) {
                for (int i = 0; i <= compressionCutoff && i < compressionChain.size(); i++) {
                    var itemStack = compressionChain.getItem(i);
                    if (!itemStack.isEmpty()) {
                        var variant = AEItemKey.of(itemStack);
                        compressedStacks.put(variant, Long.MAX_VALUE);
                    }
                }
            } else if (determiningItem != null) {
                compressedStacks.put(determiningItem, Long.MAX_VALUE);
            }
            needsStackUpdate = false;
            System.out.println("getAvailableStacks: Updated compressed stacks, size = " + compressedStacks.size());
        }

        if (storedItem != null) {
            // Check if we're in IO port context
            if (isInIOPortContext()) {
                // IO port context: only show the base (uncompressed) item
                AEItemKey baseItem = null;
                if (!compressionChain.isEmpty() && compressionChain.size() > 0) {
                    var baseItemStack = compressionChain.getItem(0);
                    if (!baseItemStack.isEmpty()) {
                        baseItem = AEItemKey.of(baseItemStack);
                    }
                }
                if (baseItem == null) {
                    baseItem = storedItem;
                }
                
                System.out.println("getAvailableStacks: IO Port context - only showing base item: " + baseItem);
                out.add(baseItem, Long.MAX_VALUE);
            } else {
                // Normal context: show all compression variants or stored item
                if (compressionEnabled) {
                    System.out.println("getAvailableStacks: Compression enabled, adding " + compressedStacks.size() + " compressed stacks");
                    compressedStacks.forEach((key, value) -> {
                        System.out.println("  Adding: " + key + " x " + value);
                        out.add(key, value);
                    });
                } else {
                    System.out.println("getAvailableStacks: Compression disabled, adding only stored item");
                    out.add(storedItem, CompressionChain.clamp(unitCount.divide(unitFactor), CompressionChain.STACK_LIMIT));

                    if (isFilterMismatched()) {
                        compressedStacks.keySet().stream()
                                .takeWhile(i -> !storedItem.equals(i))
                                .forEach(i -> out.add(i, compressedStacks.get(i)));
                    }
                }
            }
        }
    }

    @Override
    public boolean isPreferredStorageFor(AEKey what, IActionSource source) {
        return what instanceof AEItemKey item
                && (item.equals(storedItem) || item.equals(filterItem) || compressionChain.containsVariant(item));
    }

    @Override
    public boolean canFitInsideCell() {
        // Infinity cells are never empty and can't be nested
        return false;
    }

    @Override
    public Component getDescription() {
        return stack.getHoverName();
    }
}