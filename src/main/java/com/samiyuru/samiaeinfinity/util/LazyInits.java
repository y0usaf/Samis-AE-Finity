package com.samiyuru.samiaeinfinity.util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;

import appeng.api.stacks.AEFluidKey;
import appeng.api.stacks.AEItemKey;
import appeng.api.stacks.AEKey;

public class LazyInits {
    
    private static final List<Runnable> commonInits = new ArrayList<>();
    private static final List<Runnable> finalInits = new ArrayList<>();
    
    /**
     * Add a task to run during common setup (for client-side operations like model registration)
     */
    public static void addCommon(Runnable task) {
        commonInits.add(task);
    }
    
    /**
     * Add a task to run during load complete (for final AE key resolution)
     */
    public static void addFinal(Runnable task) {
        finalInits.add(task);
    }
    
    /**
     * Initialize common setup tasks
     */
    public static void initCommon() {
        commonInits.forEach(Runnable::run);
        commonInits.clear();
    }
    
    /**
     * Initialize final setup tasks
     */
    public static void initFinal() {
        finalInits.forEach(Runnable::run);
        finalInits.clear();
    }
    
    /**
     * Create a supplier for an item AE key that will be resolved later
     */
    public static Supplier<AEKey> createItemKeySupplier(ResourceLocation itemId) {
        return () -> {
            var item = BuiltInRegistries.ITEM.get(itemId);
            return item != null ? AEItemKey.of(item) : null;
        };
    }
    
    /**
     * Create a supplier for a fluid AE key that will be resolved later
     */
    public static Supplier<AEKey> createFluidKeySupplier(ResourceLocation fluidId) {
        return () -> {
            var fluid = BuiltInRegistries.FLUID.get(fluidId);
            return fluid != null ? AEFluidKey.of(fluid) : null;
        };
    }
}