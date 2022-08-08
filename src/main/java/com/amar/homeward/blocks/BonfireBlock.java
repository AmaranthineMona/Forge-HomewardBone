package com.amar.homeward.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;

public class BonfireBlock extends Block{

    public BonfireBlock(){
        super(BonfireBlock.Properties.of(Material.STONE).strength(1.0f).noOcclusion().requiresCorrectToolForDrops().lightLevel((state) -> 12));
    }

    public BonfireBlock(Properties properties) {
        super(properties);
    }
    
}
