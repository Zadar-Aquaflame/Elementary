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
                .add(ModItems.EMBERSTONE_BOOTS)

                .add(ModItems.HYDROSTONE_HELMET)
                .add(ModItems.HYDROSTONE_CHESTPLATE)
                .add(ModItems.HYDROSTONE_LEGGINGS)
                .add(ModItems.HYDROSTONE_BOOTS)

                .add(ModItems.EMBERITE_HELMET)
                .add(ModItems.EMBERITE_CHESTPLATE)
                .add(ModItems.EMBERITE_LEGGINGS)
                .add(ModItems.EMBERITE_BOOTS)

                .add(ModItems.AQUALITE_HELMET)
                .add(ModItems.AQUALITE_CHESTPLATE)
                .add(ModItems.AQUALITE_LEGGINGS)
                .add(ModItems.AQUALITE_BOOTS);
    }
}
