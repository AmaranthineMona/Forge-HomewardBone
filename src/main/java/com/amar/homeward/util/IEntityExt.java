package com.amar.homeward.util;

import net.minecraft.core.BlockPos;

public interface IEntityExt {
    void updateBonfire(BlockPos bonfirePos);

    BlockPos getBonfirePos();
}
