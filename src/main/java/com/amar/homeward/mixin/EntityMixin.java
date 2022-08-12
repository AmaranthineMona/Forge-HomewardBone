package com.amar.homeward.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.At;

import com.amar.homeward.util.IEntityExt;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;

@Mixin(Entity.class)
public class EntityMixin implements IEntityExt {
    private int[] blockPos;

    @Override
    public void updateBonfire(BlockPos bonfirePos) {
        if (bonfirePos != null) {
            this.blockPos = new int[] { bonfirePos.getX(), bonfirePos.getY(), bonfirePos.getZ() };
        } else {
            this.blockPos = null;
        }
    }

    @Override
    public BlockPos getBonfirePos() {
        if (this.blockPos != null) {
            return new BlockPos(this.blockPos[0], this.blockPos[1], this.blockPos[2]);
        } else {
            return null;
        }
    }

    @Inject(method = "writeNbt", at = @At("HEAD"))
    public void writeNbt(CompoundTag tag, CallbackInfoReturnable ci) {
        if (this.getBonfirePos() != null) {
            var bonfirePos = this.getBonfirePos();
            tag.putIntArray("homeAnchorPos", new int[] {
                    bonfirePos.getX(),
                    bonfirePos.getY(),
                    bonfirePos.getZ()
            });
        }
    }

    @Inject(method = "readNbt", at = @At("HEAD"))
    public void readNbt(CompoundTag tag, CallbackInfo ci) {
        var tagValue = tag.getIntArray("homeAnchorPos");
        if (tagValue != null && tagValue.length > 0) {
            this.updateBonfire(new BlockPos(tagValue[0], tagValue[1], tagValue[2]));
        }
    }

}
