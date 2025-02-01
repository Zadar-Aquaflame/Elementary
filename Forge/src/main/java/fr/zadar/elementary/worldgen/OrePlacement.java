package fr.zadar.elementary.worldgen;

import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class OrePlacement {
    public static List<PlacementModifier> orePlacement(PlacementModifier modifier, PlacementModifier biome) {
        return List.of(modifier, InSquarePlacement.spread(), biome, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int count, PlacementModifier heightRange) {
        return orePlacement(CountPlacement.of(count), heightRange);
    }

    public static List<PlacementModifier> rareOrePlacement(int chance, PlacementModifier heightRange) {
        return orePlacement(RarityFilter.onAverageOnceEvery(chance), heightRange);
    }
}
