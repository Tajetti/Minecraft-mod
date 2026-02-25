package com.alvaro.primordial.item.sword;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

public class InvisibleSword extends SwordItem {

    public InvisibleSword(Tier tier, int attackDamageModifier, float attackSpeedModifier, Item.Properties properties ) {
        super(tier, attackDamageModifier, attackSpeedModifier, properties);
    }


    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slot, boolean selected) {
        if (level.isClientSide) return;

        CompoundTag tag = stack.getOrCreateTag();
        if (tag.getBoolean("primordialAutoEnchant")) return;

        stack.enchant(Enchantments.SHARPNESS, 5);
        stack.enchant(Enchantments.UNBREAKING, 3);

        tag.putBoolean("primordialAutoEnchant", true);
    }
}