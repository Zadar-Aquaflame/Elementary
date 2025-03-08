package fr.zadar.elementary.entity;

import fr.zadar.elementary.ElementaryForge;
import fr.zadar.elementary.entity.custom.FlameSpiritEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPE =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ElementaryForge.MOD_ID);

    public static final RegistryObject<EntityType<FlameSpiritEntity>> FLAME_SPIRIT =
            ENTITY_TYPE.register("flame_spirit", () -> EntityType.Builder.of(FlameSpiritEntity::new, MobCategory.MONSTER)
                    .sized(1f, 2f).build("flame_spirit"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPE.register(eventBus);
    }
}
