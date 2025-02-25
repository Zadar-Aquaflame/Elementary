package fr.zadar.elementary.recipe;

import fr.zadar.elementary.ElementaryForge;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, ElementaryForge.MOD_ID);

    public static final RegistryObject<RecipeSerializer<ElementsImprovementRecipe>> ELEMENTS_IMPROVEMENT_SERIALIZER =
            SERIALIZERS.register("elements_improvement_serializer", () -> ElementsImprovementRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
