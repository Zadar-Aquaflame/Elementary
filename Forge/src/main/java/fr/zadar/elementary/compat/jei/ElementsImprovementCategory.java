package fr.zadar.elementary.compat.jei;

import fr.zadar.elementary.ElementaryForge;
import fr.zadar.elementary.block.ModBlocks;
import fr.zadar.elementary.recipe.ElementsImprovementRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class ElementsImprovementCategory implements IRecipeCategory<ElementsImprovementRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(ElementaryForge.MOD_ID, "elements_improvement");
    public static final ResourceLocation TEXTURE = new ResourceLocation(ElementaryForge.MOD_ID, "textures/gui/compat/elements_improvement_gui_simplified.png");
    public static final RecipeType<ElementsImprovementRecipe> ELEMENTS_IMPROVEMENT_TYPE = new RecipeType<>(UID, ElementsImprovementRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public ElementsImprovementCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 97, 67);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.ELEMENTS_IMPROVEMENT.get()));
    }

    @Override
    public RecipeType<ElementsImprovementRecipe> getRecipeType() {
        return ELEMENTS_IMPROVEMENT_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.elementary.elements_improvement");
    }

    @Override
    public @Nullable IDrawable getBackground() {
        return this.background;
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, ElementsImprovementRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 9, 8).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 9, 44).addIngredients(recipe.getIngredients().get(1));
        builder.addSlot(RecipeIngredientRole.OUTPUT, 69, 26).addItemStack(recipe.getResultItem(null));
    }
}
