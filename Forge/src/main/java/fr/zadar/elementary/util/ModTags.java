package fr.zadar.elementary.util;

import fr.zadar.elementary.ElementaryForge;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_EMBERSTONE_TOOL = tag("needs_emberstone_tool");
        public static final TagKey<Block> NEEDS_HYDROSTONE_TOOL = tag("needs_hydrostone_tool");
        public static final TagKey<Block> NEEDS_EMBERITE_TOOL = tag("needs_emberite_tool");
        public static final TagKey<Block> NEEDS_AQUALITE_TOOL = tag("needs_aqualite_tool");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(ElementaryForge.MOD_ID, name));
        }
    }

    public static class Items {

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(ElementaryForge.MOD_ID, name));
        }
    }
}
