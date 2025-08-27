package com.samiyuru.samiaeinfinity;

import net.minecraft.world.item.ItemStack;
import java.util.Set;

import appeng.api.config.FuzzyMode;
import appeng.api.stacks.AEKeyType;
import appeng.api.storage.StorageCells;
import appeng.api.storage.cells.ICellHandler;
import appeng.api.storage.cells.ICellWorkbenchItem;
import appeng.api.storage.cells.ISaveProvider;
import appeng.api.storage.cells.StorageCell;
import appeng.api.upgrades.IUpgradeInventory;
import appeng.api.upgrades.UpgradeInventories;
import appeng.items.AEBaseItem;
import appeng.items.contents.CellConfig;
import appeng.util.ConfigInventory;

public class InfinityCellItem extends AEBaseItem implements ICellWorkbenchItem {
    private static final ICellHandler HANDLER = new Handler();

    public InfinityCellItem() {
        super(new Properties().stacksTo(1));
    }

    public static void registerHandler() {
        StorageCells.addCellHandler(HANDLER);
    }

    @Override
    public ConfigInventory getConfigInventory(ItemStack is) {
        return CellConfig.create(Set.of(AEKeyType.items()), is, 0); // No config slots
    }

    @Override
    public IUpgradeInventory getUpgrades(ItemStack is) {
        return UpgradeInventories.forItem(is, 0); // No upgrades
    }

    @Override
    public void setFuzzyMode(ItemStack is, FuzzyMode fzMode) {
        // No-op
    }

    @Override
    public FuzzyMode getFuzzyMode(ItemStack is) {
        return FuzzyMode.IGNORE_ALL;
    }

    @Override
    public boolean isEditable(ItemStack is) {
        return false;
    }
    
    public StorageCell getCellInventory(ItemStack is, ISaveProvider container) {
        return new InfinityCellInventory(is, container);
    }

    public static class Handler implements appeng.api.storage.cells.ICellHandler {

        @Override
        public boolean isCell(ItemStack is) {
            return is.getItem() instanceof InfinityCellItem;
        }

        @Override
        public StorageCell getCellInventory(ItemStack is, ISaveProvider host) {
            if (isCell(is)) {
                return ((InfinityCellItem) is.getItem()).getCellInventory(is, host);
            }
            return null;
        }
    }
}