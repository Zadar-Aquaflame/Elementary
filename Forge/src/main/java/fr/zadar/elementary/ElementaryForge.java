package fr.zadar.elementary;

import com.mojang.logging.LogUtils;
import fr.zadar.elementary.block.ModBlocks;
import fr.zadar.elementary.block.entity.ModBlockEntities;
import fr.zadar.elementary.item.ModItems;
import fr.zadar.elementary.recipe.ModRecipes;
import fr.zadar.elementary.screen.ElementsImprovementScreen;
import fr.zadar.elementary.screen.ModMenuTypes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(ElementaryForge.MOD_ID)
public class ElementaryForge {
    public static final String MOD_ID = "elementary";
    public static final Logger LOGGER = LogUtils.getLogger();


    public ElementaryForge(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();
        LOGGER.info("Mod Elementary started successfully");

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);
        ModRecipes.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            MenuScreens.register(ModMenuTypes.ELEMENTS_IMPROVEMENT_MENU.get(), ElementsImprovementScreen::new);
        }
    }
}
