package com.uniquetings.mod.nei;

import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;
import com.uniquetings.mod.Uniquetings;

public class NEIUniquetingsConfig implements IConfigureNEI {
    @Override
    public void loadConfig() {
        API.registerRecipeHandler(new StackedRecipeHandler());
        API.registerUsageHandler(new StackedRecipeHandler());
    }

    @Override
    public String getName() {
        return Uniquetings.MODID;
    }

    @Override
    public String getVersion() {
        return Uniquetings.VERSION;
    }
}
