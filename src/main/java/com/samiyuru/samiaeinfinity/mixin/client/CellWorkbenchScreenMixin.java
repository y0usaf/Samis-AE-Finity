package com.samiyuru.samiaeinfinity.mixin.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

import appeng.api.storage.StorageCells;
import appeng.client.gui.AEBaseScreen;
import appeng.client.gui.implementations.CellWorkbenchScreen;
import appeng.client.gui.style.ScreenStyle;
import appeng.menu.implementations.CellWorkbenchMenu;

import com.samiyuru.samiaeinfinity.InfinityBulkCellInventory;
import com.samiyuru.samiaeinfinity.client.screen.CompressionCutoffButton;
import com.samiyuru.samiaeinfinity.menu.CompressionCutoffHost;
import com.samiyuru.samiaeinfinity.misc.CellWorkbenchHost;

@Mixin(CellWorkbenchScreen.class)
public abstract class CellWorkbenchScreenMixin extends AEBaseScreen<CellWorkbenchMenu> {
    @Unique
    private CompressionCutoffButton infinity$compressionCutoff;

    public CellWorkbenchScreenMixin(
            CellWorkbenchMenu menu, Inventory playerInventory, Component title, ScreenStyle style) {
        super(menu, playerInventory, title, style);
    }

    @Inject(method = "<init>", at = @At("RETURN"))
    private void initCutoffButton(
            CellWorkbenchMenu menu, Inventory playerInventory, Component title, ScreenStyle style, CallbackInfo ci) {
        infinity$compressionCutoff = addToLeftToolbar(new CompressionCutoffButton(
                button -> ((CompressionCutoffHost) menu).infinity$nextCompressionLimit(isHandlingRightClick())));
    }

    @Inject(method = "updateBeforeRender", at = @At("RETURN"))
    private void updateCutoffButton(CallbackInfo ci) {
        if (StorageCells.getCellInventory(((CellWorkbenchHost) menu.getHost()).infinity$getContainedStack(), null)
                        instanceof InfinityBulkCellInventory bulkCell
                && bulkCell.hasCompressionChain()) {
            infinity$compressionCutoff.setVisibility(bulkCell.isCompressionEnabled());
            infinity$compressionCutoff.setItem(bulkCell.getCutoffItem());
        } else {
            infinity$compressionCutoff.setVisibility(false);
        }
    }
}