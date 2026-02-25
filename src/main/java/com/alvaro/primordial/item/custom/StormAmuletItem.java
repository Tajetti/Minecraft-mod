package com.alvaro.primordial.item.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;


public class StormAmuletItem extends Item{
    private static final int COOLDOWN_TICKS = 200;

    public StormAmuletItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {

        ItemStack stack = player.getItemInHand(hand);

        if(level.isClientSide) {
            return InteractionResultHolder.success(stack);
        }

        Item item = stack.getItem();

        if(player.getCooldowns().isOnCooldown(item)) {
            return InteractionResultHolder.fail(stack);
        }

        ServerLevel serverLevel = (ServerLevel) level;

        serverLevel.setWeatherParameters(0, 6000, true, true);

        player.getCooldowns().addCooldown(item, COOLDOWN_TICKS);

        return InteractionResultHolder.success(stack);
    }
}
