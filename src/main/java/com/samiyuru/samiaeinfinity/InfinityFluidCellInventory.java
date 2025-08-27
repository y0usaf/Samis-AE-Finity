package com.samiyuru.samiaeinfinity;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

import appeng.api.config.Actionable;
import appeng.api.networking.security.IActionSource;
import appeng.api.stacks.AEKey;
import appeng.api.stacks.KeyCounter;
import appeng.api.storage.cells.CellState;
import appeng.api.storage.cells.ICellHandler;
import appeng.api.storage.cells.ISaveProvider;
import appeng.api.storage.cells.StorageCell;

public class InfinityFluidCellInventory implements StorageCell {
    
    public static final ICellHandler HANDLER = new Handler();
    
    private final ItemStack stack;
    private final AEKey storedKey;
    
    public InfinityFluidCellInventory(ItemStack stack, ISaveProvider container) {
        this.stack = stack;
        
        if (stack.getItem() instanceof InfinityFluidCellItem fluidCell) {
            this.storedKey = fluidCell.getStoredKey();
        } else {
            this.storedKey = null;
        }
    }
    
    @Override
    public CellState getStatus() {
        return storedKey != null ? CellState.NOT_EMPTY : CellState.EMPTY;
    }
    
    @Override
    public double getIdleDrain() {
        return 1.0; // Lower drain for fluid cells
    }
    
    @Override
    public void getAvailableStacks(KeyCounter out) {
        if (storedKey != null) {
            out.add(storedKey, Long.MAX_VALUE);
        }
    }
    
    @Override
    public long insert(AEKey what, long amount, Actionable mode, IActionSource source) {
        // Only accept the stored fluid type
        if (storedKey != null && what.equals(storedKey)) {
            return amount; // Accept infinite amounts
        }
        return 0;
    }
    
    @Override
    public long extract(AEKey what, long amount, Actionable mode, IActionSource source) {
        // Only provide the stored fluid type  
        if (storedKey != null && what.equals(storedKey)) {
            return amount; // Provide infinite amounts
        }
        return 0;
    }
    
    @Override
    public boolean isPreferredStorageFor(AEKey what, IActionSource source) {
        return storedKey != null && what.equals(storedKey);
    }
    
    @Override
    public boolean canFitInsideCell() {
        return false; // Infinity cells cannot be nested
    }
    
    @Override
    public Component getDescription() {
        return stack.getHoverName();
    }
    
    @Override
    public void persist() {
        // Stateless - no persistence needed
    }
    
    public static class Handler implements ICellHandler {
        
        @Override
        public boolean isCell(ItemStack is) {
            return is.getItem() instanceof InfinityFluidCellItem;
        }
        
        @Override
        public StorageCell getCellInventory(ItemStack is, ISaveProvider host) {
            if (isCell(is)) {
                return new InfinityFluidCellInventory(is, host);
            }
            return null;
        }
    }
}