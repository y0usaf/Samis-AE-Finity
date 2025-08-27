package com.samiyuru.samiaeinfinity.xmod.kjs;

import java.util.function.Supplier;

import dev.latvian.mods.kubejs.item.ItemBuilder;
import dev.latvian.mods.kubejs.typings.Info;
import dev.latvian.mods.rhino.util.ReturnsSelf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import com.samiyuru.samiaeinfinity.util.LazyInits;
import com.samiyuru.samiaeinfinity.InfinityBulkCellItem;
import com.samiyuru.samiaeinfinity.xmod.kjs.KJSInfinityItemCell;

import appeng.api.stacks.AEItemKey;
import appeng.api.stacks.AEKey;

public class InfinityItemCellBuilder extends ItemBuilder {
    
    private Supplier<AEKey> keySupplier = () -> null;
    private ResourceLocation cellModel = null;
    
    public InfinityItemCellBuilder(ResourceLocation i) {
        super(i);
    }
    
    @Info("Set the AE key type for this infinity item cell")
    @ReturnsSelf
    public InfinityItemCellBuilder type(Supplier<AEKey> keySupplier) {
        this.keySupplier = keySupplier;
        return this;
    }
    
    @Info("Set this cell to store a specific item type")
    @ReturnsSelf
    public InfinityItemCellBuilder itemType(ResourceLocation itemId) {
        this.keySupplier = LazyInits.createItemKeySupplier(itemId);
        return this;
    }
    
    @Info("Set the cell model to use when displayed in ME drives")
    @ReturnsSelf
    public InfinityItemCellBuilder cellModel(ResourceLocation modelLocation) {
        this.cellModel = modelLocation;
        return this;
    }
    
    @Override
    public Item createObject() {
        var item = new KJSInfinityItemCell(keySupplier);
        
        LazyInits.addCommon(() -> {
            // Register compression card upgrade
            var compressionCard = net.minecraft.core.registries.BuiltInRegistries.ITEM.get(
                net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("megacells", "compression_card")
            );
            if (compressionCard != null) {
                appeng.api.upgrades.Upgrades.add(compressionCard, item, 1);
            }
            
            // Register the cell model for drive display
            if (cellModel != null) {
                appeng.api.client.StorageCellModels.registerModel(item, cellModel);
            }
        });
        
        return item;
    }
}