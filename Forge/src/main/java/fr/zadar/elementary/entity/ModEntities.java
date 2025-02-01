package fr.zadar.elementary.entity;

import fr.zadar.elementary.ElementaryForge;
import fr.zadar.elementary.entity.custom.WanderingFlameEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPE = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ElementaryForge.MOD_ID);

    public static final RegistryObject<EntityType<WanderingFlameEntity>> WANDERING_FLAME =
            ENTITY_TYPE.register("wandering_flame", () -> EntityType.Builder.of(WanderingFlameEntity::new, MobCategory.CREATURE)
                    .sized(1.0f, 1.0f).build("wandering_flame"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPE.register(eventBus);
    }
}
