package com.alvaro.primordial.item.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class DayAmuletItem extends Item {

    public static final int coolDown = 200;

    public DayAmuletItem(Properties properties) {
        super(properties);
    }

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

        serverLevel.setDayTime(1000);

        player.getCooldowns().addCooldown(item, coolDown);

        return InteractionResultHolder.success(stack);
    }
}
