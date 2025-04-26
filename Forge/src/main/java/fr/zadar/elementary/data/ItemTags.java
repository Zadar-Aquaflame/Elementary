package fr.zadar.elementary.data;

import fr.zadar.elementary.ElementaryForge;
import fr.zadar.elementary.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ItemTags extends ItemTagsProvider {
    public ItemTags(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, ElementaryForge.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        this.tag(net.minecraft.tags.ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.EMBERSTONE_HELMET.get(),
                        ModItems.EMBERSTONE_CHESTPLATE.get(),
                        ModItems.EMBERSTONE_LEGGINGS.get(),
                        ModItems.EMBERSTONE_BOOTS.get(),

                        ModItems.HYDROSTONE_HELMET.get(),
                        ModItems.HYDROSTONE_CHESTPLATE.get(),
                        ModItems.HYDROSTONE_LEGGINGS.get(),
                        ModItems.HYDROSTONE_BOOTS.get(),

                        ModItems.EMBERITE_HELMET.get(),
                        ModItems.EMBERITE_CHESTPLATE.get(),
                        ModItems.EMBERITE_LEGGINGS.get(),
                        ModItems.EMBERITE_BOOTS.get(),

                        ModItems.AQUALITE_HELMET.get(),
                        ModItems.AQUALITE_CHESTPLATE.get(),
                        ModItems.AQUALITE_LEGGINGS.get(),
                        ModItems.AQUALITE_BOOTS.get());
    }
}
