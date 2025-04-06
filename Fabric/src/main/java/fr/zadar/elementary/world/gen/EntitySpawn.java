package fr.zadar.elementary.world.gen;

import fr.zadar.elementary.entity.ModEntities;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class EntitySpawn {
    public static void spawnEntity() {
        BiomeModifications.addSpawn(BiomeSelectors.foundInOverworld(),
                SpawnGroup.MONSTER, ModEntities.FLAME_SPIRIT, 64, 1, 2);
    }
}
