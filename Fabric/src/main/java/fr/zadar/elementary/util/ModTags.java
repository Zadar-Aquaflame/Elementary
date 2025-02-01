package fr.zadar.elementary.util;

import fr.zadar.elementary.ElementaryFabric;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {


        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(ElementaryFabric.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> IS_EMBERSTONE_TOOL = createTag("is_emberstone_tool");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier(ElementaryFabric.MOD_ID, name));
        }
    }
}
