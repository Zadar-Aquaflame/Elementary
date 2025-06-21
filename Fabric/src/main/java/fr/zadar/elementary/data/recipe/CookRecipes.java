package fr.zadar.elementary.data.recipe;

import fr.zadar.elementary.ElementaryFabric;
import fr.zadar.elementary.block.ModBlocks;
import fr.zadar.elementary.item.ModItems;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.data.server.recipe.CookingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.book.RecipeCategory;

import java.util.List;
import java.util.function.Consumer;

public class CookRecipes {
    private static final List<ItemConvertible> EMBERSTONE = List.of(ModItems.RAW_EMBERSTONE, ModBlocks.EMBERSTONE_ORE,
            ModBlocks.DEEPSLATE_EMBERSTONE_ORE, ModBlocks.NETHER_EMBERSTONE_ORE);
    private static final List<ItemConvertible> HYDROSTONE = List.of(ModItems.RAW_HYDROSTONE, ModBlocks.HYDROSTONE_ORE,
            ModBlocks.DEEPSLATE_HYDROSTONE_ORE);
    private static final List<ItemConvertible> AERITHIUM = List.of(ModItems.RAW_AERITHIUM, ModBlocks.AERITHIUM_ORE,
            ModBlocks.DEEPSLATE_AERITHIUM_ORE);

    private static final List<ItemConvertible> FIRE_CRYSTAL = List.of(ModBlocks.FIRE_CRYSTAL_ORE, ModBlocks.DEEPSLATE_FIRE_CRYSTAL_ORE);
    private static final List<ItemConvertible> WATER_CRYSTAL = List.of(ModBlocks.WATER_CRYSTAL_ORE, ModBlocks.DEEPSLATE_WATER_CRYSTAL_ORE);
    private static final List<ItemConvertible> AIR_CRYSTAL = List.of(ModBlocks.AIR_CRYSTAL_ORE, ModBlocks.DEEPSLATE_AIR_CRYSTAL_ORE);

    public static void register(Consumer<RecipeJsonProvider> consumer) {
        oreSmelting(consumer, EMBERSTONE, RecipeCategory.MISC, ModItems.EMBERSTONE_INGOT, 0.45f, 200, "emberstone");
        oreBlasting(consumer, EMBERSTONE, RecipeCategory.MISC, ModItems.EMBERSTONE_INGOT, 0.45f, 100, "emberstone");

        oreSmelting(consumer, HYDROSTONE, RecipeCategory.MISC, ModItems.HYDROSTONE_INGOT, 0.45f, 200, "hydrostone");
        oreBlasting(consumer, HYDROSTONE, RecipeCategory.MISC, ModItems.HYDROSTONE_INGOT, 0.45f, 100, "hydrostone");

        oreSmelting(consumer, AERITHIUM, RecipeCategory.MISC, ModItems.AERITHIUM_INGOT, 0.45f, 200, "aerithium");
        oreBlasting(consumer, AERITHIUM, RecipeCategory.MISC, ModItems.AERITHIUM_INGOT, 0.45f, 100, "aerithium");

        oreSmelting(consumer, FIRE_CRYSTAL, RecipeCategory.MISC, ModItems.FIRE_CRYSTAL, 0.45f, 200, "fire_crystal");
        oreBlasting(consumer, FIRE_CRYSTAL, RecipeCategory.MISC, ModItems.FIRE_CRYSTAL, 0.45f, 100, "fire_crystal");

        oreSmelting(consumer, WATER_CRYSTAL, RecipeCategory.MISC, ModItems.WATER_CRYSTAL, 0.45f, 200, "water_crystal");
        oreBlasting(consumer, WATER_CRYSTAL, RecipeCategory.MISC, ModItems.WATER_CRYSTAL, 0.45f, 100, "water_crystal");

        oreSmelting(consumer, AIR_CRYSTAL, RecipeCategory.MISC, ModItems.AIR_CRYSTAL, 0.45f, 200, "air_crystal");
        oreBlasting(consumer, AIR_CRYSTAL, RecipeCategory.MISC, ModItems.AIR_CRYSTAL, 0.45f, 100, "air_crystal");
    }

    protected static void oreSmelting(Consumer<RecipeJsonProvider> consumer, List<ItemConvertible> ingredients, RecipeCategory category, ItemConvertible result,
                                      float xp, int cookingTime, String group) {
        oreCooking(consumer, RecipeSerializer.SMELTING, ingredients, category, result,
                xp, cookingTime , group, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<RecipeJsonProvider> consumer, List<ItemConvertible> ingredients, RecipeCategory category, ItemConvertible result,
                                      float xp, int cookingTime, String group) {
        oreCooking(consumer, RecipeSerializer.BLASTING, ingredients, category, result,
                xp, cookingTime , group, "_from_blasting");
    }

    protected static void oreCooking(Consumer<RecipeJsonProvider> consumer, RecipeSerializer<? extends AbstractCookingRecipe> serializer,
                                     List<ItemConvertible> ingredients, RecipeCategory category, ItemConvertible result, float xp, int cookingTime, String group, String recipeName) {
        for (ItemConvertible item : ingredients) {
            CookingRecipeJsonBuilder.create(Ingredient.ofItems(item), category, result, xp, cookingTime, serializer)
                    .group(group)
                    .criterion("has_" + item, InventoryChangedCriterion.Conditions.items(item))
                    .offerTo(consumer, ElementaryFabric.MOD_ID + ":" + result + "_from_" + item.asItem() + recipeName);
        }
    }
}
