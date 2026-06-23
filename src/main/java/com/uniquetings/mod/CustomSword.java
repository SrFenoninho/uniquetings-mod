package com.uniquetings.mod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

import java.util.List;

public class CustomSword extends ItemSword {
    public CustomSword(ToolMaterial material) {
        super(material);
    }

    @Override
    public void getSubItems(Item item, CreativeTabs tab, List list) {
        ItemStack stack = new ItemStack(item);
        stack.addEnchantment(Enchantment.sharpness, 5);
        stack.addEnchantment(Enchantment.fireAspect, 5);
        stack.addEnchantment(Enchantment.looting, 5);
        list.add(stack);
    }
}
