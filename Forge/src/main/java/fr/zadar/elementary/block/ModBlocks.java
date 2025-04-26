package fr.zadar.elementary.block;

import fr.zadar.elementary.ElementaryForge;
import fr.zadar.elementary.block.custom.ElementsImprovementBlock;
import fr.zadar.elementary.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ElementaryForge.MOD_ID);

    public static final RegistryObject<Block> EMBERSTONE_BLOCK = registerBlock("emberstone_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> RAW_EMBERSTONE_BLOCK = registerBlock("raw_emberstone_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK)));

    public static final RegistryObject<Block> EMBERSTONE_ORE = registerBlock("emberstone_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DEEPSLATE_EMBERSTONE_ORE = registerBlock("deepslate_emberstone_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> NETHER_EMBERSTONE_ORE = registerBlock("nether_emberstone_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> HYDROSTONE_BLOCK = registerBlock("hydrostone_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> RAW_HYDROSTONE_BLOCK = registerBlock("raw_hydrostone_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK)));

    public static final RegistryObject<Block> HYDROSTONE_ORE = registerBlock("hydrostone_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DEEPSLATE_HYDROSTONE_ORE = registerBlock("deepslate_hydrostone_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_IRON_ORE).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> ELEMENTS_IMPROVEMENT = registerBlock("elements_improvement",
            () -> new ElementsImprovementBlock(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN).noOcclusion()));
    public static final RegistryObject<Block> FIRE_CRYSTAL_ORE = registerBlock("fire_crystal_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.GOLD_ORE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DEEPSLATE_FIRE_CRYSTAL_ORE = registerBlock("deepslate_fire_crystal_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_GOLD_ORE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> WATER_CRYSTAL_ORE = registerBlock("water_crystal_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.GOLD_ORE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DEEPSLATE_WATER_CRYSTAL_ORE = registerBlock("deepslate_water_crystal_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_GOLD_ORE).requiresCorrectToolForDrops()));


    private static <T extends Block> RegistryObject<T> registerBlock(String id, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(id, block);
        registerBlockItem(id, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String id, RegistryObject<T> block) {
        ModItems.ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        ElementaryForge.LOGGER.info("Registering Blocks for " + ElementaryForge.MOD_ID);

        BLOCKS.register(eventBus);
    }
}
