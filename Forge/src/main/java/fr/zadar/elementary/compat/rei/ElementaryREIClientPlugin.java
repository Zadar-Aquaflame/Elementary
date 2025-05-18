package fr.zadar.elementary.compat.rei;

import fr.zadar.elementary.block.ModBlocks;
import fr.zadar.elementary.recipe.ElementsImprovementRecipe;
import fr.zadar.elementary.screen.ElementsImprovementScreen;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.screen.ScreenRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;
import me.shedaniel.rei.forge.REIPluginClient;

@REIPluginClient
public class ElementaryREIClientPlugin implements REIClientPlugin {
    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new ElementsImprovementCategory());

        registry.addWorkstations(ElementsImprovementCategory.ELEMENTS_IMPROVEMENT, EntryStacks.of(ModBlocks.ELEMENTS_IMPROVEMENT.get()));
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.registerRecipeFiller(ElementsImprovementRecipe.class, ElementsImprovementRecipe.Type.INSTANCE, ElementsImprovementDisplay::new);
    }

    @Override
    public void registerScreens(ScreenRegistry registry) {
        registry.registerContainerClickArea(new Rectangle(55, 34, 55, 17),
                ElementsImprovementScreen.class, ElementsImprovementCategory.ELEMENTS_IMPROVEMENT);
    }
}
