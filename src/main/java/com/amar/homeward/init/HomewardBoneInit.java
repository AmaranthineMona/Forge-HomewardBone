package com.amar.homeward.init;

import com.amar.homeward.HomewardMod;
import com.amar.homeward.items.HomewardBoneItem;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class HomewardBoneInit {
public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
    HomewardMod.MOD_ID);

public static final RegistryObject<Item> BONFIRE_ITEM = ITEMS.register("homeward_bone",
        () -> new HomewardBoneItem());
}
