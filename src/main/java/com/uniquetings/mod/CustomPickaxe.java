package com.uniquetings.mod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

import java.util.List;

public class CustomPickaxe extends ItemPickaxe {
    public CustomPickaxe(ToolMaterial material) {
        super(material);
    }

    @Override
    public void getSubItems(Item item, CreativeTabs tab, List list) {
        ItemStack stack = new ItemStack(item);
        stack.addEnchantment(Enchantment.efficiency, 10);
        list.add(stack);
    }
}
