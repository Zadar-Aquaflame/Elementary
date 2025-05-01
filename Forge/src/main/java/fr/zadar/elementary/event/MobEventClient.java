package fr.zadar.elementary.event;

import fr.zadar.elementary.ElementaryForge;
import fr.zadar.elementary.entity.client.model.FlameSpiritModel;
import fr.zadar.elementary.entity.client.model.GuardianOfTheWavesModel;
import fr.zadar.elementary.entity.client.ModModelLayers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ElementaryForge.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class MobEventClient {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.FLAME_SPIRIT, FlameSpiritModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.GUARDIAN_OF_THE_WAVES, GuardianOfTheWavesModel::createBodyLayer);
    }
}
