package com.amar.homeward.init;

import com.amar.homeward.HomewardMod;
import com.amar.homeward.blocks.BonfireBlock;
import com.amar.homeward.items.BonfireItem;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BonfireInit {
        public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
        HomewardMod.MOD_ID);
public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
        HomewardMod.MOD_ID);

    public static final RegistryObject<Block> BONFIRE_BLOCK = BLOCKS.register("bonfire",
            () -> new BonfireBlock());
    public static final RegistryObject<Item> BONFIRE_ITEM = ITEMS.register("bonfire",
            () -> new BonfireItem());
}
