package com.amar.homeward.items;

import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class HomewardBoneItem extends Item {
    public HomewardBoneItem() {
        super(new HomewardBoneItem.Properties()
                .tab(CreativeModeTab.TAB_TRANSPORTATION)
                .stacksTo(16)
                .food(new FoodProperties.Builder().nutrition(0).saturationMod(0).fast().alwaysEat().build()));
    }

    public HomewardBoneItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        // TODO check bonfire position
        var itemStack = player.getItemInHand(hand);

        if (!this.isInOverworld(world)) {
            player.stopUsingItem();
            player.displayClientMessage(new TranslatableComponent("gameplay.homeward.bonfire_wrong_dimension"), true);

            return InteractionResultHolder.fail(itemStack);
        } else if (!this.isBonfireAvailable(world, player)) {
            player.stopUsingItem();
            player.displayClientMessage(new TranslatableComponent("gameplay.homeward.bonfire_not_found"), true);

            return InteractionResultHolder.fail(itemStack);
        } else {
            player.playSound(SoundEvents.FIRE_AMBIENT, 1.0f, 1.0f);

            return super.use(world, player, hand);
        }
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        // Set sufficiently high so that the food animation never finishes, allowing us
        // to override behavior
        return 300;
    }

    @Override
    public boolean useOnRelease(ItemStack stack) {
        return false;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.BOW;
    }

    @Override
    public void onUsingTick(ItemStack stack, LivingEntity player, int remainingUseTicks) {
        if (remainingUseTicks == this.getUseDuration(stack) - 2) {
            player.playSound(SoundEvents.FIRE_AMBIENT, 1.0f, 1.0f);
        }

        if (remainingUseTicks <= this.getUseDuration(stack) - 16) {
            player.stopUsingItem();
            teleportPlayer(player);

            player.playSound(SoundEvents.ENDERMAN_TELEPORT, 2.0f, 0.75f);
        }
    }

    private void teleportPlayer(LivingEntity player) {
        // TODO Add teleport functionality
        player.sendMessage(new TextComponent("TODO teleport player"), player.getUUID());
    }

    private boolean isInOverworld(Level world) {
        return world.dimension().equals(Level.OVERWORLD);
    }

    private boolean isBonfireAvailable(Level world, Player player) {
        // TODO Add actual checks
        return true;
    }
}
