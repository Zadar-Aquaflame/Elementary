package fr.zadar.elementary.data;

import fr.zadar.elementary.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class BlockTag extends FabricTagProvider.BlockTagProvider {
    public BlockTag(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.EMBERSTONE_BLOCK)
                .add(ModBlocks.RAW_EMBERSTONE_BLOCK)
                .add(ModBlocks.EMBERSTONE_ORE)
                .add(ModBlocks.DEEPSLATE_EMBERSTONE_ORE)
                .add(ModBlocks.NETHER_EMBERSTONE_ORE)
                .add(ModBlocks.HYDROSTONE_BLOCK)
                .add(ModBlocks.RAW_HYDROSTONE_BLOCK)
                .add(ModBlocks.HYDROSTONE_ORE)
                .add(ModBlocks.DEEPSLATE_HYDROSTONE_ORE)
                .add(ModBlocks.FIRE_CRYSTAL_ORE)
                .add(ModBlocks.DEEPSLATE_FIRE_CRYSTAL_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.EMBERSTONE_BLOCK)
                .add(ModBlocks.RAW_EMBERSTONE_BLOCK)
                .add(ModBlocks.EMBERSTONE_ORE)
                .add(ModBlocks.DEEPSLATE_EMBERSTONE_ORE)
                .add(ModBlocks.NETHER_EMBERSTONE_ORE)
                .add(ModBlocks.HYDROSTONE_BLOCK)
                .add(ModBlocks.RAW_HYDROSTONE_BLOCK)
                .add(ModBlocks.HYDROSTONE_ORE)
                .add(ModBlocks.DEEPSLATE_HYDROSTONE_ORE)
                .add(ModBlocks.FIRE_CRYSTAL_ORE)
                .add(ModBlocks.DEEPSLATE_FIRE_CRYSTAL_ORE);
    }
}
