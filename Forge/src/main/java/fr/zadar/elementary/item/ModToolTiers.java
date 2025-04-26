package fr.zadar.elementary.item;

import fr.zadar.elementary.ElementaryForge;
import fr.zadar.elementary.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier EMBERSTONE = TierSortingRegistry.registerTier(
            new ForgeTier(4, 850, 3f, 4f, 18,
                    ModTags.Blocks.NEEDS_EMBERSTONE_TOOL, () -> Ingredient.of(ModItems.EMBERSTONE_INGOT.get())),
            new ResourceLocation(ElementaryForge.MOD_ID, "emberstone"),
            List.of(Tiers.DIAMOND),
            List.of());
    public static final Tier HYDROSTONE = TierSortingRegistry.registerTier(
            new ForgeTier(4, 1240, 4f, 6f, 19,
                    ModTags.Blocks.NEEDS_HYDROSTONE_TOOL, () -> Ingredient.of(ModItems.HYDROSTONE_INGOT.get())),
            new ResourceLocation(ElementaryForge.MOD_ID, "hydrostone"),
        List.of(Tiers.DIAMOND),
            List.of());
    public static final Tier EMBERITE = TierSortingRegistry.registerTier(
            new ForgeTier(5, 1450, 5f, 6f, 20,
                    ModTags.Blocks.NEEDS_EMBERITE_TOOL, () -> Ingredient.of(ModItems.EMBERITE_INGOT.get())),
            new ResourceLocation(ElementaryForge.MOD_ID, "emberite"),
            List.of(Tiers.NETHERITE),
            List.of());
    public static final Tier AQUALITE = TierSortingRegistry.registerTier(
            new ForgeTier(5, 1600, 4.5f, 6f, 20,
                    ModTags.Blocks.NEEDS_AQUALITE_TOOL, () -> Ingredient.of(ModItems.AQUALITE_INGOT.get())),
            new ResourceLocation(ElementaryForge.MOD_ID, "aqualite"),
            List.of(Tiers.NETHERITE),
            List.of());
}
