package com.uniquetings.mod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class SuperShinyBlock extends Block {
    public SuperShinyBlock() {

        super(Material.rock);

        setCreativeTab(CreativeTabs.tabBlock);
        setBlockName("super_shiny_block");
        setBlockTextureName(Uniquetings.MODID + ":super_shiny_block");

        setHardness(50.0F);
        setResistance(2000.0F);
        setHarvestLevel("pickaxe", 3);
    }
}
