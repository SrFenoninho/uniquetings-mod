package com.uniquetings.mod;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class RecipeStacked implements IRecipe {
    public final ItemStack[] input;
    private final ItemStack output;

    public RecipeStacked(ItemStack[] input, ItemStack output) {
        this.input = input;
        this.output = output;
    }
    @Override
    public boolean matches(InventoryCrafting inv, World world) {
        for (int i = 0; i < 9; ++i) {
            ItemStack required = this.input[i];
            ItemStack inSlot = inv.getStackInSlot(i);

            if (required != null) {
                if (inSlot == null) return false;
                if (inSlot.getItem() != required.getItem() || inSlot.getItemDamage() != required.getItemDamage()) return false;
                if (inSlot.stackSize < required.stackSize) return false;
            }else if (inSlot != null) {
                return false;
            }
        }
        return true;
    }
    @Override
    public ItemStack getCraftingResult(InventoryCrafting inv) { return this.output.copy(); }
    @Override
    public int getRecipeSize() { return 9; }
    @Override
    public ItemStack getRecipeOutput() { return this.output; }
}