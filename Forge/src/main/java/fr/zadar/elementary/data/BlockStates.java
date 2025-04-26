package fr.zadar.elementary.data;

import fr.zadar.elementary.ElementaryForge;
import fr.zadar.elementary.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class BlockStates extends BlockStateProvider {
    public BlockStates(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ElementaryForge.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.EMBERSTONE_BLOCK);
        blockWithItem(ModBlocks.RAW_EMBERSTONE_BLOCK);

        blockWithItem(ModBlocks.EMBERSTONE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_EMBERSTONE_ORE);
        blockWithItem(ModBlocks.NETHER_EMBERSTONE_ORE);

        blockWithItem(ModBlocks.HYDROSTONE_BLOCK);
        blockWithItem(ModBlocks.RAW_HYDROSTONE_BLOCK);

        blockWithItem(ModBlocks.HYDROSTONE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_HYDROSTONE_ORE);

        simpleBlockWithItem(ModBlocks.ELEMENTS_IMPROVEMENT.get(), new ModelFile.UncheckedModelFile(modLoc("block/elements_improvement")));

        blockWithItem(ModBlocks.FIRE_CRYSTAL_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_FIRE_CRYSTAL_ORE);
        blockWithItem(ModBlocks.WATER_CRYSTAL_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_WATER_CRYSTAL_ORE);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
