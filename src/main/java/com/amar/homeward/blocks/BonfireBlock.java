package com.amar.homeward.blocks;

import com.amar.homeward.util.IEntityExt;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;

public class BonfireBlock extends Block {

    public BonfireBlock() {
        super(BonfireBlock.Properties.of(Material.STONE).strength(1.0f).noOcclusion().requiresCorrectToolForDrops()
                .lightLevel((state) -> 12));
    }

    public BonfireBlock(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState blockState, Level world, BlockPos blockPos, Player player,
            InteractionHand hand, BlockHitResult blockHitResult) {
                if (!world.isClientSide){
                    ((IEntityExt) player).updateBonfire(blockPos); 
                }
        return InteractionResult.SUCCESS;
    }
}
