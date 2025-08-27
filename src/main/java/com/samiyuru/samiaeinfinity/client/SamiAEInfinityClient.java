package com.samiyuru.samiaeinfinity.client;

import com.samiyuru.samiaeinfinity.SamiAEInfinity;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

import appeng.api.client.StorageCellModels;

@Mod(value = SamiAEInfinity.MODID, dist = Dist.CLIENT)
public class SamiAEInfinityClient {
    
    public SamiAEInfinityClient(IEventBus modEventBus) {
        modEventBus.addListener(this::commonSetup);
    }
    
    private void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            // Register storage cell models for ME drive display
            StorageCellModels.registerModel(
                SamiAEInfinity.INFINITY_COBBLESTONE_CELL.get(),
                ResourceLocation.fromNamespaceAndPath(SamiAEInfinity.MODID, "block/drive/cells/sami_item_cobblestone_cell")
            );
            StorageCellModels.registerModel(
                SamiAEInfinity.INFINITY_WATER_CELL.get(),
                ResourceLocation.fromNamespaceAndPath(SamiAEInfinity.MODID, "block/drive/cells/sami_fluid_water_cell")
            );
            StorageCellModels.registerModel(
                SamiAEInfinity.INFINITY_MILK_CELL.get(),
                ResourceLocation.fromNamespaceAndPath(SamiAEInfinity.MODID, "block/drive/cells/sami_fluid_milk_cell")
            );
        });
    }
}