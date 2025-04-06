package fr.zadar.elementary;

import fr.zadar.elementary.data.*;
import fr.zadar.elementary.data.loot.BlockLoot;
import fr.zadar.elementary.data.loot.EntityLoot;
import fr.zadar.elementary.world.ConfiguredFeatures;
import fr.zadar.elementary.world.PlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class ElementaryFabricDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(BlockTag::new);
        pack.addProvider(ItemTag::new);
        pack.addProvider(BlockLoot::new);
        pack.addProvider(EntityLoot::new);
        pack.addProvider(ModelProvider::new);
        pack.addProvider(Recipes::new);
        pack.addProvider(WorldGenProvider::new);
    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ConfiguredFeatures::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, PlacedFeatures::bootstrap);
    }
}
