package com.samiyuru.samiaeinfinity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import javax.annotation.ParametersAreNonnullByDefault;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;

import appeng.api.config.FuzzyMode;
import appeng.api.stacks.AEItemKey;
import appeng.api.stacks.AEKeyType;
import appeng.api.stacks.GenericStack;
import appeng.api.storage.StorageCells;
import appeng.api.storage.cells.ICellHandler;
import appeng.api.storage.cells.ICellWorkbenchItem;
import appeng.api.storage.cells.ISaveProvider;
import appeng.api.upgrades.IUpgradeInventory;
import appeng.api.upgrades.UpgradeInventories;
import appeng.core.AEConfig;
import appeng.core.localization.Tooltips;
import appeng.items.AEBaseItem;
import appeng.items.contents.CellConfig;
import appeng.items.storage.StorageCellTooltipComponent;
import appeng.util.ConfigInventory;

/**
 * EXACT copy of MEGACells BulkCellItem - no changes yet
 */
public class InfinityBulkCellItem extends AEBaseItem implements ICellWorkbenchItem {
    private static final ICellHandler HANDLER = new Handler();

    public InfinityBulkCellItem() {
        super(new Properties().stacksTo(1));
    }

    public static void registerHandler() {
        StorageCells.addCellHandler(HANDLER);
    }

    @Override
    public ConfigInventory getConfigInventory(ItemStack is) {
        return CellConfig.create(Set.of(AEKeyType.items()), is, 1); // 1 slot minimum required by AE2
    }

    @Override
    public IUpgradeInventory getUpgrades(ItemStack is) {
        return UpgradeInventories.forItem(is, 1);
    }

    @ParametersAreNonnullByDefault
    @Override
    public void appendHoverText(ItemStack is, TooltipContext context, List<Component> lines, TooltipFlag flag) {
        var inv = (InfinityBulkCellInventory) HANDLER.getCellInventory(is, null);

        if (inv != null) {
            var storedItem = inv.getStoredItem();
            var filterItem = inv.getFilterItem();

            if (storedItem != null) {
                lines.add(Tooltips.of(Component.literal("Contains: ").append(storedItem.getDisplayName())));
                var quantity = inv.getStoredQuantity();
                lines.add(Tooltips.of(Component.literal("Quantity: ")
                        .append(quantity < Long.MAX_VALUE
                                ? Tooltips.ofNumber(quantity)
                                : Component.literal("Infinite").withStyle(Tooltips.NUMBER_TEXT))));
            } else {
                lines.add(Tooltips.of(Component.literal("Empty")));
            }

            // Infinity cells are pre-configured and never have filter mismatches
            if (filterItem != null) {
                if (storedItem == null) {
                    lines.add(Tooltips.of(Component.literal("Partitioned For: ").append(filterItem.getDisplayName())));
                }
                // Don't show mismatched filter for infinity cells
            } else {
                if (storedItem == null) {
                    lines.add(Tooltips.of(Component.literal("Not Partitioned")));
                }
                // Don't show "Mismatched Filter: Empty" for infinity cells
            }

            lines.add(Tooltips.of(Component.literal("Compression: ")
                    .append(inv.isCompressionEnabled()
                            ? Component.literal("Enabled").withStyle(ChatFormatting.GREEN)
                            : Component.literal("Disabled").withStyle(ChatFormatting.RED))));

            var trace = inv.getTraceUnits();

            if (trace > 0) {
                lines.add(Tooltips.of(
                                inv.isCompressionEnabled()
                                        ? Component.literal("Trace Units: ")
                                                .append(Tooltips.ofNumber(trace))
                                                .append(" ")
                                                .append(inv.getLowestVariant().getHoverName())
                                        : Component.literal("Contains Trace Units"))
                        .withStyle(ChatFormatting.YELLOW));
            }

            if (inv.isCompressionEnabled()) {
                var cutoffItem = inv.getCutoffItem();

                if (!ItemStack.isSameItemSameComponents(cutoffItem, inv.getHighestVariant())) {
                    lines.add(Tooltips.of(Component.literal("Cutoff: ").append(cutoffItem.getHoverName())));
                }
            }
        }
    }

    @NotNull
    @Override
    public Optional<TooltipComponent> getTooltipImage(@NotNull ItemStack is) {
        var inv = (InfinityBulkCellInventory) HANDLER.getCellInventory(is, null);

        if (inv == null) {
            return Optional.empty();
        }

        var upgrades = new ArrayList<ItemStack>();
        var content = new ArrayList<GenericStack>();

        if (AEConfig.instance().isTooltipShowCellUpgrades() && inv.isCompressionEnabled()) {
            var compressionCard = BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("megacells", "compression_card"));
            if (compressionCard != null) {
                upgrades.add(compressionCard.getDefaultInstance());
            }
        }

        if (AEConfig.instance().isTooltipShowCellContent()) {
            if (inv.getStoredItem() != null) {
                content.add(new GenericStack(inv.getStoredItem(), inv.getStoredQuantity()));
            } else if (inv.getFilterItem() != null) {
                content.add(new GenericStack(inv.getFilterItem(), 0));
            }
        }

        return Optional.of(new StorageCellTooltipComponent(upgrades, content, false, true));
    }

    @Override
    public FuzzyMode getFuzzyMode(ItemStack itemStack) {
        return null;
    }

    @Override
    public void setFuzzyMode(ItemStack itemStack, FuzzyMode fuzzyMode) {}

    private static class Handler implements ICellHandler {
        private Handler() {}

        @Override
        public boolean isCell(ItemStack is) {
            return is != null && is.getItem() instanceof InfinityBulkCellItem;
        }

        @Nullable
        @Override
        public InfinityBulkCellInventory getCellInventory(ItemStack is, @Nullable ISaveProvider host) {
            return isCell(is) ? new InfinityBulkCellInventory(is, host) : null;
        }
    }
}