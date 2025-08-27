package com.samiyuru.samiaeinfinity.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.MenuType;

import appeng.api.storage.StorageCells;
import appeng.blockentity.misc.CellWorkbenchBlockEntity;
import appeng.menu.implementations.CellWorkbenchMenu;
import appeng.menu.implementations.UpgradeableMenu;

import com.samiyuru.samiaeinfinity.InfinityBulkCellInventory;
import com.samiyuru.samiaeinfinity.menu.CompressionCutoffHost;
import com.samiyuru.samiaeinfinity.misc.CellWorkbenchHost;

@Mixin(CellWorkbenchMenu.class)
public abstract class CellWorkbenchMenuMixin extends UpgradeableMenu<CellWorkbenchBlockEntity>
        implements CompressionCutoffHost {
    public CellWorkbenchMenuMixin(MenuType<?> menuType, int id, Inventory ip, CellWorkbenchBlockEntity host) {
        super(menuType, id, ip, host);
    }

    @Inject(method = "<init>", at = @At("RETURN"))
    private void registerAction(int id, Inventory ip, CellWorkbenchBlockEntity te, CallbackInfo ci) {
        registerClientAction(ACTION_SET_COMPRESSION_LIMIT, Boolean.class, this::infinity$nextCompressionLimit);
    }

    @Override
    public void infinity$nextCompressionLimit(boolean backwards) {
        if (isClientSide()) {
            sendClientAction(ACTION_SET_COMPRESSION_LIMIT, backwards);
        } else {
            if (StorageCells.getCellInventory(((CellWorkbenchHost) getHost()).infinity$getContainedStack(), null)
                    instanceof InfinityBulkCellInventory bulkCell) {
                bulkCell.switchCompressionCutoff(backwards);
                getHost().saveChanges();
            }
        }
    }
}