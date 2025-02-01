package fr.zadar.elementary.block;

import fr.zadar.elementary.ElementaryFabric;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    public static final Block EMBERSTONE_BLOCK = registerBlock("emberstone_block", new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).requiresTool()));
    public static final Block RAW_EMBERSTONE_BLOCK = registerBlock("raw_emberstone_block", new Block(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK).requiresTool()));

    public static final Block EMBERSTONE_ORE = registerBlock("emberstone_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE), UniformIntProvider.create(3, 6)));
    public static final Block DEEPSLATE_EMBERSTONE_ORE = registerBlock("deepslate_emberstone_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_DIAMOND_ORE), UniformIntProvider.create(3, 6)));
    public static final Block NETHER_EMBERSTONE_ORE = registerBlock("nether_emberstone_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.NETHERRACK), UniformIntProvider.create(3, 6)));

    public static final Block HYDROSTONE_BLOCK = registerBlock("hydrostone_block", new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).requiresTool()));
    public static final Block RAW_HYDROSTONE_BLOCK = registerBlock("raw_hydrostone_block", new Block(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK).requiresTool()));

    public static final Block HYDROSTONE_ORE = registerBlock("hydrostone_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE), UniformIntProvider.create(2, 6)));
    public static final Block DEEPSLATE_HYDROSTONE_ORE = registerBlock("deepslate_hydrostone_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_DIAMOND_ORE), UniformIntProvider.create(2, 6)));


    private static void addBlockToBuildingBlockTab(FabricItemGroupEntries entries) {
        entries.add(EMBERSTONE_BLOCK);
        entries.add(HYDROSTONE_BLOCK);
    }

    private static void addBlockToNaturalBlockTab(FabricItemGroupEntries entries) {
        entries.add(RAW_EMBERSTONE_BLOCK);
        entries.add(EMBERSTONE_ORE);
        entries.add(DEEPSLATE_EMBERSTONE_ORE);
        entries.add(NETHER_EMBERSTONE_ORE);
        entries.add(RAW_HYDROSTONE_BLOCK);
        entries.add(HYDROSTONE_ORE);
        entries.add(DEEPSLATE_HYDROSTONE_ORE);
    }

    private static Block registerBlock(String id, Block block) {
        registerBlockItem(id, block);
        return Registry.register(Registries.BLOCK, new Identifier(ElementaryFabric.MOD_ID, id), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(ElementaryFabric.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlock() {
        ElementaryFabric.LOGGER.info("Registering Blocks for " + ElementaryFabric.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(ModBlocks::addBlockToBuildingBlockTab);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(ModBlocks::addBlockToNaturalBlockTab);
    }
}
