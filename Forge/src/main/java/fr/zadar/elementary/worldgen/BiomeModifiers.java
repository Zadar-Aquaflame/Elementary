package fr.zadar.elementary.worldgen;

import fr.zadar.elementary.ElementaryForge;
import fr.zadar.elementary.entity.ModEntities;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

public class BiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_EMBERSTONE_ORE = registerKey("add_emberstone_ore");
    public static final ResourceKey<BiomeModifier> ADD_NETHER_EMBERSTONE_ORE = registerKey("add_nether_emberstone_ore");
    public static final ResourceKey<BiomeModifier> ADD_HYDROSTONE_ORE = registerKey("add_hydrostone_ore");
    public static final ResourceKey<BiomeModifier> ADD_FIRE_CRYSTAL_ORE = registerKey("add_fire_crystal_ore");
    public static final ResourceKey<BiomeModifier> ADD_WATER_CRYSTAL_ORE = registerKey("add_water_crystal_ore");

    public static final ResourceKey<BiomeModifier> SPAWN_FLAME_SPIRIT = registerKey("spawn_flame_spirit");
    public static final ResourceKey<BiomeModifier> SPAWN_GUARDIAN_OF_THE_WAVES = registerKey("spawn_guardian_of_the_waves");

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_EMBERSTONE_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.EMBERSTONE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_NETHER_EMBERSTONE_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.NETHER_EMBERSTONE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_HYDROSTONE_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OCEAN),
                HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.HYDROSTONE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_FIRE_CRYSTAL_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.FIRE_CRYSTAL_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_WATER_CRYSTAL_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OCEAN),
                HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.WATER_CRYSTAL_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(SPAWN_FLAME_SPIRIT, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.FLAME_SPIRIT.get(), 64, 1, 2))));

        context.register(SPAWN_GUARDIAN_OF_THE_WAVES, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_BEACH),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.GUARDIAN_OF_THE_WAVES.get(), 64, 1, 1))));
    }


    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(ElementaryForge.MOD_ID, name));
    }
}
