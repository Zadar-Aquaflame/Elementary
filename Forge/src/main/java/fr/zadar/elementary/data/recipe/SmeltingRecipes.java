package fr.zadar.elementary.data.recipe;

import fr.zadar.elementary.ElementaryForge;
import fr.zadar.elementary.block.ModBlocks;
import fr.zadar.elementary.item.ModItems;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Consumer;

public class SmeltingRecipes {
    public static void register(Consumer<FinishedRecipe> consumer) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.RAW_EMBERSTONE.get()), RecipeCategory.MISC,
                        ModItems.EMBERSTONE_INGOT.get(), 0.45f, 200)
                .unlockedBy("has_raw_emberstone", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RAW_EMBERSTONE.get()))
                .save(consumer, new ResourceLocation(ElementaryForge.MOD_ID, "emberstone_ingot_from_raw_emberstone") + "_smelting");
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModBlocks.EMBERSTONE_ORE.get()), RecipeCategory.MISC,
                        ModItems.EMBERSTONE_INGOT.get(), 0.45f, 200)
                .unlockedBy("has_emberstone_ore", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.EMBERSTONE_ORE.get()))
                .save(consumer, new ResourceLocation(ElementaryForge.MOD_ID, "emberstone_ingot_from_emberstone_ore") + "_smelting");
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModBlocks.DEEPSLATE_EMBERSTONE_ORE.get()), RecipeCategory.MISC,
                        ModItems.EMBERSTONE_INGOT.get(), 0.45f, 200)
                .unlockedBy("has_emberstone_ore", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.DEEPSLATE_EMBERSTONE_ORE.get()))
                .save(consumer, new ResourceLocation(ElementaryForge.MOD_ID, "emberstone_ingot_from_deepslate_emberstone_ore") + "_smelting");
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModBlocks.NETHER_EMBERSTONE_ORE.get()), RecipeCategory.MISC,
                        ModItems.EMBERSTONE_INGOT.get(), 0.45f, 200)
                .unlockedBy("has_emberstone_ore", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.NETHER_EMBERSTONE_ORE.get()))
                .save(consumer, new ResourceLocation(ElementaryForge.MOD_ID, "emberstone_ingot_from_nether_emberstone_ore") + "_smelting");

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.RAW_HYDROSTONE.get()), RecipeCategory.MISC,
                        ModItems.HYDROSTONE_INGOT.get(), 0.45f, 200)
                .unlockedBy("has_raw_hydrostone", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RAW_HYDROSTONE.get()))
                .save(consumer, new ResourceLocation(ElementaryForge.MOD_ID, "hydrostone_ingot_from_raw_hydrostone") + "_smelting");
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModBlocks.HYDROSTONE_ORE.get()), RecipeCategory.MISC,
                        ModItems.HYDROSTONE_INGOT.get(), 0.45f, 200)
                .unlockedBy("has_hydrostone_ore", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.HYDROSTONE_ORE.get()))
                .save(consumer, new ResourceLocation(ElementaryForge.MOD_ID, "hydrostone_ingot_from_hydrostone_ore") + "_smelting");
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModBlocks.DEEPSLATE_HYDROSTONE_ORE.get()), RecipeCategory.MISC,
                        ModItems.HYDROSTONE_INGOT.get(), 0.45f, 200)
                .unlockedBy("has_hydrostone_ore", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.DEEPSLATE_HYDROSTONE_ORE.get()))
                .save(consumer, new ResourceLocation(ElementaryForge.MOD_ID, "hydrostone_ingot_from_deepslate_hydrostone_ore") + "_smelting");
    }
}