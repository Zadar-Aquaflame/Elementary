package fr.zadar.elementary.data.recipe;

import fr.zadar.elementary.ElementaryForge;
import fr.zadar.elementary.block.ModBlocks;
import fr.zadar.elementary.item.ModItems;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class CraftingRecipes {
    public static void register(Consumer<FinishedRecipe> consumer) {
        recipesBlocks(consumer);
        recipesItems(consumer);
        recipesTools(consumer);
        recipesArmor(consumer);
    }

    private static void recipesBlocks(Consumer<FinishedRecipe> consumer) {
        recipeFullBlock(consumer, ModItems.EMBERSTONE_INGOT.get(), ModBlocks.EMBERSTONE_BLOCK.get());
        recipeFullBlock(consumer, ModItems.RAW_EMBERSTONE.get(), ModBlocks.RAW_EMBERSTONE_BLOCK.get());
        recipeFullBlock(consumer, ModItems.HYDROSTONE_INGOT.get(), ModBlocks.HYDROSTONE_BLOCK.get());
        recipeFullBlock(consumer, ModItems.RAW_HYDROSTONE.get(), ModBlocks.RAW_HYDROSTONE_BLOCK.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ELEMENTS_IMPROVEMENT.get())
                .pattern(" S ")
                .pattern("S#S")
                .pattern("ABA")
                .define('S', Items.OBSIDIAN)
                .define('#', Items.GOLD_INGOT)
                .define('A', Items.BLACKSTONE)
                .define('B', ModItems.ETHEREAL_HEART.get())
                .unlockedBy("has_item", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ETHEREAL_HEART.get()))
                .save(consumer, new ResourceLocation(ElementaryForge.MOD_ID, "elements_improvement"));
    }

    private static void recipesItems(Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.EMBERSTONE_INGOT.get(), 9)
                .requires(ModBlocks.EMBERSTONE_BLOCK.get())
                .unlockedBy("has_emberstone_block", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.EMBERSTONE_INGOT.get()))
                .save(consumer, new ResourceLocation(ElementaryForge.MOD_ID, "emberstone_ingot_from_emberstone_block"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_EMBERSTONE.get(), 9)
                .requires(ModBlocks.RAW_EMBERSTONE_BLOCK.get())
                .unlockedBy("has_raw_emberstone_block", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RAW_EMBERSTONE.get()))
                .save(consumer, new ResourceLocation(ElementaryForge.MOD_ID, "raw_emberstone_from_raw_emberstone_block"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.HYDROSTONE_INGOT.get(), 9)
                .requires(ModBlocks.HYDROSTONE_BLOCK.get())
                .unlockedBy("has_emberstone_block", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.HYDROSTONE_INGOT.get()))
                .save(consumer, new ResourceLocation(ElementaryForge.MOD_ID, "hydrostone_ingot_from_hydrostone_block"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_HYDROSTONE.get(), 9)
                .requires(ModBlocks.RAW_HYDROSTONE_BLOCK.get())
                .unlockedBy("has_raw_emberstone_block", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.RAW_HYDROSTONE.get()))
                .save(consumer, new ResourceLocation(ElementaryForge.MOD_ID, "raw_hydrostone_from_raw_hydrostone_block"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ETHEREAL_HEART.get())
                .requires(ModItems.FIRE_CRYSTAL.get())
                .requires(ModItems.MYSTIC_ASH.get())
                .unlockedBy("has_fire_crystal", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.FIRE_CRYSTAL.get()))
                .unlockedBy("has_mystic_ash", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.MYSTIC_ASH.get()))
                .save(consumer, new ResourceLocation(ElementaryForge.MOD_ID, "ethereal_heart"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FIRE_FERROCRYSTAL_STICK.get(), 4)
                .pattern("#")
                .pattern("#")
                .define('#', ModItems.FIRE_FERROCRYSTAL_INGOT.get())
                .unlockedBy("has_fire_ferrocrystal_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.FIRE_FERROCRYSTAL_INGOT.get()))
                .save(consumer, new ResourceLocation(ElementaryForge.MOD_ID, "fire_ferrocrystal_stick"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ETHEREAL_HEART.get())
                .requires(ModItems.WATER_CRYSTAL.get())
                .requires(ModItems.TEAR_DROP.get())
                .unlockedBy("has_water_crystal", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.WATER_CRYSTAL.get()))
                .unlockedBy("has_tear_drop", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.TEAR_DROP.get()))
                .save(consumer, new ResourceLocation(ElementaryForge.MOD_ID, "ethereal_heart_1"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.WATER_FERROCRYSTAL_STICK.get(), 4)
                .pattern("#")
                .pattern("#")
                .define('#', ModItems.WATER_FERROCRYSTAL_INGOT.get())
                .unlockedBy("has_water_ferrocrystal_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.WATER_FERROCRYSTAL_INGOT.get()))
                .save(consumer, new ResourceLocation(ElementaryForge.MOD_ID, "water_ferrocrystal_stick"));
    }

    private static void recipesTools(Consumer<FinishedRecipe> consumer) {
        recipeSword(consumer, ModItems.EMBERSTONE_INGOT.get(), Items.STICK, ModItems.EMBERSTONE_SWORD.get());
        recipePickaxe(consumer, ModItems.EMBERSTONE_INGOT.get(), Items.STICK, ModItems.EMBERSTONE_PICKAXE.get());
        recipeAxe(consumer, ModItems.EMBERSTONE_INGOT.get(), Items.STICK, ModItems.EMBERSTONE_AXE.get());
        recipeShovel(consumer, ModItems.EMBERSTONE_INGOT.get(), Items.STICK, ModItems.EMBERSTONE_SHOVEL.get());
        recipeHoe(consumer, ModItems.EMBERSTONE_INGOT.get(), Items.STICK, ModItems.EMBERSTONE_HOE.get());

        recipeSword(consumer, ModItems.HYDROSTONE_INGOT.get(), Items.STICK, ModItems.HYDROSTONE_SWORD.get());
        recipePickaxe(consumer, ModItems.HYDROSTONE_INGOT.get(), Items.STICK, ModItems.HYDROSTONE_PICKAXE.get());
        recipeAxe(consumer, ModItems.HYDROSTONE_INGOT.get(), Items.STICK, ModItems.HYDROSTONE_AXE.get());
        recipeShovel(consumer, ModItems.HYDROSTONE_INGOT.get(), Items.STICK, ModItems.HYDROSTONE_SHOVEL.get());
        recipeHoe(consumer, ModItems.HYDROSTONE_INGOT.get(), Items.STICK, ModItems.HYDROSTONE_HOE.get());

        recipeSword(consumer, ModItems.EMBERITE_INGOT.get(), ModItems.FIRE_FERROCRYSTAL_STICK.get(), ModItems.EMBERITE_SWORD.get());
        recipePickaxe(consumer, ModItems.EMBERITE_INGOT.get(), ModItems.FIRE_FERROCRYSTAL_STICK.get(), ModItems.EMBERITE_PICKAXE.get());
        recipeAxe(consumer, ModItems.EMBERITE_INGOT.get(), ModItems.FIRE_FERROCRYSTAL_STICK.get(), ModItems.EMBERITE_AXE.get());
        recipeShovel(consumer, ModItems.EMBERITE_INGOT.get(), ModItems.FIRE_FERROCRYSTAL_STICK.get(), ModItems.EMBERITE_SHOVEL.get());
        recipeHoe(consumer, ModItems.EMBERITE_INGOT.get(), ModItems.FIRE_FERROCRYSTAL_STICK.get(), ModItems.EMBERITE_HOE.get());

        recipeSword(consumer, ModItems.AQUALITE_INGOT.get(), ModItems.WATER_FERROCRYSTAL_STICK.get(), ModItems.AQUALITE_SWORD.get());
        recipePickaxe(consumer, ModItems.AQUALITE_INGOT.get(), ModItems.WATER_FERROCRYSTAL_STICK.get(), ModItems.AQUALITE_PICKAXE.get());
        recipeAxe(consumer, ModItems.AQUALITE_INGOT.get(), ModItems.WATER_FERROCRYSTAL_STICK.get(), ModItems.AQUALITE_AXE.get());
        recipeShovel(consumer, ModItems.AQUALITE_INGOT.get(), ModItems.WATER_FERROCRYSTAL_STICK.get(), ModItems.AQUALITE_SHOVEL.get());
        recipeHoe(consumer, ModItems.AQUALITE_INGOT.get(), ModItems.WATER_FERROCRYSTAL_STICK.get(), ModItems.AQUALITE_HOE.get());
    }

    private static void recipesArmor(Consumer<FinishedRecipe> consumer) {
        recipeHelmet(consumer, ModItems.EMBERSTONE_INGOT.get(), ModItems.EMBERSTONE_HELMET.get());
        recipeChestplate(consumer, ModItems.EMBERSTONE_INGOT.get(), ModItems.EMBERSTONE_CHESTPLATE.get());
        recipeLeggings(consumer, ModItems.EMBERSTONE_INGOT.get(), ModItems.EMBERSTONE_LEGGINGS.get());
        recipeBoots(consumer, ModItems.EMBERSTONE_INGOT.get(), ModItems.EMBERSTONE_BOOTS.get());

        recipeHelmet(consumer, ModItems.HYDROSTONE_INGOT.get(), ModItems.HYDROSTONE_HELMET.get());
        recipeChestplate(consumer, ModItems.HYDROSTONE_INGOT.get(), ModItems.HYDROSTONE_CHESTPLATE.get());
        recipeLeggings(consumer, ModItems.HYDROSTONE_INGOT.get(), ModItems.HYDROSTONE_LEGGINGS.get());
        recipeBoots(consumer, ModItems.HYDROSTONE_INGOT.get(), ModItems.HYDROSTONE_BOOTS.get());

        recipeHelmet(consumer, ModItems.EMBERSTONE_INGOT.get(), ModItems.EMBERITE_HELMET.get());
        recipeChestplate(consumer, ModItems.EMBERSTONE_INGOT.get(), ModItems.EMBERITE_CHESTPLATE.get());
        recipeLeggings(consumer, ModItems.EMBERSTONE_INGOT.get(), ModItems.EMBERITE_LEGGINGS.get());
        recipeBoots(consumer, ModItems.EMBERSTONE_INGOT.get(), ModItems.EMBERITE_BOOTS.get());

        recipeHelmet(consumer, ModItems.AQUALITE_INGOT.get(), ModItems.AQUALITE_HELMET.get());
        recipeChestplate(consumer, ModItems.AQUALITE_INGOT.get(), ModItems.AQUALITE_CHESTPLATE.get());
        recipeLeggings(consumer, ModItems.AQUALITE_INGOT.get(), ModItems.AQUALITE_LEGGINGS.get());
        recipeBoots(consumer, ModItems.AQUALITE_INGOT.get(), ModItems.AQUALITE_BOOTS.get());
    }

    private static void recipeSword(@NotNull final Consumer<FinishedRecipe> consumer, final Item material1, final Item material2, final ItemLike result) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, result)
                .pattern("#")
                .pattern("#")
                .pattern("S")
                .define('#', material1)
                .define('S', material2)
                .unlockedBy("has_item", InventoryChangeTrigger.TriggerInstance.hasItems(material1))
                .save(consumer);
    }

    private static void recipePickaxe(@NotNull final Consumer<FinishedRecipe> consumer, final Item material1, final Item material2, final ItemLike result) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, result)
                .pattern("###")
                .pattern(" S ")
                .pattern(" S ")
                .define('#', material1)
                .define('S', material2)
                .unlockedBy("has_item", InventoryChangeTrigger.TriggerInstance.hasItems(material1))
                .save(consumer);
    }

    private static void recipeAxe(@NotNull final Consumer<FinishedRecipe> consumer, final Item material1, final Item material2, final ItemLike result) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, result)
                .pattern("##")
                .pattern("S#")
                .pattern("S ")
                .define('#', material1)
                .define('S', material2)
                .unlockedBy("has_item", InventoryChangeTrigger.TriggerInstance.hasItems(material1))
                .save(consumer);
    }

    private static void recipeShovel(@NotNull final Consumer<FinishedRecipe> consumer, final Item material1, final Item material2, final ItemLike result) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, result)
                .pattern("#")
                .pattern("S")
                .pattern("S")
                .define('#', material1)
                .define('S', material2)
                .unlockedBy("has_item", InventoryChangeTrigger.TriggerInstance.hasItems(material1))
                .save(consumer);
    }

    private static void recipeHoe(@NotNull final Consumer<FinishedRecipe> consumer, final Item material1, final Item material2, final ItemLike result) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, result)
                .pattern("##")
                .pattern("S ")
                .pattern("S ")
                .define('#', material1)
                .define('S', material2)
                .unlockedBy("has_item", InventoryChangeTrigger.TriggerInstance.hasItems(material1))
                .save(consumer);
    }

    private static void recipeHelmet(@NotNull final Consumer<FinishedRecipe> consumer, final Item material1, final ItemLike result) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, result)
                .pattern("###")
                .pattern("# #")
                .define('#', material1)
                .unlockedBy("has_item", InventoryChangeTrigger.TriggerInstance.hasItems(material1))
                .save(consumer);
    }

    private static void recipeChestplate(@NotNull final Consumer<FinishedRecipe> consumer, final Item material1, final ItemLike result) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, result)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .define('#', material1)
                .unlockedBy("has_item", InventoryChangeTrigger.TriggerInstance.hasItems(material1))
                .save(consumer);
    }

    private static void recipeLeggings(@NotNull final Consumer<FinishedRecipe> consumer, final Item material1, final ItemLike result) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, result)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .define('#', material1)
                .unlockedBy("has_item", InventoryChangeTrigger.TriggerInstance.hasItems(material1))
                .save(consumer);
    }

    private static void recipeBoots(@NotNull final Consumer<FinishedRecipe> consumer, final Item material1, final ItemLike result) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, result)
                .pattern("# #")
                .pattern("# #")
                .define('#', material1)
                .unlockedBy("has_item", InventoryChangeTrigger.TriggerInstance.hasItems(material1))
                .save(consumer);
    }

    private static void recipeFullBlock(Consumer<FinishedRecipe> consumer, final Item material, final ItemLike result) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, result)
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', material)
                .unlockedBy("has_item", InventoryChangeTrigger.TriggerInstance.hasItems(material))
                .save(consumer);
    }
}