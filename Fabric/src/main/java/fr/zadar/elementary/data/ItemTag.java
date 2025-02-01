package fr.zadar.elementary.data;

import fr.zadar.elementary.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ItemTag extends FabricTagProvider.ItemTagProvider {
    public ItemTag(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.EMBERSTONE_HELMET)
                .add(ModItems.EMBERSTONE_CHESTPLATE)
                .add(ModItems.EMBERSTONE_LEGGINGS)
                .add(ModItems.EMBERSTONE_BOOTS);
    }
}
