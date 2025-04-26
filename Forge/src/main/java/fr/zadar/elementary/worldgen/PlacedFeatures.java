package fr.zadar.elementary.worldgen;

import fr.zadar.elementary.ElementaryForge;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class PlacedFeatures {
    public static final ResourceKey<PlacedFeature> EMBERSTONE_ORE_PLACED_KEY = registerKey("emberstone_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_EMBERSTONE_ORE_PLACED_KEY = registerKey("nether_emberstone_ore_placed");
    public static final ResourceKey<PlacedFeature> HYDROSTONE_ORE_PLACED_KEY = registerKey("hydrostone_ore_placed");
    public static final ResourceKey<PlacedFeature> FIRE_CRYSTAL_ORE_PLACED_KEY = registerKey("fire_crystal_ore_placed");
    public static final ResourceKey<PlacedFeature> WATER_CRYSTAL_ORE_PLACED_KEY = registerKey("water_crystal_ore_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, EMBERSTONE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ConfiguredFeatures.OVERWORLD_EMBERSTONE_ORE_KEY),
                OrePlacement.commonOrePlacement(7, HeightRangePlacement.uniform(VerticalAnchor.absolute(-35), VerticalAnchor.absolute(30))));
        register(context, NETHER_EMBERSTONE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ConfiguredFeatures.NETHER_EMBERSTONE_ORE_KEY),
                OrePlacement.commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.absolute(30), VerticalAnchor.absolute(90))));
        register(context, HYDROSTONE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ConfiguredFeatures.OVERWORLD_HYDROSTONE_ORE_KEY),
                OrePlacement.commonOrePlacement(5, HeightRangePlacement.uniform(VerticalAnchor.absolute(-10), VerticalAnchor.absolute(20))));
        register(context, FIRE_CRYSTAL_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ConfiguredFeatures.FIRE_CRYSTAL_ORE_KEY),
                OrePlacement.commonOrePlacement(5, HeightRangePlacement.uniform(VerticalAnchor.absolute(-35), VerticalAnchor.absolute(20))));
        register(context, WATER_CRYSTAL_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ConfiguredFeatures.WATER_CRYSTAL_ORE_KEY),
                OrePlacement.commonOrePlacement(5, HeightRangePlacement.uniform(VerticalAnchor.absolute(-35), VerticalAnchor.absolute(20))));
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(ElementaryForge.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
