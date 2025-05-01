package fr.zadar.elementary.data.recipe;

import fr.zadar.elementary.block.ModBlocks;
import fr.zadar.elementary.item.ModItems;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

import static net.minecraft.data.server.recipe.RecipeProvider.*;

public class CraftingRecipes {
    public static void register(Consumer<RecipeJsonProvider> consumer) {
        recipesBlocks(consumer);
        recipesItems(consumer);
        recipesTools(consumer);
        recipesArmor(consumer);
    }

    private static void recipesBlocks(Consumer<RecipeJsonProvider> consumer) {
        recipeFullBlock(consumer, ModItems.EMBERSTONE_INGOT, ModBlocks.EMBERSTONE_BLOCK);
        recipeFullBlock(consumer, ModItems.RAW_EMBERSTONE, ModBlocks.RAW_EMBERSTONE_BLOCK);
        recipeFullBlock(consumer, ModItems.HYDROSTONE_INGOT, ModBlocks.HYDROSTONE_BLOCK);
        recipeFullBlock(consumer, ModItems.RAW_HYDROSTONE, ModBlocks.RAW_HYDROSTONE_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ELEMENTS_IMPROVEMENT)
                .pattern(" S ")
                .pattern("S#S")
                .pattern("ABA")
                .input('S', Items.OBSIDIAN)
                .input('#', Items.GOLD_INGOT)
                .input('A', Items.BLACKSTONE)
                .input('B', ModItems.ETHEREAL_HEART)
                .criterion(hasItem(ModItems.ETHEREAL_HEART), conditionsFromItem(ModItems.ETHEREAL_HEART))
                .offerTo(consumer, new Identifier(getRecipeName(ModBlocks.ELEMENTS_IMPROVEMENT) + "_"));
    }

