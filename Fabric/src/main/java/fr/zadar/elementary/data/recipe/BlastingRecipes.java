package fr.zadar.elementary.data.recipe;

import fr.zadar.elementary.block.ModBlocks;
import fr.zadar.elementary.item.ModItems;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.recipe.book.RecipeCategory;

import java.util.List;
import java.util.function.Consumer;

import static net.minecraft.data.server.recipe.RecipeProvider.offerBlasting;


public class BlastingRecipes {
    public static void register(Consumer<RecipeJsonProvider> consumer) {
        offerBlasting(consumer, List.of(ModItems.RAW_EMBERSTONE, ModBlocks.EMBERSTONE_ORE, ModBlocks.DEEPSLATE_EMBERSTONE_ORE, ModBlocks.NETHER_EMBERSTONE_ORE),
                RecipeCategory.MISC, ModItems.EMBERSTONE_INGOT, 0.25f, 100, "emberstone_ingot");
        offerBlasting(consumer, List.of(ModItems.RAW_HYDROSTONE, ModBlocks.HYDROSTONE_ORE, ModBlocks.DEEPSLATE_HYDROSTONE_ORE),
                RecipeCategory.MISC, ModItems.HYDROSTONE_INGOT, 0.3f, 100, "hydrostone_ingot");
    }
}
