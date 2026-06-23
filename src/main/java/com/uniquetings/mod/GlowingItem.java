package com.uniquetings.mod;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class GlowingItem  extends Item {
    @Override
    public boolean hasEffect(ItemStack stack, int pass) {
        return true;
    }
}
