package com.samiyuru.samiaeinfinity.xmod.kjs;

import dev.latvian.mods.kubejs.plugin.KubeJSPlugin;
import dev.latvian.mods.kubejs.registry.BuilderTypeRegistry;
import net.minecraft.core.registries.Registries;

public class KJSPlugin implements KubeJSPlugin {
    
    @Override
    public void registerBuilderTypes(BuilderTypeRegistry registry) {
        registry.of(
                Registries.ITEM,
                r -> {
                    r.add("sami_infinity_item_cell", InfinityItemCellBuilder.class, InfinityItemCellBuilder::new);
                    r.add("sami_infinity_fluid_cell", InfinityFluidCellBuilder.class, InfinityFluidCellBuilder::new);
                }
        );
    }
}