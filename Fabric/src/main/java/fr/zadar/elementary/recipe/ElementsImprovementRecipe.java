package fr.zadar.elementary.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public class ElementsImprovementRecipe implements Recipe<SimpleInventory> {
    private final ItemStack result;
    private final DefaultedList<Ingredient> recipeItems;
    private final Identifier id;

    public ElementsImprovementRecipe(DefaultedList<Ingredient> ingredients, ItemStack result, Identifier id) {
        this.result = result;
        this.recipeItems = ingredients;
        this.id = id;
    }

    @Override
    public boolean matches(SimpleInventory inventory, World world) {
        if (world.isClient()) {
            return false;
        }

        return recipeItems.get(0).test(inventory.getStack(0)) && recipeItems.get(1).test(inventory.getStack(1));
    }

    @Override
    public ItemStack craft(SimpleInventory inventory, DynamicRegistryManager registryManager) {
        return result;
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getOutput(DynamicRegistryManager registryManager) {
        return result;
    }

    @Override
    public DefaultedList<Ingredient> getIngredients() {
        return recipeItems;
    }

    @Override
    public Identifier getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<ElementsImprovementRecipe> {
        public static final Type INSTANCE = new Type();
        public static final String ID = "elements_improvement";
    }

    // Code inspired by Farmer's Delight (original version and fabric version)
    // official version : https://github.com/vectorwing/FarmersDelight
    // fabric version : https://github.com/newhoryzon/farmers-delight-fabric
    public static class Serializer implements RecipeSerializer<ElementsImprovementRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final String ID = "elements_improvement";

        private static DefaultedList<Ingredient> readIngredients(JsonArray ingredientArray) {
            DefaultedList<Ingredient> ingredientList = DefaultedList.of();

            for (int i = 0; i < ingredientArray.size(); ++i) {
                Ingredient ingredient = Ingredient.fromJson(ingredientArray.get(i));
                if (!ingredient.isEmpty()) {
                    ingredientList.add(ingredient);
                }
            }

            return ingredientList;
        }

        @Override
        public ElementsImprovementRecipe read(Identifier id, JsonObject json) {
            final DefaultedList<Ingredient> inputItems = readIngredients(JsonHelper.getArray(json, "ingredients"));
            if (inputItems.size() > 2) {
                throw  new JsonParseException("Too many ingredients for cooking recipe ! The max is " + 2);
            } else {
                final JsonObject jsonResult = JsonHelper.getObject(json, "result");
                final ItemStack result = new ItemStack(JsonHelper.getItem(jsonResult, "item"), JsonHelper.getInt(jsonResult, "count", 1));

                return new ElementsImprovementRecipe(inputItems, result, id);
            }
        }

        @Override
        public ElementsImprovementRecipe read(Identifier id, PacketByteBuf buf) {
            int ingredientSize = buf.readVarInt();
            DefaultedList<Ingredient> ingredientList = DefaultedList.ofSize(ingredientSize, Ingredient.EMPTY);
            ingredientList.replaceAll(ignored -> Ingredient.fromPacket(buf));

            ItemStack result = buf.readItemStack();

            return new ElementsImprovementRecipe(ingredientList, result, id);
        }

        @Override
        public void write(PacketByteBuf buf, ElementsImprovementRecipe recipe) {
            buf.writeVarInt(recipe.getIngredients().size());

            for (Ingredient ingredient : recipe.getIngredients()) {
                ingredient.write(buf);
            }

            buf.writeItemStack(recipe.result);
        }
    }
}
