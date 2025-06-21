package fr.zadar.elementary.data;

import fr.zadar.elementary.data.recipe.CookRecipes;
import fr.zadar.elementary.data.recipe.CraftingRecipes;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;

import java.util.function.Consumer;

public class Recipes extends FabricRecipeProvider {
    public Recipes(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> consumer) {
        CookRecipes.register(consumer);
        CraftingRecipes.register(consumer);
    }
}
