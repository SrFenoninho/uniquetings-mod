package com.uniquetings.mod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.block.Block;
import net.minecraftforge.common.util.EnumHelper;

@Mod(modid = Uniquetings.MODID, version = Uniquetings.VERSION, name = "Uniquetings")
public class Uniquetings {
    public static final String MODID = "uniquetings";
    public static final String VERSION = "0.4";

    public static Item.ToolMaterial SWORD_MAT = EnumHelper.addToolMaterial("SWORD_MAT", 3, 0, 10.0F, 56.0F, 22);
    public static Item.ToolMaterial PICKAXE_MAT = EnumHelper.addToolMaterial("PICKAXE_MAT", 3, 0, 10.0F, 6.0F, 22);

    public static Item super_shiny_sword;
    public static Item gem_obliterator;
    public static Item hot_coal;
    public static Item hard_iron;
    public static Item shiny_gold;
    public static Item energetic_redstone;
    public static Item lucky_lapis;
    public static Item shiny_emerald;
    public static Item shiny_diamond;
    public static Item super_shiny_ore;
    public static Block super_shiny_block;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        super_shiny_sword = new CustomSword(SWORD_MAT)
                .setUnlocalizedName("super_shiny_sword")
                .setTextureName(MODID + ":super_shiny_sword")
                .setCreativeTab(CreativeTabs.tabCombat);
        GameRegistry.registerItem(super_shiny_sword, "super_shiny_sword");

        gem_obliterator = new CustomPickaxe(PICKAXE_MAT)
                .setUnlocalizedName("gem_obliterator")
                .setTextureName(MODID + ":gem_obliterator")
                .setCreativeTab(CreativeTabs.tabTools);
        GameRegistry.registerItem(gem_obliterator, "gem_obliterator");

        hot_coal = new GlowingItem().setUnlocalizedName("hot_coal").setTextureName("minecraft:coal").setCreativeTab(CreativeTabs.tabMaterials);
        GameRegistry.registerItem(hot_coal, "hot_coal");

        hard_iron = new GlowingItem().setUnlocalizedName("hard_iron").setTextureName("minecraft:iron_ingot").setCreativeTab(CreativeTabs.tabMaterials);
        GameRegistry.registerItem(hard_iron, "hard_iron");

        shiny_gold = new GlowingItem().setUnlocalizedName("shiny_gold").setTextureName("minecraft:gold_ingot").setCreativeTab(CreativeTabs.tabMaterials);
        GameRegistry.registerItem(shiny_gold, "shiny_gold");

        energetic_redstone = new GlowingItem().setUnlocalizedName("energetic_redstone").setTextureName("minecraft:redstone_dust").setCreativeTab(CreativeTabs.tabMaterials);
        GameRegistry.registerItem(energetic_redstone, "energetic_redstone");

        lucky_lapis = new GlowingItem().setUnlocalizedName("lucky_lapis").setTextureName("minecraft:dye_powder_blue").setCreativeTab(CreativeTabs.tabMaterials);
        GameRegistry.registerItem(lucky_lapis, "lucky_lapis");

        shiny_emerald = new GlowingItem().setUnlocalizedName("shiny_emerald").setTextureName("minecraft:emerald").setCreativeTab(CreativeTabs.tabMaterials);
        GameRegistry.registerItem(shiny_emerald, "shiny_emerald");

        shiny_diamond = new GlowingItem().setUnlocalizedName("shiny_diamond").setTextureName("minecraft:diamond").setCreativeTab(CreativeTabs.tabMaterials);
        GameRegistry.registerItem(shiny_diamond, "shiny_diamond");

        super_shiny_ore = new GlowingItem().setUnlocalizedName("super_shiny_ore").setTextureName(MODID + ":super_shiny_ore").setCreativeTab(CreativeTabs.tabMaterials);
        GameRegistry.registerItem(super_shiny_ore, "super_shiny_ore");

        super_shiny_block = new SuperShinyBlock();
        GameRegistry.registerBlock(super_shiny_block, "super_shiny_block");

        FMLCommonHandler.instance().bus().register(this);

        ItemStack c5 = new ItemStack(Items.coal, 5);
        GameRegistry.addRecipe(new RecipeStacked(new ItemStack[]{null, c5, null, c5, c5, c5, null, c5, null}, new ItemStack(hot_coal)));

        ItemStack i5 = new ItemStack(Items.iron_ingot, 5);
        GameRegistry.addRecipe(new RecipeStacked(new ItemStack[]{null, i5, null, i5, i5, i5, null, i5, null}, new ItemStack(hard_iron)));

        ItemStack g5 = new ItemStack(Items.gold_ingot, 5);
        GameRegistry.addRecipe(new RecipeStacked(new ItemStack[]{null, g5, null, g5, g5, g5, null, g5, null}, new ItemStack(shiny_gold)));

