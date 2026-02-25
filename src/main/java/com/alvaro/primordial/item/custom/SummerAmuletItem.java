package com.alvaro.primordial.item.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class SummerAmuletItem extends Item {
    public static final int COOLDOWN_TICKS = 200;

    public SummerAmuletItem(Properties properties){ super(properties); }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand)
    {
        ItemStack stack = player.getItemInHand(hand);

        if(level.isClientSide) {
            return InteractionResultHolder.success(stack);
        }

        Item item = stack.getItem();

        if(player.getCooldowns().isOnCooldown(item)) {
            return InteractionResultHolder.fail(stack);
        }

        ServerLevel serverLevel = (ServerLevel) level;

        serverLevel.setWeatherParameters(6000, 0, false, false);

        player.getCooldowns().addCooldown(item, COOLDOWN_TICKS);

        return InteractionResultHolder.success(stack);
    }
}
