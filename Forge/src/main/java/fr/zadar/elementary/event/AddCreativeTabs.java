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
            event.accept(ModItems.FIRE_CRYSTAL);
        }

        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.EMBERSTONE_BLOCK);
            event.accept(ModBlocks.HYDROSTONE_BLOCK);
        }

        if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(ModBlocks.RAW_EMBERSTONE_BLOCK);
            event.accept(ModBlocks.EMBERSTONE_ORE);
            event.accept(ModBlocks.DEEPSLATE_EMBERSTONE_ORE);
            event.accept(ModBlocks.NETHER_EMBERSTONE_ORE);

            event.accept(ModBlocks.RAW_HYDROSTONE_BLOCK);
            event.accept(ModBlocks.HYDROSTONE_ORE);
            event.accept(ModBlocks.DEEPSLATE_HYDROSTONE_ORE);

            event.accept(ModBlocks.FIRE_CRYSTAL_ORE);
            event.accept(ModBlocks.DEEPSLATE_FIRE_CRYSTAL_ORE);
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
        }

        if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            event.accept(ModBlocks.ELEMENTS_IMPROVEMENT);
        }
    }
}
