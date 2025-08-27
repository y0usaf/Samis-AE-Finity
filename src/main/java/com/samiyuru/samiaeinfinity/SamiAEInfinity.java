package com.samiyuru.samiaeinfinity;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.minecraft.world.item.Items;
import appeng.api.stacks.AEItemKey;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

import appeng.api.upgrades.Upgrades;
import appeng.api.storage.StorageCells;

import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;

import com.samiyuru.samiaeinfinity.misc.CompressionService;
import com.samiyuru.samiaeinfinity.network.SyncCompressionChainsPacket;
import com.samiyuru.samiaeinfinity.util.LazyInits;

import java.util.function.Supplier;

@Mod(SamiAEInfinity.MODID)
public class SamiAEInfinity {
    public static final String MODID = "samisaeinfinity";
    
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(BuiltInRegistries.ITEM, MODID);
    private static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);
    
    // Infinity cell items
    public static final Supplier<InfinityBulkCellItem> INFINITY_COBBLESTONE_CELL = ITEMS.register("sami_item_cobblestone_cell", InfinityBulkCellItem::new);
    public static final Supplier<InfinityFluidCellItem> INFINITY_WATER_CELL = ITEMS.register("sami_fluid_water_cell", () -> InfinityFluidCellItem.forFluid(Fluids.WATER));
    public static final Supplier<InfinityFluidCellItem> INFINITY_MILK_CELL = ITEMS.register("sami_fluid_milk_cell", () -> InfinityFluidCellItem.forFluid(NeoForgeMod.MILK.get()));
    
    public static final Supplier<CreativeModeTab> INFINITY_TAB = CREATIVE_MODE_TABS.register("main", 
        () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.samisaeinfinity.main"))
            .icon(() -> new ItemStack(INFINITY_COBBLESTONE_CELL.get()))
            .displayItems((parameters, output) -> {
                output.accept(INFINITY_COBBLESTONE_CELL.get());
                output.accept(INFINITY_WATER_CELL.get());
                output.accept(INFINITY_MILK_CELL.get());
            })
            .build()
    );
    
    public SamiAEInfinity(IEventBus modEventBus, ModContainer modContainer) {
        // Enable NeoForge milk fluid
        NeoForgeMod.enableMilkFluid();
        
        ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);
        InfinityComponents.DR.register(modEventBus);
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::loadComplete);
        modEventBus.addListener(this::initPacketHandlers);
    }
    
    private void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            // Register storage cell handlers
            InfinityBulkCellItem.registerHandler();
            InfinityCellItem.registerHandler();
            StorageCells.addCellHandler(InfinityFluidCellInventory.HANDLER);
            
            // Register MEGACells compression card upgrade for infinity cells
            var compressionCard = BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("megacells", "compression_card"));
            if (compressionCard != null) {
                Upgrades.add(compressionCard, INFINITY_COBBLESTONE_CELL.get(), 1);
            }
        });
        
        // Initialize compression service
        CompressionService.init();
        
        // Initialize KJS lazy inits for common setup
        LazyInits.initCommon();
    }
    
    private void loadComplete(FMLLoadCompleteEvent event) {
        event.enqueueWork(() -> {
            // Initialize KJS lazy inits for final setup
            LazyInits.initFinal();
        });
    }
    
    private void initPacketHandlers(RegisterPayloadHandlersEvent event) {
        var registrar = event.registrar("2");
        registrar.playToClient(
                SyncCompressionChainsPacket.TYPE,
                SyncCompressionChainsPacket.STREAM_CODEC,
                CompressionService::syncToClient);
    }
}