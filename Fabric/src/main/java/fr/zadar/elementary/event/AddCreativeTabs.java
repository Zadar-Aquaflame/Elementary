package fr.zadar.elementary.event;

import fr.zadar.elementary.block.ModBlocks;
import fr.zadar.elementary.item.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;

public class AddCreativeTabs {
    public AddCreativeTabs() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(AddCreativeTabs::ingredientTab);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(AddCreativeTabs::combatTab);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(AddCreativeTabs::toolTab);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(AddCreativeTabs::buildingBlockTab);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(AddCreativeTabs::naturalBlockTab);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(AddCreativeTabs::functionalBlockTab);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(AddCreativeTabs::spawnEggTab);
    }

    private static void ingredientTab(FabricItemGroupEntries entries) {
        entries.add(ModItems.EMBERSTONE_INGOT);
        entries.add(ModItems.RAW_EMBERSTONE);
        entries.add(ModItems.HYDROSTONE_INGOT);
        entries.add(ModItems.RAW_HYDROSTONE);
        entries.add(ModItems.FIRE_CRYSTAL);
        entries.add(ModItems.MYSTIC_ASH);
        entries.add(ModItems.HEAT_ESSENCE);
        entries.add(ModItems.WATER_CRYSTAL);
        entries.add(ModItems.TEAR_DROP);
        entries.add(ModItems.WAVE_ESSENCE);
        entries.add(ModItems.ETHEREAL_HEART);
        entries.add(ModItems.EMBERITE_INGOT);
        entries.add(ModItems.AQUALITE_INGOT);
        entries.add(ModItems.FIRE_FERROCRYSTAL_INGOT);
        entries.add(ModItems.FIRE_FERROCRYSTAL_STICK);
        entries.add(ModItems.WATER_FERROCRYSTAL_INGOT);
        entries.add(ModItems.WATER_FERROCRYSTAL_STICK);
    }

    private static void combatTab(FabricItemGroupEntries entries) {
        entries.add(ModItems.EMBERSTONE_SWORD);
        entries.add(ModItems.EMBERSTONE_AXE);
        entries.add(ModItems.EMBERSTONE_HELMET);
        entries.add(ModItems.EMBERSTONE_CHESTPLATE);
        entries.add(ModItems.EMBERSTONE_LEGGINGS);
        entries.add(ModItems.EMBERSTONE_BOOTS);

        entries.add(ModItems.HYDROSTONE_SWORD);
        entries.add(ModItems.HYDROSTONE_AXE);
        entries.add(ModItems.HYDROSTONE_HELMET);
        entries.add(ModItems.HYDROSTONE_CHESTPLATE);
        entries.add(ModItems.HYDROSTONE_LEGGINGS);
        entries.add(ModItems.HYDROSTONE_BOOTS);

        entries.add(ModItems.EMBERITE_SWORD);
        entries.add(ModItems.EMBERITE_AXE);
        entries.add(ModItems.EMBERITE_HELMET);
        entries.add(ModItems.EMBERITE_CHESTPLATE);
        entries.add(ModItems.EMBERITE_LEGGINGS);
        entries.add(ModItems.EMBERITE_BOOTS);

        entries.add(ModItems.AQUALITE_SWORD);
        entries.add(ModItems.AQUALITE_AXE);
        entries.add(ModItems.AQUALITE_HELMET);
        entries.add(ModItems.AQUALITE_CHESTPLATE);
        entries.add(ModItems.AQUALITE_LEGGINGS);
        entries.add(ModItems.AQUALITE_BOOTS);
    }

    private static void toolTab(FabricItemGroupEntries entries) {
        entries.add(ModItems.EMBERSTONE_SHOVEL);
        entries.add(ModItems.EMBERSTONE_PICKAXE);
        entries.add(ModItems.EMBERSTONE_AXE);
        entries.add(ModItems.EMBERSTONE_HOE);

        entries.add(ModItems.HYDROSTONE_SHOVEL);
        entries.add(ModItems.HYDROSTONE_PICKAXE);
        entries.add(ModItems.HYDROSTONE_AXE);
        entries.add(ModItems.HYDROSTONE_HOE);

        entries.add(ModItems.EMBERITE_SHOVEL);
        entries.add(ModItems.EMBERITE_PICKAXE);
        entries.add(ModItems.EMBERITE_AXE);
        entries.add(ModItems.EMBERITE_HOE);

        entries.add(ModItems.AQUALITE_SHOVEL);
        entries.add(ModItems.AQUALITE_PICKAXE);
        entries.add(ModItems.AQUALITE_AXE);
        entries.add(ModItems.AQUALITE_HOE);
    }

    private static void buildingBlockTab(FabricItemGroupEntries entries) {
        entries.add(ModBlocks.EMBERSTONE_BLOCK);
        entries.add(ModBlocks.HYDROSTONE_BLOCK);
    }

    private static void naturalBlockTab(FabricItemGroupEntries entries) {
        entries.add(ModBlocks.RAW_EMBERSTONE_BLOCK);
        entries.add(ModBlocks.EMBERSTONE_ORE);
        entries.add(ModBlocks.DEEPSLATE_EMBERSTONE_ORE);
        entries.add(ModBlocks.NETHER_EMBERSTONE_ORE);
        entries.add(ModBlocks.RAW_HYDROSTONE_BLOCK);
        entries.add(ModBlocks.HYDROSTONE_ORE);
        entries.add(ModBlocks.DEEPSLATE_HYDROSTONE_ORE);
        entries.add(ModBlocks.FIRE_CRYSTAL_ORE);
        entries.add(ModBlocks.DEEPSLATE_FIRE_CRYSTAL_ORE);
    }

    private static void functionalBlockTab(FabricItemGroupEntries entries) {
        entries.add(ModBlocks.ELEMENTS_IMPROVEMENT);
    }

    private static void spawnEggTab(FabricItemGroupEntries entries) {
        entries.add(ModItems.FLAME_SPIRIT_SPAWN_EGG);
        entries.add(ModItems.GUARDIAN_OF_THE_WAVES_SPAWN_EGG);
    }
}
