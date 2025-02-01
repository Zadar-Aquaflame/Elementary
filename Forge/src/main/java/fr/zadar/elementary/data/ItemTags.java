package fr.zadar.elementary.data;

import fr.zadar.elementary.ElementaryForge;
import fr.zadar.elementary.item.ModItems;
import fr.zadar.elementary.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ItemTags extends ItemTagsProvider {
    public ItemTags(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, ElementaryForge.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(net.minecraft.tags.ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.EMBERSTONE_HELMET.get(),
                        ModItems.EMBERSTONE_CHESTPLATE.get(),
                        ModItems.EMBERSTONE_LEGGINGS.get(),
                        ModItems.EMBERSTONE_BOOTS.get(),
                        ModItems.HYDROSTONE_HELMET.get(),
                        ModItems.HYDROSTONE_CHESTPLATE.get(),
                        ModItems.HYDROSTONE_LEGGINGS.get(),
                        ModItems.HYDROSTONE_BOOTS.get());

        this.tag(ModTags.Items.IS_EMBERSTONE_TOOL)
                .add(ModItems.EMBERSTONE_SWORD.get(),
                        ModItems.EMBERSTONE_PICKAXE.get(),
                        ModItems.EMBERSTONE_AXE.get(),
                        ModItems.EMBERSTONE_SHOVEL.get(),
                        ModItems.EMBERSTONE_HOE.get());

        this.tag(ModTags.Items.IS_EMBERSTONE_ARMOR)
                .add(ModItems.EMBERSTONE_HELMET.get(),
                        ModItems.EMBERSTONE_CHESTPLATE.get(),
                        ModItems.EMBERSTONE_LEGGINGS.get(),
                        ModItems.EMBERSTONE_BOOTS.get());
    }


}
