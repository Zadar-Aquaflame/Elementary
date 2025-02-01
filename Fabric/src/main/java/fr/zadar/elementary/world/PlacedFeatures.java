package fr.zadar.elementary.world;

import fr.zadar.elementary.ElementaryFabric;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

public class PlacedFeatures {
    public static final RegistryKey<PlacedFeature> EMBERSTONE_ORE_PLACED_KEY = registryKey("emberstone_ore_placed");
    public static final RegistryKey<PlacedFeature> NETHER_EMBERSTONE_ORE_PLACED_KEY = registryKey("nether_emberstone_ore_placed");
    public static final RegistryKey<PlacedFeature> HYDROSTONE_ORE_PLACED_KEY = registryKey("hydrostone_ore_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, EMBERSTONE_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ConfiguredFeatures.EMBERSTONE_ORE_KEY),
                OrePlacement.modifiersWithCount(5, HeightRangePlacementModifier.uniform(YOffset.fixed(-35), YOffset.fixed(30))));
        register(context, NETHER_EMBERSTONE_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ConfiguredFeatures.NETHER_EMBERSTONE_ORE_KEY),
                OrePlacement.modifiersWithCount(10, HeightRangePlacementModifier.uniform(YOffset.fixed(30), YOffset.fixed(90))));
        register(context, HYDROSTONE_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ConfiguredFeatures.HYDROSTONE_ORE_KEY),
                OrePlacement.modifiersWithCount(5, HeightRangePlacementModifier.uniform(YOffset.fixed(-10), YOffset.fixed(20))));
    }

    public static RegistryKey<PlacedFeature> registryKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(ElementaryFabric.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> config,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(config, List.copyOf(modifiers)));
    }
}
