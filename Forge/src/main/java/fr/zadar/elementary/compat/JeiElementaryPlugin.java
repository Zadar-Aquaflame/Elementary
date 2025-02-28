package fr.zadar.elementary.compat;

import fr.zadar.elementary.ElementaryForge;
import fr.zadar.elementary.recipe.ElementsImprovementRecipe;
import fr.zadar.elementary.screen.ElementsImprovementScreen;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;

@JeiPlugin
public class JeiElementaryPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(ElementaryForge.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new ElementsImprovementCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();

        List<ElementsImprovementRecipe> improvementRecipes = recipeManager.getAllRecipesFor(ElementsImprovementRecipe.Type.INSTANCE);
        registration.addRecipes(ElementsImprovementCategory.ELEMENTS_IMPROVEMENT_TYPE, improvementRecipes);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(ElementsImprovementScreen.class, 55, 34, 55, 17,
                ElementsImprovementCategory.ELEMENTS_IMPROVEMENT_TYPE);
    }
}
