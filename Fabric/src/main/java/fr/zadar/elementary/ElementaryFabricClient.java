package fr.zadar.elementary;

import fr.zadar.elementary.entity.ModEntities;
import fr.zadar.elementary.entity.client.FlameSpiritModel;
import fr.zadar.elementary.entity.client.FlameSpiritRenderer;
import fr.zadar.elementary.entity.client.ModModelLayers;
import fr.zadar.elementary.screen.ElementsImprovementScreen;
import fr.zadar.elementary.screen.ModScreenHandlers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class ElementaryFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.FLAME_SPIRIT, FlameSpiritRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.FLAME_SPIRIT, FlameSpiritModel::getTexturedModelData);

        HandledScreens.register(ModScreenHandlers.ELEMENTS_IMPROVEMENT_SCREEN_HANDLER, ElementsImprovementScreen::new);
    }
}
