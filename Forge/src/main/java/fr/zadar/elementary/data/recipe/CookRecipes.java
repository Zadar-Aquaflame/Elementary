package fr.zadar.elementary.data.recipe;

import fr.zadar.elementary.ElementaryForge;
import fr.zadar.elementary.block.ModBlocks;
import fr.zadar.elementary.item.ModItems;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;

import java.util.List;
import java.util.function.Consumer;

public class CookRecipes {
    private static final List<ItemLike> EMBERSTONE = List.of(ModItems.RAW_EMBERSTONE.get(),
            ModBlocks.EMBERSTONE_ORE.get(), ModBlocks.DEEPSLATE_EMBERSTONE_ORE.get(), ModBlocks.NETHER_EMBERSTONE_ORE.get());
    private static final List<ItemLike> HYDROSTONE = List.of(ModItems.RAW_HYDROSTONE.get(),
            ModBlocks.HYDROSTONE_ORE.get(), ModBlocks.DEEPSLATE_HYDROSTONE_ORE.get());
    private static final List<ItemLike> AERITHIUM = List.of(ModItems.RAW_AERITHIUM.get(),
            ModBlocks.AERITHIUM_ORE.get(), ModBlocks.DEEPSLATE_AERITHIUM_ORE.get());

    private static final List<ItemLike> FIRE_CRYSTAL = List.of(ModBlocks.FIRE_CRYSTAL_ORE.get(),
            ModBlocks.DEEPSLATE_FIRE_CRYSTAL_ORE.get());
    private static final List<ItemLike> WATER_CRYSTAL = List.of(ModBlocks.WATER_CRYSTAL_ORE.get(),
            ModBlocks.DEEPSLATE_WATER_CRYSTAL_ORE.get());
    private static final List<ItemLike> AIR_CRYSTAL = List.of(ModBlocks.AIR_CRYSTAL_ORE.get(),
            ModBlocks.DEEPSLATE_AIR_CRYSTAL_ORE.get());

    public static void register(Consumer<FinishedRecipe> consumer) {
        oreSmelting(consumer, EMBERSTONE, RecipeCategory.MISC, ModItems.EMBERSTONE_INGOT.get(), 0.45f, 200, "emberstone");
        oreBlasting(consumer, EMBERSTONE, RecipeCategory.MISC, ModItems.EMBERSTONE_INGOT.get(), 0.45f, 100, "emberstone");

        oreSmelting(consumer, HYDROSTONE, RecipeCategory.MISC, ModItems.HYDROSTONE_INGOT.get(), 0.50f, 200, "hydrostone");
        oreBlasting(consumer, HYDROSTONE, RecipeCategory.MISC, ModItems.HYDROSTONE_INGOT.get(), 0.50f, 100, "hydrostone");

        oreSmelting(consumer, AERITHIUM, RecipeCategory.MISC, ModItems.AERITHIUM_INGOT.get(), 0.45f, 200, "aerithium");
        oreBlasting(consumer, AERITHIUM, RecipeCategory.MISC, ModItems.AERITHIUM_INGOT.get(), 0.45f, 100, "aerithium");

        oreSmelting(consumer, FIRE_CRYSTAL, RecipeCategory.MISC, ModItems.FIRE_CRYSTAL.get(), 0.45f, 200, "fire_crystal");
        oreBlasting(consumer, FIRE_CRYSTAL, RecipeCategory.MISC, ModItems.FIRE_CRYSTAL.get(), 0.45f, 100, "fire_crystal");

        oreSmelting(consumer, WATER_CRYSTAL, RecipeCategory.MISC, ModItems.WATER_CRYSTAL.get(), 0.45f, 200, "water_crystal");
        oreBlasting(consumer, WATER_CRYSTAL, RecipeCategory.MISC, ModItems.WATER_CRYSTAL.get(), 0.45f, 100, "water_crystal");

        oreSmelting(consumer, AIR_CRYSTAL, RecipeCategory.MISC, ModItems.AIR_CRYSTAL.get(), 0.45f, 200, "air_crystal");
        oreBlasting(consumer, AIR_CRYSTAL, RecipeCategory.MISC, ModItems.AIR_CRYSTAL.get(), 0.45f, 100, "air_crystal");
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> consumer, List<ItemLike> ingredients, RecipeCategory category, ItemLike result,
                                      float xp, int cookingTime, String group) {
        oreCooking(consumer, RecipeSerializer.SMELTING_RECIPE, ingredients, category, result,
                xp, cookingTime, group, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> consumer, List<ItemLike> ingredients, RecipeCategory category, ItemLike result,
                                      float xp, int cookingTime, String group) {
        oreCooking(consumer, RecipeSerializer.BLASTING_RECIPE, ingredients, category, result,
                xp, cookingTime, group, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> consumer, RecipeSerializer<? extends AbstractCookingRecipe> serializer,
                                     List<ItemLike> ingredients, RecipeCategory category, ItemLike result, float xp, int cookingTime, String group, String recipeName) {
        for(ItemLike item : ingredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(item), category, result, xp, cookingTime, serializer)
                    .group(group)
                    .unlockedBy("has_" + item, InventoryChangeTrigger.TriggerInstance.hasItems(item))
                    .save(consumer, ElementaryForge.MOD_ID + ":" + result + "_from_" + item.asItem() + recipeName);
        }
    }
}