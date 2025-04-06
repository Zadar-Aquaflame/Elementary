package fr.zadar.elementary.data;

import fr.zadar.elementary.block.ModBlocks;
import fr.zadar.elementary.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ModelProvider extends FabricModelProvider {
    public ModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.EMBERSTONE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_EMBERSTONE_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.EMBERSTONE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_EMBERSTONE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_EMBERSTONE_ORE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.HYDROSTONE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_HYDROSTONE_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.HYDROSTONE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_HYDROSTONE_ORE);

        blockStateModelGenerator.registerSimpleState(ModBlocks.ELEMENTS_IMPROVEMENT);
        blockStateModelGenerator.registerSimpleState(ModBlocks.FIRE_CRYSTAL_ORE);
        blockStateModelGenerator.registerSimpleState(ModBlocks.DEEPSLATE_FIRE_CRYSTAL_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.EMBERSTONE_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_EMBERSTONE, Models.GENERATED);

        itemModelGenerator.register(ModItems.EMBERSTONE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.EMBERSTONE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.EMBERSTONE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.EMBERSTONE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.EMBERSTONE_HOE, Models.HANDHELD);

        itemModelGenerator.registerArmor((ArmorItem) ModItems.EMBERSTONE_HELMET);
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.EMBERSTONE_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.EMBERSTONE_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.EMBERSTONE_BOOTS));

        itemModelGenerator.register(ModItems.HYDROSTONE_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_HYDROSTONE, Models.GENERATED);

        itemModelGenerator.register(ModItems.HYDROSTONE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.HYDROSTONE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.HYDROSTONE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.HYDROSTONE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.HYDROSTONE_HOE, Models.HANDHELD);

        itemModelGenerator.registerArmor((ArmorItem) ModItems.HYDROSTONE_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.HYDROSTONE_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.HYDROSTONE_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.HYDROSTONE_BOOTS);

        itemModelGenerator.register(ModItems.FIRE_CRYSTAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.MYSTIC_ASH, Models.GENERATED);
        itemModelGenerator.register(ModItems.HEAT_ESSENCE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ETHEREAL_HEART, Models.GENERATED);

        itemModelGenerator.register(ModItems.FLAME_SPIRIT_SPAWN_EGG,
                new Model(Optional.of(new Identifier("item/template_spawn_egg")), Optional.empty()));

    }
}
