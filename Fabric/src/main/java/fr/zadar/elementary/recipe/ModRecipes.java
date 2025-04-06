package fr.zadar.elementary.recipe;

import fr.zadar.elementary.ElementaryFabric;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {
    public static void registerRecipes() {
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(ElementaryFabric.MOD_ID, ElementsImprovementRecipe.Serializer.ID),
                ElementsImprovementRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(ElementaryFabric.MOD_ID, ElementsImprovementRecipe.Type.ID),
                ElementsImprovementRecipe.Type.INSTANCE);
    }
}
