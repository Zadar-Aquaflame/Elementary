package fr.zadar.elementary.block.entity;

import fr.zadar.elementary.ElementaryForge;
import fr.zadar.elementary.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ElementaryForge.MOD_ID);

    public static final RegistryObject<BlockEntityType<ElementsImprovementBlockEntity>> ELEMENTS_IMPROVEMENT_BE =
            BLOCK_ENTITIES.register("elements_improvement", () ->
                    BlockEntityType.Builder.of(ElementsImprovementBlockEntity::new, ModBlocks.ELEMENTS_IMPROVEMENT.get()).build(null));

    public static void register(IEventBus eventBus) {
        ElementaryForge.LOGGER.info("Registering Block Entities for " + ElementaryForge.MOD_ID);

        BLOCK_ENTITIES.register(eventBus);
    }
}
