package fr.zadar.elementary.event;

import fr.zadar.elementary.block.ModBlocks;
import fr.zadar.elementary.item.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static fr.zadar.elementary.ElementaryForge.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class AddCreativeTabs {
    @SubscribeEvent
    public static void addCreativeTab(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.EMBERSTONE_INGOT);
            event.accept(ModItems.RAW_EMBERSTONE);

            event.accept(ModItems.HYDROSTONE_INGOT);
            event.accept(ModItems.RAW_HYDROSTONE);

            event.accept(ModItems.AERITHIUM_INGOT);
            event.accept(ModItems.RAW_AERITHIUM);

            event.accept(ModItems.FIRE_CRYSTAL);
            event.accept(ModItems.MYSTIC_ASH);
            event.accept(ModItems.HEAT_ESSENCE);
            event.accept(ModItems.ETHEREAL_HEART);
            event.accept(ModItems.TEAR_DROP);
            event.accept(ModItems.WATER_CRYSTAL);
            event.accept(ModItems.WAVE_ESSENCE);
            event.accept(ModItems.AIR_CRYSTAL);
            event.accept(ModItems.STORM_ESSENCE);
            event.accept(ModItems.HURRICANE_FRAGMENT);

            event.accept(ModItems.SPARK_EMERALD);
            event.accept(ModItems.POND_EMERALD);
            event.accept(ModItems.SQUALL_EMERALD);

            event.accept(ModItems.EMBERITE_INGOT);
            event.accept(ModItems.FIRE_FERROCRYSTAL_INGOT);
            event.accept(ModItems.FIRE_FERROCRYSTAL_STICK);

            event.accept(ModItems.AQUALITE_INGOT);
            event.accept(ModItems.WATER_FERROCRYSTAL_INGOT);
            event.accept(ModItems.WATER_FERROCRYSTAL_STICK);

            event.accept(ModItems.AERILITE_INGOT);
            event.accept(ModItems.AIR_FERROCRYSTAL_INGOT);
            event.accept(ModItems.AIR_FERROCRYSTAL_STICK);
        }

        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.EMBERSTONE_BLOCK);
            event.accept(ModBlocks.HYDROSTONE_BLOCK);
            event.accept(ModBlocks.AERITHIUM_BLOCK);
        }

        if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(ModBlocks.RAW_EMBERSTONE_BLOCK);
            event.accept(ModBlocks.EMBERSTONE_ORE);
            event.accept(ModBlocks.DEEPSLATE_EMBERSTONE_ORE);
            event.accept(ModBlocks.NETHER_EMBERSTONE_ORE);

            event.accept(ModBlocks.RAW_HYDROSTONE_BLOCK);
            event.accept(ModBlocks.HYDROSTONE_ORE);
            event.accept(ModBlocks.DEEPSLATE_HYDROSTONE_ORE);

            event.accept(ModBlocks.RAW_AERITHIUM_BLOCK);
            event.accept(ModBlocks.AERITHIUM_ORE);
            event.accept(ModBlocks.DEEPSLATE_AERITHIUM_ORE);

            event.accept(ModBlocks.FIRE_CRYSTAL_ORE);
            event.accept(ModBlocks.DEEPSLATE_FIRE_CRYSTAL_ORE);
            event.accept(ModBlocks.WATER_CRYSTAL_ORE);
            event.accept(ModBlocks.DEEPSLATE_WATER_CRYSTAL_ORE);
            event.accept(ModBlocks.AIR_CRYSTAL_ORE);
            event.accept(ModBlocks.DEEPSLATE_AIR_CRYSTAL_ORE);
        }

        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(ModItems.EMBERSTONE_SWORD);
            event.accept(ModItems.EMBERSTONE_AXE);
            event.accept(ModItems.EMBERSTONE_HELMET);
            event.accept(ModItems.EMBERSTONE_CHESTPLATE);
            event.accept(ModItems.EMBERSTONE_LEGGINGS);
            event.accept(ModItems.EMBERSTONE_BOOTS);

            event.accept(ModItems.HYDROSTONE_SWORD);
            event.accept(ModItems.HYDROSTONE_AXE);
            event.accept(ModItems.HYDROSTONE_HELMET);
            event.accept(ModItems.HYDROSTONE_CHESTPLATE);
            event.accept(ModItems.HYDROSTONE_LEGGINGS);
            event.accept(ModItems.HYDROSTONE_BOOTS);

            event.accept(ModItems.AERITHIUM_SWORD);
            event.accept(ModItems.AERITHIUM_AXE);
            event.accept(ModItems.AERITHIUM_HELMET);
            event.accept(ModItems.AERITHIUM_CHESTPLATE);
            event.accept(ModItems.AERITHIUM_LEGGINGS);
            event.accept(ModItems.AERITHIUM_BOOTS);

            event.accept(ModItems.EMBERITE_SWORD);
            event.accept(ModItems.EMBERITE_AXE);
            event.accept(ModItems.EMBERITE_HELMET);
            event.accept(ModItems.EMBERITE_CHESTPLATE);
            event.accept(ModItems.EMBERITE_LEGGINGS);
            event.accept(ModItems.EMBERITE_BOOTS);

            event.accept(ModItems.AQUALITE_SWORD);
            event.accept(ModItems.AQUALITE_AXE);
            event.accept(ModItems.AQUALITE_HELMET);
            event.accept(ModItems.AQUALITE_CHESTPLATE);
            event.accept(ModItems.AQUALITE_LEGGINGS);
            event.accept(ModItems.AQUALITE_BOOTS);

            event.accept(ModItems.AERILITE_SWORD);
            event.accept(ModItems.AERILITE_AXE);
            event.accept(ModItems.AERILITE_HELMET);
            event.accept(ModItems.AERILITE_CHESTPLATE);
            event.accept(ModItems.AERILITE_LEGGINGS);
            event.accept(ModItems.AERILITE_BOOTS);
        }

        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.EMBERSTONE_SHOVEL);
            event.accept(ModItems.EMBERSTONE_PICKAXE);
            event.accept(ModItems.EMBERSTONE_AXE);
            event.accept(ModItems.EMBERSTONE_HOE);

            event.accept(ModItems.HYDROSTONE_SHOVEL);
            event.accept(ModItems.HYDROSTONE_PICKAXE);
            event.accept(ModItems.HYDROSTONE_AXE);
            event.accept(ModItems.HYDROSTONE_HOE);

            event.accept(ModItems.AERITHIUM_SHOVEL);
            event.accept(ModItems.AERITHIUM_PICKAXE);
            event.accept(ModItems.AERITHIUM_AXE);
            event.accept(ModItems.AERITHIUM_HOE);

            event.accept(ModItems.EMBERITE_SHOVEL);
            event.accept(ModItems.EMBERITE_PICKAXE);
            event.accept(ModItems.EMBERITE_AXE);
            event.accept(ModItems.EMBERITE_HOE);

            event.accept(ModItems.AQUALITE_SHOVEL);
            event.accept(ModItems.AQUALITE_PICKAXE);
            event.accept(ModItems.AQUALITE_AXE);
            event.accept(ModItems.AQUALITE_HOE);

            event.accept(ModItems.AERILITE_SHOVEL);
            event.accept(ModItems.AERILITE_PICKAXE);
            event.accept(ModItems.AERILITE_AXE);
            event.accept(ModItems.AERILITE_HOE);
        }

        if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            event.accept(ModBlocks.ELEMENTS_IMPROVEMENT);
        }

        if (event.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
            event.accept(ModItems.FLAME_SPIRIT_SPAWN_EGG);
            event.accept(ModItems.GUARDIAN_OF_THE_WAVES_SPAWN_EGG);
            event.accept(ModItems.AERORUPTURA_SPAWN_EGG);
        }
    }
}
