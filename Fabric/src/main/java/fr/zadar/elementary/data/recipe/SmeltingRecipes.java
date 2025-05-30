package fr.zadar.elementary.data.recipe;

import fr.zadar.elementary.block.ModBlocks;
import fr.zadar.elementary.item.ModItems;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.recipe.book.RecipeCategory;

import java.util.List;
import java.util.function.Consumer;

import static net.minecraft.data.server.recipe.RecipeProvider.offerSmelting;

public class SmeltingRecipes {

    public static void register(Consumer<RecipeJsonProvider> consumer) {
        offerSmelting(consumer, List.of(ModItems.RAW_EMBERSTONE, ModBlocks.EMBERSTONE_ORE, ModBlocks.DEEPSLATE_EMBERSTONE_ORE, ModBlocks.NETHER_EMBERSTONE_ORE),
                RecipeCategory.MISC, ModItems.EMBERSTONE_INGOT, 0.25f, 200, "emberstone_ingot");
        offerSmelting(consumer, List.of(ModItems.RAW_HYDROSTONE, ModBlocks.HYDROSTONE_ORE, ModBlocks.DEEPSLATE_HYDROSTONE_ORE),
                RecipeCategory.MISC, ModItems.HYDROSTONE_INGOT, 0.3f, 200, "hydrostone_ingot");
        offerSmelting(consumer, List.of(ModBlocks.FIRE_CRYSTAL_ORE, ModBlocks.DEEPSLATE_FIRE_CRYSTAL_ORE),
                RecipeCategory.MISC, ModItems.FIRE_CRYSTAL, 0.3f, 100, "fire_crystal");
        offerSmelting(consumer, List.of(ModBlocks.WATER_CRYSTAL_ORE, ModBlocks.DEEPSLATE_WATER_CRYSTAL_ORE),
                RecipeCategory.MISC, ModItems.WATER_CRYSTAL, 0.3f, 100, "water_crystal");
    }
}
