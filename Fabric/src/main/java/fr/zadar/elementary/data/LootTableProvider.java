package fr.zadar.elementary.data;

import fr.zadar.elementary.block.ModBlocks;
import fr.zadar.elementary.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class LootTableProvider extends FabricBlockLootTableProvider {
    public LootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.EMBERSTONE_BLOCK);
        addDrop(ModBlocks.RAW_EMBERSTONE_BLOCK);

        addDrop(ModBlocks.EMBERSTONE_ORE, oreDrops(ModBlocks.EMBERSTONE_ORE, ModItems.RAW_EMBERSTONE));
        addDrop(ModBlocks.DEEPSLATE_EMBERSTONE_ORE, oreDrops(ModBlocks.DEEPSLATE_EMBERSTONE_ORE, ModItems.RAW_EMBERSTONE));
        addDrop(ModBlocks.NETHER_EMBERSTONE_ORE, oreDrops(ModBlocks.NETHER_EMBERSTONE_ORE, ModItems.RAW_EMBERSTONE));

        addDrop(ModBlocks.HYDROSTONE_BLOCK);
        addDrop(ModBlocks.RAW_HYDROSTONE_BLOCK);

        addDrop(ModBlocks.HYDROSTONE_ORE, oreDrops(ModBlocks.HYDROSTONE_ORE, ModItems.RAW_HYDROSTONE));
        addDrop(ModBlocks.DEEPSLATE_HYDROSTONE_ORE, oreDrops(ModBlocks.DEEPSLATE_HYDROSTONE_ORE, ModItems.RAW_HYDROSTONE));
    }
}
