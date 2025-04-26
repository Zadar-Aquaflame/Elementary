package fr.zadar.elementary.worldgen;

import fr.zadar.elementary.ElementaryForge;
import fr.zadar.elementary.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_EMBERSTONE_ORE_KEY = registerKey("emberstone_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_EMBERSTONE_ORE_KEY = registerKey("nether_emberstone_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_HYDROSTONE_ORE_KEY = registerKey("hydrostone_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FIRE_CRYSTAL_ORE_KEY = registerKey("fire_crystal_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WATER_CRYSTAL_ORE_KEY = registerKey("water_crystal_ore");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceable = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceable = new BlockMatchTest(Blocks.NETHERRACK);

        List<OreConfiguration.TargetBlockState> overworldEmberstoneOres = List.of(OreConfiguration.target(stoneReplaceable,
                ModBlocks.EMBERSTONE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceable, ModBlocks.DEEPSLATE_EMBERSTONE_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> overworldHydrostoneOres = List.of(OreConfiguration.target(stoneReplaceable,
                        ModBlocks.HYDROSTONE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceable, ModBlocks.DEEPSLATE_HYDROSTONE_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> overworldFireCrystalOres = List.of(OreConfiguration.target(stoneReplaceable,
                        ModBlocks.FIRE_CRYSTAL_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceable, ModBlocks.DEEPSLATE_FIRE_CRYSTAL_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> overworldWaterCrystalOres = List.of(OreConfiguration.target(stoneReplaceable,
                        ModBlocks.WATER_CRYSTAL_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceable, ModBlocks.DEEPSLATE_WATER_CRYSTAL_ORE.get().defaultBlockState()));

        register(context, OVERWORLD_EMBERSTONE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldEmberstoneOres, 6));
        register(context, NETHER_EMBERSTONE_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceable,
                ModBlocks.NETHER_EMBERSTONE_ORE.get().defaultBlockState(), 6));
        register(context, OVERWORLD_HYDROSTONE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldHydrostoneOres, 4));
        register(context, FIRE_CRYSTAL_ORE_KEY, Feature.ORE, new OreConfiguration(overworldFireCrystalOres, 4));
        register(context, WATER_CRYSTAL_ORE_KEY, Feature.ORE, new OreConfiguration(overworldWaterCrystalOres, 4));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(ElementaryForge.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
