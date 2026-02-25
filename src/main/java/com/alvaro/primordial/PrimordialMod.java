package com.alvaro.primordial;

import com.alvaro.primordial.item.custom.DayAmuletItem;
import com.alvaro.primordial.item.custom.NightAmuletItem;
import com.alvaro.primordial.item.custom.StormAmuletItem;
import com.alvaro.primordial.item.custom.SummerAmuletItem;
import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

@Mod(PrimordialMod.MODID)
public class PrimordialMod {

    public static final String MODID = "primordial";
    private static final Logger LOGGER = LogUtils.getLogger();

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

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

    public PrimordialMod() {

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ITEMS.register(modEventBus);

        modEventBus.addListener(this::addCreative);

        MinecraftForge.EVENT_BUS.register(this);

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(STORM_AMULET);
            event.accept(SUMMER_AMULET);
            event.accept(NIGHT_AMULET);
            event.accept(DAY_AMULET);
        }
    }
}