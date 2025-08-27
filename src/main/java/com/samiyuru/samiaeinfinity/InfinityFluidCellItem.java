package com.samiyuru.samiaeinfinity;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.jetbrains.annotations.NotNull;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.material.Fluid;

import appeng.api.config.FuzzyMode;
import appeng.api.stacks.AEFluidKey;
import appeng.api.stacks.AEKey;
import appeng.api.stacks.GenericStack;
import appeng.api.storage.cells.ICellWorkbenchItem;
import appeng.api.upgrades.IUpgradeInventory;
import appeng.api.upgrades.UpgradeInventories;
import appeng.items.AEBaseItem;
import appeng.items.contents.CellConfig;
import appeng.items.storage.StorageCellTooltipComponent;
import appeng.util.ConfigInventory;

import java.util.Set;
import appeng.api.stacks.AEKeyType;

public class InfinityFluidCellItem extends AEBaseItem implements ICellWorkbenchItem {
    
    private final Supplier<AEKey> keySupplier;
    
    public InfinityFluidCellItem(Supplier<AEKey> keySupplier) {
        super(new Properties().stacksTo(1));
        this.keySupplier = keySupplier;
    }
    
    public AEKey getStoredKey() {
        return keySupplier.get();
    }
    
    @Override
    public ConfigInventory getConfigInventory(ItemStack is) {
        return CellConfig.create(Set.of(AEKeyType.fluids()), is, 1);
    }
    
    @Override
    public IUpgradeInventory getUpgrades(ItemStack is) {
        return UpgradeInventories.forItem(is, 0);
    }
    
    @Override
    public FuzzyMode getFuzzyMode(ItemStack itemStack) {
        return null;
    }
    
    @Override
    public void setFuzzyMode(ItemStack itemStack, FuzzyMode fuzzyMode) {
    }
    
    @Override
    public void appendHoverText(@NotNull ItemStack is, @NotNull TooltipContext context, @NotNull List<Component> lines, @NotNull TooltipFlag flag) {
        var storedKey = getStoredKey();
        if (storedKey != null) {
            lines.add(Component.literal("Contains: ").append(storedKey.getDisplayName()));
            lines.add(Component.literal("Quantity: Infinite").withStyle(ChatFormatting.GREEN));
        }
    }
    
    @NotNull
    @Override
    public Optional<TooltipComponent> getTooltipImage(@NotNull ItemStack stack) {
        var storedKey = getStoredKey();
        if (storedKey != null) {
            var content = Collections.singletonList(new GenericStack(storedKey, getAsIntMax(storedKey)));
            return Optional.of(new StorageCellTooltipComponent(List.of(), content, false, true));
        }
        return Optional.empty();
    }
    
    @Override
    public @NotNull Component getName(@NotNull ItemStack is) {
        var storedKey = getStoredKey();
        if (storedKey != null) {
            return Component.translatable("item.samisaeinfinity.infinity_cell_name", storedKey.getDisplayName());
        }
        return super.getName(is);
    }
    
    public static long getAsIntMax(AEKey key) {
        return (long) Integer.MAX_VALUE * key.getAmountPerUnit();
    }
    
    // Convenience constructor for fluid keys
    public static InfinityFluidCellItem forFluid(Fluid fluid) {
        return new InfinityFluidCellItem(() -> AEFluidKey.of(fluid));
    }
}