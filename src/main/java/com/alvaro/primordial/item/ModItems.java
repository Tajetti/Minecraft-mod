package com.alvaro.primordial.item;

import com.alvaro.primordial.PrimordialMod;
import com.alvaro.primordial.item.custom.DayAmuletItem;
import com.alvaro.primordial.item.custom.NightAmuletItem;
import com.alvaro.primordial.item.custom.StormAmuletItem;
import com.alvaro.primordial.item.custom.SummerAmuletItem;
import com.alvaro.primordial.item.sword.InvisibleSword;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, PrimordialMod.MODID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static final RegistryObject<Item> STORM_AMULET =
            ITEMS.register("storm_amulet",
                    () -> new StormAmuletItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> SUMMER_AMULET =
            ITEMS.register("summer_amulet",
                    () -> new SummerAmuletItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> NIGHT_AMULET =
            ITEMS.register("night_amulet",
                    () -> new NightAmuletItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> DAY_AMULET =
            ITEMS.register("day_amulet",
                    () -> new DayAmuletItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> SWORD_INVISIBLE =
            ITEMS.register("sword_invisible",
                    () -> new InvisibleSword(
                            Tiers.NETHERITE,
                            10,
                            -1.4F,
                            new Item.Properties().stacksTo(1)
                    ));
}
