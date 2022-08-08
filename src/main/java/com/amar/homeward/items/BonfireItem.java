package com.amar.homeward.items;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

public class BonfireItem extends Item {

    public BonfireItem(){
        super(new BonfireItem.Properties().tab(CreativeModeTab.TAB_MISC));
    }

    public BonfireItem(Properties properties) {
        super(properties);
    }
    
}
