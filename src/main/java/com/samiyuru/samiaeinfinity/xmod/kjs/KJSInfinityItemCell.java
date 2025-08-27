package com.samiyuru.samiaeinfinity.xmod.kjs;

import net.minecraft.world.item.ItemStack;
import appeng.api.stacks.AEItemKey;
import appeng.api.stacks.AEKey;
import appeng.api.stacks.AEKeyType;
import appeng.items.contents.CellConfig;
import appeng.util.ConfigInventory;
import com.samiyuru.samiaeinfinity.InfinityBulkCellItem;

import java.util.Set;
import java.util.function.Supplier;

public class KJSInfinityItemCell extends InfinityBulkCellItem {
    
    private final Supplier<AEKey> configuredKeySupplier;
    
    public KJSInfinityItemCell(Supplier<AEKey> keySupplier) {
        this.configuredKeySupplier = keySupplier;
    }
    
    @Override
    public ConfigInventory getConfigInventory(ItemStack is) {
        var config = CellConfig.create(Set.of(AEKeyType.items()), is, 1);
        
        // Pre-configure with the specified item if not already set
        if (config.getKey(0) == null && configuredKeySupplier != null) {
            var configuredKey = configuredKeySupplier.get();
            if (configuredKey instanceof AEItemKey itemKey) {
                var genericStack = new appeng.api.stacks.GenericStack(itemKey, 1);
                config.setStack(0, genericStack);
            }
        }
        
        return config;
    }
}