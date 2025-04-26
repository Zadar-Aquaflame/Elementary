package fr.zadar.elementary.data;

import fr.zadar.elementary.ElementaryForge;
import fr.zadar.elementary.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class BlockTags extends BlockTagsProvider {
    public BlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ElementaryForge.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        this.tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.EMBERSTONE_BLOCK.get(),
                        ModBlocks.RAW_EMBERSTONE_BLOCK.get(),
                        ModBlocks.EMBERSTONE_ORE.get(),
                        ModBlocks.DEEPSLATE_EMBERSTONE_ORE.get(),
                        ModBlocks.NETHER_EMBERSTONE_ORE.get(),
                        ModBlocks.HYDROSTONE_ORE.get(),
                        ModBlocks.DEEPSLATE_HYDROSTONE_ORE.get(),
                        ModBlocks.FIRE_CRYSTAL_ORE.get(),
                        ModBlocks.DEEPSLATE_FIRE_CRYSTAL_ORE.get(),
                        ModBlocks.WATER_CRYSTAL_ORE.get(),
                        ModBlocks.DEEPSLATE_WATER_CRYSTAL_ORE.get());

        this.tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.EMBERSTONE_BLOCK.get(),
                        ModBlocks.RAW_EMBERSTONE_BLOCK.get(),
                        ModBlocks.EMBERSTONE_ORE.get(),
                        ModBlocks.DEEPSLATE_EMBERSTONE_ORE.get(),
                        ModBlocks.NETHER_EMBERSTONE_ORE.get(),
                        ModBlocks.HYDROSTONE_ORE.get(),
                        ModBlocks.DEEPSLATE_HYDROSTONE_ORE.get(),
                        ModBlocks.FIRE_CRYSTAL_ORE.get(),
                        ModBlocks.DEEPSLATE_FIRE_CRYSTAL_ORE.get(),
                        ModBlocks.WATER_CRYSTAL_ORE.get(),
                        ModBlocks.DEEPSLATE_WATER_CRYSTAL_ORE.get());
    }
}
