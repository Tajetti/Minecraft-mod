package com.alvaro.primordial.item.sword;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class InvisibleSword extends SwordItem {

    public InvisibleSword(Tier tier, int attackDamageModifier, float attackSpeedModifier, Item.Properties properties ) {
        super(tier, attackDamageModifier, attackSpeedModifier, properties);
    }
}