package fr.zadar.elementary.data;

import fr.zadar.elementary.data.recipe.BlastingRecipes;
import fr.zadar.elementary.data.recipe.CraftingRecipes;
import fr.zadar.elementary.data.recipe.SmeltingRecipes;
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
        SmeltingRecipes.register(consumer);
        BlastingRecipes.register(consumer);
        CraftingRecipes.register(consumer);
    }
}
