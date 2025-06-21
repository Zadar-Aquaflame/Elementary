package fr.zadar.elementary.event;

import fr.zadar.elementary.entity.ModEntities;
import fr.zadar.elementary.entity.custom.AerorupturaEntity;
import fr.zadar.elementary.entity.custom.FlameSpiritEntity;
import fr.zadar.elementary.entity.custom.GuardianOfTheWavesEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;

public class MobEvents {
    public static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(ModEntities.FLAME_SPIRIT, FlameSpiritEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.GUARDIAN_OF_THE_WAVES, GuardianOfTheWavesEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.AERORUPTURA, AerorupturaEntity.createAttributes());
    }
}
