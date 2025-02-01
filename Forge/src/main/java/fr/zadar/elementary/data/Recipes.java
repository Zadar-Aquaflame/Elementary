package fr.zadar.elementary.data;

import fr.zadar.elementary.data.recipe.BlastingRecipes;
import fr.zadar.elementary.data.recipe.CraftingRecipes;
import fr.zadar.elementary.data.recipe.SmeltingRecipes;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;

import java.util.function.Consumer;

public class Recipes extends RecipeProvider {
    public Recipes(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        CraftingRecipes.register(consumer);
        SmeltingRecipes.register(consumer);
        BlastingRecipes.register(consumer);
    }
}
