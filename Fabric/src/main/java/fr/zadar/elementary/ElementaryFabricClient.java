package fr.zadar.elementary;

import fr.zadar.elementary.entity.ModEntities;
import fr.zadar.elementary.entity.client.model.FlameSpiritModel;
import fr.zadar.elementary.entity.client.model.GuardianOfTheWavesModel;
import fr.zadar.elementary.entity.client.renderer.FlameSpiritRenderer;
import fr.zadar.elementary.entity.client.ModModelLayers;
import fr.zadar.elementary.entity.client.renderer.GuardianOfTheWavesRenderer;
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
        EntityRendererRegistry.register(ModEntities.GUARDIAN_OF_THE_WAVES, GuardianOfTheWavesRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.GUARDIAN_OF_THE_WAVES, GuardianOfTheWavesModel::getTexturedModelData);

        HandledScreens.register(ModScreenHandlers.ELEMENTS_IMPROVEMENT_SCREEN_HANDLER, ElementsImprovementScreen::new);
    }
}
