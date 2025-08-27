package com.samiyuru.samiaeinfinity;

import java.math.BigInteger;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import appeng.api.config.Actionable;
import appeng.api.networking.security.IActionSource;
import appeng.api.stacks.AEItemKey;
import appeng.api.stacks.AEKey;
import appeng.api.stacks.KeyCounter;
import appeng.api.storage.cells.CellState;
import appeng.api.storage.cells.ISaveProvider;
import appeng.api.storage.cells.StorageCell;

public class InfinityCellInventory implements StorageCell {
    private final ISaveProvider container;
    private final ItemStack stack;
    private AEItemKey storedItem;
    private final AEItemKey filterItem;
    private boolean isPersisted = true;

    InfinityCellInventory(ItemStack stack, ISaveProvider container) {
        this.stack = stack;
        this.container = container;

        var cell = (InfinityCellItem) stack.getItem();
        filterItem = (AEItemKey) cell.getConfigInventory(stack).getKey(0);

        storedItem = (AEItemKey) stack.get(InfinityComponents.BULK_CELL_ITEM);
        
        // For infinity cells, initialize with filter item if available
        if (storedItem == null) {
            // Default to water bucket for water cells, milk bucket for milk cells
            storedItem = filterItem != null ? filterItem : AEItemKey.of(Items.WATER_BUCKET);
            stack.set(InfinityComponents.BULK_CELL_ITEM, storedItem);
        }
        
        System.out.println("InfinityCellInventory Debug:");
        System.out.println("  Stored Item: " + storedItem);
        System.out.println("  Filter Item: " + filterItem);
    }

    @Override
    public CellState getStatus() {
        if (storedItem == null) {
            return CellState.EMPTY;
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

    @Override
    public double getIdleDrain() {
        return 3.0f; // Lower drain than bulk cells since no compression
    }

    @Override
    public long insert(AEKey what, long amount, Actionable mode, IActionSource source) {
        if (amount == 0 || !(what instanceof AEItemKey item)) {
            return 0;
        }

        // Only accept the stored item
        if (!item.equals(storedItem)) {
            return 0;
        }

        if (mode == Actionable.MODULATE) {
            saveChanges();
        }

        return amount;
    }

    @Override
    public long extract(AEKey what, long amount, Actionable mode, IActionSource source) {
        if (storedItem == null || !(what instanceof AEItemKey item)) {
            return 0;
        }

        // Only provide the stored item
        if (!item.equals(storedItem)) {
            return 0;
        }

        if (mode == Actionable.MODULATE) {
            saveChanges();
        }

        return amount; // Infinite amount available
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

        if (storedItem == null) {
            stack.remove(InfinityComponents.BULK_CELL_ITEM);
        } else {
            stack.set(InfinityComponents.BULK_CELL_ITEM, storedItem);
        }

        isPersisted = true;
    }

    @Override
    public void getAvailableStacks(KeyCounter out) {
        if (storedItem != null) {
            out.add(storedItem, Long.MAX_VALUE);
            System.out.println("getAvailableStacks: Adding infinite " + storedItem);
        }
    }

    @Override
    public boolean isPreferredStorageFor(AEKey what, IActionSource source) {
        return what instanceof AEItemKey item && item.equals(storedItem);
    }

    @Override
    public boolean canFitInsideCell() {
        return false; // Infinity cells cannot be nested
    }

    @Override
    public Component getDescription() {
        return stack.getHoverName();
    }
}