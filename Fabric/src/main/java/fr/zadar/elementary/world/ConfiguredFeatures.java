package fr.zadar.elementary.world;

import fr.zadar.elementary.ElementaryFabric;
import fr.zadar.elementary.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

public class ConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> EMBERSTONE_ORE_KEY = registryKey("emberstone_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_EMBERSTONE_ORE_KEY = registryKey("nether_emberstone_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> HYDROSTONE_ORE_KEY = registryKey("hydrostone_ore");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceable = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceable = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplaceable = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);

        List<OreFeatureConfig.Target> overworldEmberstoneOre =
                List.of(OreFeatureConfig.createTarget(stoneReplaceable, ModBlocks.EMBERSTONE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceable, ModBlocks.DEEPSLATE_EMBERSTONE_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> overworldHydrostoneOre =
                List.of(OreFeatureConfig.createTarget(stoneReplaceable, ModBlocks.HYDROSTONE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceable, ModBlocks.DEEPSLATE_HYDROSTONE_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> netherEmberstoneOre =
                List.of(OreFeatureConfig.createTarget(netherReplaceable, ModBlocks.NETHER_EMBERSTONE_ORE.getDefaultState()));

        register(context, EMBERSTONE_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldEmberstoneOre, 6));
        register(context, NETHER_EMBERSTONE_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherEmberstoneOre, 6));
        register(context, HYDROSTONE_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldHydrostoneOre, 4));
    }


    public static RegistryKey<ConfiguredFeature<?, ?>> registryKey(String name) {
        return  RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(ElementaryFabric.MOD_ID, name));
    }


    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC config) {
        context.register(key, new ConfiguredFeature<>(feature, config));
    }
}
