package fr.zadar.elementary.screen;

import fr.zadar.elementary.ElementaryFabric;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {
    public static final ScreenHandlerType<ElementsImprovementScreenHandler> ELEMENTS_IMPROVEMENT_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, new Identifier(ElementaryFabric.MOD_ID, "elements_improvement"),
                    new ExtendedScreenHandlerType<>(ElementsImprovementScreenHandler::new));

    public static void registerScreenHandlers() {
        ElementaryFabric.LOGGER.info("Registering Screen for " + ElementaryFabric.MOD_ID);
    }
}
