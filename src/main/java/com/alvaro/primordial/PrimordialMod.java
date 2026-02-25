package com.alvaro.primordial;

import com.alvaro.primordial.item.ModItems;
import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(PrimordialMod.MODID)
public class PrimordialMod {

    public static final String MODID = "primordial";
    private static final Logger LOGGER = LogUtils.getLogger();

    public PrimordialMod() {

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);

        modEventBus.addListener(this::addCreative);

        MinecraftForge.EVENT_BUS.register(this);

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.STORM_AMULET.get());
            event.accept(ModItems.SUMMER_AMULET.get());
            event.accept(ModItems.NIGHT_AMULET.get());
            event.accept(ModItems.DAY_AMULET);
        }
    }
}