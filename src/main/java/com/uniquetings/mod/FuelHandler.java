package com.uniquetings.mod;

import cpw.mods.fml.common.IFuelHandler;
import net.minecraft.item.ItemStack;

public class FuelHandler implements IFuelHandler {

    @Override
    public int getBurnTime(ItemStack fuel) {
        if(fuel.getItem() == Uniquetings.hot_coal){
            return 40000;
        }
        return 0;
    }
}
