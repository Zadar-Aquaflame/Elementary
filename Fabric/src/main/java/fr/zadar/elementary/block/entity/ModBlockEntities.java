package fr.zadar.elementary.block.entity;

import fr.zadar.elementary.ElementaryFabric;
import fr.zadar.elementary.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<ElementsImprovementBlockEntity> ELEMENTS_IMPROVEMENT_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(ElementaryFabric.MOD_ID, "elements_improvement_be"),
                    FabricBlockEntityTypeBuilder.create(ElementsImprovementBlockEntity::new, ModBlocks.ELEMENTS_IMPROVEMENT).build());

    public static void registerBlockEntities() {
        ElementaryFabric.LOGGER.info("Registering Block Entities for " + ElementaryFabric.MOD_ID);
    }
}
