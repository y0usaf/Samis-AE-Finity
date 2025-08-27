package com.samiyuru.samiaeinfinity.xmod.kjs;

import java.util.function.Supplier;

import dev.latvian.mods.kubejs.item.ItemBuilder;
import dev.latvian.mods.kubejs.typings.Info;
import dev.latvian.mods.rhino.util.ReturnsSelf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import com.samiyuru.samiaeinfinity.util.LazyInits;
import com.samiyuru.samiaeinfinity.InfinityFluidCellItem;

import appeng.api.stacks.AEFluidKey;
import appeng.api.stacks.AEKey;

public class InfinityFluidCellBuilder extends ItemBuilder {
    
    private Supplier<AEKey> keySupplier = () -> null;
    private ResourceLocation cellModel = null;
    
    public InfinityFluidCellBuilder(ResourceLocation i) {
        super(i);
    }
    
    @Info("Set the AE key type for this infinity fluid cell")
    @ReturnsSelf
    public InfinityFluidCellBuilder type(Supplier<AEKey> keySupplier) {
        this.keySupplier = keySupplier;
        return this;
    }
    
    @Info("Set this cell to store a specific fluid type")
    @ReturnsSelf
    public InfinityFluidCellBuilder fluidType(ResourceLocation fluidId) {
        this.keySupplier = LazyInits.createFluidKeySupplier(fluidId);
        return this;
    }
    
    @Info("Set the cell model to use when displayed in ME drives")
    @ReturnsSelf
    public InfinityFluidCellBuilder cellModel(ResourceLocation modelLocation) {
        this.cellModel = modelLocation;
        return this;
    }
    
    @Override
    public Item createObject() {
        var item = new InfinityFluidCellItem(keySupplier);
        
        if (cellModel != null) {
            LazyInits.addCommon(() -> {
                // Register the cell model for drive display
                appeng.api.client.StorageCellModels.registerModel(item, cellModel);
            });
        }
        
        return item;
    }
}