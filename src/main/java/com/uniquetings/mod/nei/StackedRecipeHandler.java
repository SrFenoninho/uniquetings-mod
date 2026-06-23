package com.uniquetings.mod.nei;

import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.ShapedRecipeHandler;
import com.uniquetings.mod.RecipeStacked;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;

import java.util.ArrayList;
import java.util.List;

public class StackedRecipeHandler extends ShapedRecipeHandler {

    public class CachedStackedRecipe extends CachedRecipe {
        public ArrayList<PositionedStack> ingredients;
        public PositionedStack result;

        public CachedStackedRecipe(RecipeStacked recipe) {
            result = new PositionedStack(recipe.getRecipeOutput(), 119, 24);
            ingredients = new ArrayList<PositionedStack>();

            ItemStack[] items = recipe.input;
            for (int x = 0; x < 3; x++) {
                for (int y = 0; y < 3; y++) {
                    if (items[y * 3 + x] != null) {
                        PositionedStack stack = new PositionedStack(items[y * 3 + x], 25 + x * 18, 6 + y * 18, false);
                        ingredients.add(stack);
                    }
                }
            }
        }

        @Override
        public PositionedStack getResult() {
            return result;
        }

        @Override
        public List<PositionedStack> getIngredients() {
            return getCycledIngredients(cycleticks / 20, ingredients);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void loadCraftingRecipes(String outputId, Object... results) {
        if (outputId.equals("crafting") && getClass() == StackedRecipeHandler.class) {
            List<IRecipe> allrecipes = CraftingManager.getInstance().getRecipeList();
            for (IRecipe irecipe : allrecipes) {
                if (irecipe instanceof RecipeStacked) {
                    arecipes.add(new CachedStackedRecipe((RecipeStacked) irecipe));
                }
            }
        } else {
            super.loadCraftingRecipes(outputId, results);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void loadCraftingRecipes(ItemStack result) {
        List<IRecipe> allrecipes = CraftingManager.getInstance().getRecipeList();
        for (IRecipe irecipe : allrecipes) {
            if (irecipe instanceof RecipeStacked) {
                if (NEIServerUtils.areStacksSameTypeCrafting(irecipe.getRecipeOutput(), result)) {
                    arecipes.add(new CachedStackedRecipe((RecipeStacked) irecipe));
                }
            }
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void loadUsageRecipes(ItemStack ingredient) {
        List<IRecipe> allrecipes = CraftingManager.getInstance().getRecipeList();
        for (IRecipe irecipe : allrecipes) {
            if (irecipe instanceof RecipeStacked) {
                CachedStackedRecipe crecipe = new CachedStackedRecipe((RecipeStacked) irecipe);
                if (crecipe.contains(crecipe.ingredients, ingredient)) {
                    crecipe.setIngredientPermutation(crecipe.ingredients, ingredient);
                    arecipes.add(crecipe);
                }
            }
        }
    }
}