    private static void recipesItems(Consumer<RecipeJsonProvider> consumer) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.EMBERSTONE_INGOT, 9)
                .input(ModBlocks.EMBERSTONE_BLOCK)
                .criterion(hasItem(ModBlocks.EMBERSTONE_BLOCK), conditionsFromItem(ModBlocks.EMBERSTONE_BLOCK))
                .offerTo(consumer, new Identifier(getRecipeName(ModItems.EMBERSTONE_INGOT) + "_"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_EMBERSTONE, 9)
                .input(ModBlocks.RAW_EMBERSTONE_BLOCK)
                .criterion(hasItem(ModBlocks.RAW_EMBERSTONE_BLOCK), conditionsFromItem(ModBlocks.RAW_EMBERSTONE_BLOCK))
                .offerTo(consumer, new Identifier(getRecipeName(ModItems.RAW_EMBERSTONE) + "_"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.HYDROSTONE_INGOT, 9)
                .input(ModBlocks.HYDROSTONE_BLOCK)
                .criterion(hasItem(ModBlocks.HYDROSTONE_BLOCK), conditionsFromItem(ModBlocks.HYDROSTONE_BLOCK))
                .offerTo(consumer, new Identifier(getRecipeName(ModItems.HYDROSTONE_INGOT) + "_"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_HYDROSTONE, 9)
                .input(ModBlocks.RAW_HYDROSTONE_BLOCK)
                .criterion(hasItem(ModBlocks.RAW_HYDROSTONE_BLOCK), conditionsFromItem(ModBlocks.RAW_HYDROSTONE_BLOCK))
                .offerTo(consumer, new Identifier(getRecipeName(ModItems.RAW_HYDROSTONE) + "_"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ETHEREAL_HEART)
                .input(ModItems.FIRE_CRYSTAL)
                .input(ModItems.MYSTIC_ASH)
                .criterion(hasItem(ModItems.FIRE_CRYSTAL), conditionsFromItem(ModItems.FIRE_CRYSTAL))
                .criterion(hasItem(ModItems.MYSTIC_ASH), conditionsFromItem(ModItems.MYSTIC_ASH))
                .offerTo(consumer, new Identifier(getRecipeName(ModItems.ETHEREAL_HEART) + "_"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ETHEREAL_HEART)
                .input(ModItems.WATER_CRYSTAL)
                .input(ModItems.TEAR_DROP)
                .criterion(hasItem(ModItems.WATER_CRYSTAL), conditionsFromItem(ModItems.WATER_CRYSTAL))
                .criterion(hasItem(ModItems.TEAR_DROP), conditionsFromItem(ModItems.TEAR_DROP))
                .offerTo(consumer, new Identifier(getRecipeName(ModItems.ETHEREAL_HEART) + "_1_"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.FIRE_FERROCRYSTAL_STICK, 4)
                .pattern("#")
                .pattern("#")
                .input('#', ModItems.FIRE_FERROCRYSTAL_INGOT)
                .criterion(hasItem(ModItems.FIRE_FERROCRYSTAL_INGOT), conditionsFromItem(ModItems.FIRE_FERROCRYSTAL_INGOT))
                .offerTo(consumer, new Identifier(getRecipeName(ModItems.FIRE_FERROCRYSTAL_STICK) + "_"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.WATER_FERROCRYSTAL_STICK, 4)
                .pattern("#")
                .pattern("#")
                .input('#', ModItems.WATER_FERROCRYSTAL_INGOT)
                .criterion(hasItem(ModItems.WATER_FERROCRYSTAL_INGOT), conditionsFromItem(ModItems.WATER_FERROCRYSTAL_INGOT))
                .offerTo(consumer, new Identifier(getRecipeName(ModItems.WATER_FERROCRYSTAL_STICK) + "_"));
    }

    private static void recipesTools(Consumer<RecipeJsonProvider> consumer) {
        recipeSword(consumer, ModItems.EMBERSTONE_INGOT, Items.STICK, ModItems.EMBERSTONE_SWORD);
        recipePickaxe(consumer, ModItems.EMBERSTONE_INGOT, Items.STICK, ModItems.EMBERSTONE_PICKAXE);
        recipeAxe(consumer, ModItems.EMBERSTONE_INGOT, Items.STICK, ModItems.EMBERSTONE_AXE);
        recipeShovel(consumer, ModItems.EMBERSTONE_INGOT, Items.STICK, ModItems.EMBERSTONE_SHOVEL);
        recipeHoe(consumer, ModItems.EMBERSTONE_INGOT, Items.STICK, ModItems.EMBERSTONE_HOE);

        recipeSword(consumer, ModItems.HYDROSTONE_INGOT, Items.STICK, ModItems.HYDROSTONE_SWORD);
        recipePickaxe(consumer, ModItems.HYDROSTONE_INGOT, Items.STICK, ModItems.HYDROSTONE_PICKAXE);
        recipeAxe(consumer, ModItems.HYDROSTONE_INGOT, Items.STICK, ModItems.HYDROSTONE_AXE);
        recipeShovel(consumer, ModItems.HYDROSTONE_INGOT, Items.STICK, ModItems.HYDROSTONE_SHOVEL);
        recipeHoe(consumer, ModItems.HYDROSTONE_INGOT, Items.STICK, ModItems.HYDROSTONE_HOE);

        recipeSword(consumer, ModItems.EMBERITE_INGOT, ModItems.FIRE_FERROCRYSTAL_STICK, ModItems.EMBERITE_SWORD);
        recipePickaxe(consumer, ModItems.EMBERITE_INGOT, ModItems.FIRE_FERROCRYSTAL_STICK, ModItems.EMBERITE_PICKAXE);
        recipeAxe(consumer, ModItems.EMBERITE_INGOT, ModItems.FIRE_FERROCRYSTAL_STICK, ModItems.EMBERITE_AXE);
        recipeShovel(consumer, ModItems.EMBERITE_INGOT, ModItems.FIRE_FERROCRYSTAL_STICK, ModItems.EMBERITE_SHOVEL);
        recipeHoe(consumer, ModItems.EMBERITE_INGOT, ModItems.FIRE_FERROCRYSTAL_STICK, ModItems.EMBERITE_HOE);

        recipeSword(consumer, ModItems.AQUALITE_INGOT, ModItems.WATER_FERROCRYSTAL_STICK, ModItems.AQUALITE_SWORD);
        recipePickaxe(consumer, ModItems.AQUALITE_INGOT, ModItems.WATER_FERROCRYSTAL_STICK, ModItems.AQUALITE_PICKAXE);
        recipeAxe(consumer, ModItems.AQUALITE_INGOT, ModItems.WATER_FERROCRYSTAL_STICK, ModItems.AQUALITE_AXE);
        recipeShovel(consumer, ModItems.AQUALITE_INGOT, ModItems.WATER_FERROCRYSTAL_STICK, ModItems.AQUALITE_SHOVEL);
        recipeHoe(consumer, ModItems.AQUALITE_INGOT, ModItems.WATER_FERROCRYSTAL_STICK, ModItems.AQUALITE_HOE);
    }

    private static void recipesArmor(Consumer<RecipeJsonProvider> consumer) {
        recipeHelmet(consumer, ModItems.EMBERSTONE_INGOT, ModItems.EMBERSTONE_HELMET);
        recipeChestplate(consumer, ModItems.EMBERSTONE_INGOT, ModItems.EMBERSTONE_CHESTPLATE);
        recipeLeggings(consumer, ModItems.EMBERSTONE_INGOT, ModItems.EMBERSTONE_LEGGINGS);
        recipeBoots(consumer, ModItems.EMBERSTONE_INGOT, ModItems.EMBERSTONE_BOOTS);

        recipeHelmet(consumer, ModItems.HYDROSTONE_INGOT, ModItems.HYDROSTONE_HELMET);
        recipeChestplate(consumer, ModItems.HYDROSTONE_INGOT, ModItems.HYDROSTONE_CHESTPLATE);
        recipeLeggings(consumer, ModItems.HYDROSTONE_INGOT, ModItems.HYDROSTONE_LEGGINGS);
        recipeBoots(consumer, ModItems.HYDROSTONE_INGOT, ModItems.HYDROSTONE_BOOTS);

        recipeHelmet(consumer, ModItems.EMBERITE_INGOT, ModItems.EMBERITE_HELMET);
        recipeChestplate(consumer, ModItems.EMBERITE_INGOT, ModItems.EMBERITE_CHESTPLATE);
        recipeLeggings(consumer, ModItems.EMBERITE_INGOT, ModItems.EMBERITE_LEGGINGS);
        recipeBoots(consumer, ModItems.EMBERITE_INGOT, ModItems.EMBERITE_BOOTS);

        recipeHelmet(consumer, ModItems.AQUALITE_INGOT, ModItems.AQUALITE_HELMET);
        recipeChestplate(consumer, ModItems.AQUALITE_INGOT, ModItems.AQUALITE_CHESTPLATE);
        recipeLeggings(consumer, ModItems.AQUALITE_INGOT, ModItems.AQUALITE_LEGGINGS);
        recipeBoots(consumer, ModItems.AQUALITE_INGOT, ModItems.AQUALITE_BOOTS);
    }

    private static void recipeSword(Consumer<RecipeJsonProvider> consumer, final ItemConvertible material1, final ItemConvertible material2, final ItemConvertible result) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, result)
                .pattern("S")
                .pattern("S")
                .pattern("#")
                .input('S', material1)
                .input('#', material2)
                .criterion(hasItem(material1), conditionsFromItem(material1))
                .offerTo(consumer, new Identifier(getRecipeName(result) + "_"));
    }

    private static void recipePickaxe(Consumer<RecipeJsonProvider> consumer, final ItemConvertible material1, final ItemConvertible material2, final ItemConvertible result) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, result)
                .pattern("SSS")
                .pattern(" # ")
                .pattern(" # ")
                .input('S', material1)
                .input('#', material2)
                .criterion(hasItem(material1), conditionsFromItem(material1))
                .offerTo(consumer, new Identifier(getRecipeName(result) + "_"));
    }

    private static void recipeAxe(Consumer<RecipeJsonProvider> consumer, final ItemConvertible material1, final ItemConvertible material2, final ItemConvertible result) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, result)
                .pattern("SS")
                .pattern("#S")
                .pattern("# ")
                .input('S', material1)
                .input('#', material2)
                .criterion(hasItem(material1), conditionsFromItem(material1))
                .offerTo(consumer, new Identifier(getRecipeName(result) + "_"));
    }

    private static void recipeShovel(Consumer<RecipeJsonProvider> consumer, final ItemConvertible material1, final ItemConvertible material2, final ItemConvertible result) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, result)
                .pattern("S")
                .pattern("#")
                .pattern("#")
                .input('S', material1)
                .input('#', material2)
                .criterion(hasItem(material1), conditionsFromItem(material1))
                .offerTo(consumer, new Identifier(getRecipeName(result) + "_"));
    }

    private static void recipeHoe(Consumer<RecipeJsonProvider> consumer, final ItemConvertible material1, final ItemConvertible material2, final ItemConvertible result) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, result)
                .pattern("SS")
                .pattern("# ")
                .pattern("# ")
                .input('S', material1)
                .input('#', material2)
                .criterion(hasItem(material1), conditionsFromItem(material1))
                .offerTo(consumer, new Identifier(getRecipeName(result) + "_"));
    }

    private static void recipeHelmet(Consumer<RecipeJsonProvider> consumer, final ItemConvertible material, final ItemConvertible result) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, result)
                .pattern("SSS")
                .pattern("S S")
                .input('S', material)
                .criterion(hasItem(material), conditionsFromItem(material))
                .offerTo(consumer, new Identifier(getRecipeName(result) + "_"));
    }

    private static void recipeChestplate(Consumer<RecipeJsonProvider> consumer, final ItemConvertible material, final ItemConvertible result) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, result)
                .pattern("S S")
                .pattern("SSS")
                .pattern("SSS")
                .input('S', material)
                .criterion(hasItem(material), conditionsFromItem(material))
                .offerTo(consumer, new Identifier(getRecipeName(result) + "_"));
    }

    private static void recipeLeggings(Consumer<RecipeJsonProvider> consumer, final ItemConvertible material, final ItemConvertible result) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, result)
                .pattern("SSS")
                .pattern("S S")
                .pattern("S S")
                .input('S', material)
                .criterion(hasItem(material), conditionsFromItem(material))
                .offerTo(consumer, new Identifier(getRecipeName(result) + "_"));
    }

    private static void recipeBoots(Consumer<RecipeJsonProvider> consumer, final ItemConvertible material, final ItemConvertible result) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, result)
                .pattern("S S")
                .pattern("S S")
                .input('S', material)
                .criterion(hasItem(material), conditionsFromItem(material))
                .offerTo(consumer, new Identifier(getRecipeName(result) + "_"));
    }

    private static void recipeFullBlock(Consumer<RecipeJsonProvider> consumer, final ItemConvertible material, final ItemConvertible result) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, result)
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .input('S', material)
                .criterion(hasItem(material), conditionsFromItem(material))
                .offerTo(consumer, new Identifier(getRecipeName(result) + "_"));
    }
}
