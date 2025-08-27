package com.samiyuru.samiaeinfinity.misc;

import net.minecraft.world.item.ItemStack;

import appeng.api.storage.cells.ICellWorkbenchItem;

public interface CellWorkbenchHost {
    ICellWorkbenchItem getCell();

    ItemStack infinity$getContainedStack();

    void saveChanges();
}