        ItemStack r5 = new ItemStack(Items.redstone, 5);
        GameRegistry.addRecipe(new RecipeStacked(new ItemStack[]{null, r5, null, r5, r5, r5, null, r5, null}, new ItemStack(energetic_redstone)));

        ItemStack l5 = new ItemStack(Items.dye, 5, 4);
        GameRegistry.addRecipe(new RecipeStacked(new ItemStack[]{null, l5, null, l5, l5, l5, null, l5, null}, new ItemStack(lucky_lapis)));

        ItemStack e5 = new ItemStack(Items.emerald, 5);
        GameRegistry.addRecipe(new RecipeStacked(new ItemStack[]{null, e5, null, e5, e5, e5, null, e5, null}, new ItemStack(shiny_emerald)));

        ItemStack d5 = new ItemStack(Items.diamond, 5);
        GameRegistry.addRecipe(new RecipeStacked(new ItemStack[]{null, d5, null, d5, d5, d5, null, d5, null}, new ItemStack(shiny_diamond)));

        ItemStack[] superOreRecipe = new ItemStack[] {
                new ItemStack(hot_coal, 15), new ItemStack(hard_iron, 15), new ItemStack(shiny_gold, 15),
                new ItemStack(energetic_redstone, 15), new ItemStack(lucky_lapis, 15), new ItemStack(shiny_emerald, 15),
                new ItemStack(shiny_diamond, 15), null, null
        };
        GameRegistry.addRecipe(new RecipeStacked(superOreRecipe, new ItemStack(super_shiny_ore)));

        ItemStack d64 = new ItemStack(shiny_diamond, 64);
        ItemStack o1 = new ItemStack(shiny_gold, 1);
        ItemStack[] picaretaRecipe = new ItemStack[] {
                d64, d64, d64,
                null, o1, null,
                null, o1, null
        };
        ItemStack pickaxeResult = new ItemStack(gem_obliterator);
        pickaxeResult.addEnchantment(net.minecraft.enchantment.Enchantment.efficiency, 10);
        GameRegistry.addRecipe(new RecipeStacked(picaretaRecipe, pickaxeResult));

        GameRegistry.addRecipe(new ItemStack(super_shiny_block),
                "OOO",
                "OOO",
                "OOO",
                'O', super_shiny_ore
        );

        GameRegistry.addShapelessRecipe(new ItemStack(super_shiny_ore, 9), super_shiny_block);

        ItemStack swordResult = new ItemStack(super_shiny_sword);
        swordResult.addEnchantment(net.minecraft.enchantment.Enchantment.sharpness, 5);
        swordResult.addEnchantment(net.minecraft.enchantment.Enchantment.fireAspect, 5);
        swordResult.addEnchantment(net.minecraft.enchantment.Enchantment.looting, 5);

        GameRegistry.addRecipe(swordResult,
                " B ",
                " B ",
                " S ",
                'B', super_shiny_block, 'S', Items.stick
        );
        GameRegistry.registerFuelHandler(new FuelHandler());
    }

    @SubscribeEvent
    public void onCrafting(ItemCraftedEvent event) {
        Item item = event.crafting.getItem();

        if (item == hot_coal || item == hard_iron || item == shiny_gold || item == energetic_redstone || item == lucky_lapis || item == shiny_emerald || item == shiny_diamond) {
            for (int i = 0; i < event.craftMatrix.getSizeInventory(); i++) {
                if (event.craftMatrix.getStackInSlot(i) != null) event.craftMatrix.decrStackSize(i, 4);
            }
        }

        if (item == super_shiny_ore) {
            for (int i = 0; i < event.craftMatrix.getSizeInventory(); i++) {
                if (event.craftMatrix.getStackInSlot(i) != null) event.craftMatrix.decrStackSize(i, 14);
            }
        }

        if (item == gem_obliterator) {
            for (int i = 0; i < 3; i++) {
                if (event.craftMatrix.getStackInSlot(i) != null) event.craftMatrix.decrStackSize(i, 63);
            }
        }
    }

    @SubscribeEvent
    public void forceRecipeUpdate(PlayerTickEvent event) {
        if (event.player.openContainer instanceof net.minecraft.inventory.ContainerWorkbench) {
            net.minecraft.inventory.ContainerWorkbench workbench = (net.minecraft.inventory.ContainerWorkbench) event.player.openContainer;

            for (Object obj : net.minecraft.item.crafting.CraftingManager.getInstance().getRecipeList()) {
                if (obj instanceof RecipeStacked) {
                    RecipeStacked recipe = (RecipeStacked) obj;

                    if (recipe.matches(workbench.craftMatrix, event.player.worldObj)) {
                        workbench.craftResult.setInventorySlotContents(0, recipe.getCraftingResult(workbench.craftMatrix));
                        return;
                    }
                }
            }
        }
    }
}
