package fr.zadar.elementary.entity;

import fr.zadar.elementary.ElementaryFabric;
import fr.zadar.elementary.entity.custom.FlameSpiritEntity;
import fr.zadar.elementary.entity.custom.GuardianOfTheWavesEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<FlameSpiritEntity> FLAME_SPIRIT = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(ElementaryFabric.MOD_ID, "flame_spirit"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, FlameSpiritEntity::new).dimensions(EntityDimensions.fixed(1f, 2f)).build());
    public static final EntityType<GuardianOfTheWavesEntity> GUARDIAN_OF_THE_WAVES = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(ElementaryFabric.MOD_ID, "guardian_of_the_waves"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, GuardianOfTheWavesEntity::new).dimensions(EntityDimensions.fixed(1f, 2f)).build());
}
