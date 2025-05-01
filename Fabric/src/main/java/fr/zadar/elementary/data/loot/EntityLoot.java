package fr.zadar.elementary.data.loot;

import fr.zadar.elementary.entity.ModEntities;
import fr.zadar.elementary.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.RandomChanceWithLootingLootCondition;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.LootingEnchantLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

import java.util.function.BiConsumer;

public class EntityLoot extends SimpleFabricLootTableProvider {
    public EntityLoot(FabricDataOutput output) {
        super(output, LootContextTypes.ENTITY);
    }

    @Override
    public void accept(BiConsumer<Identifier, LootTable.Builder> exporter) {
        exporter.accept(ModEntities.FLAME_SPIRIT.getLootTableId(), LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1))
                .with(ItemEntry.builder(ModItems.MYSTIC_ASH)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 2)))
                        .apply(LootingEnchantLootFunction.builder(UniformLootNumberProvider.create(0, 1))))
                .with(ItemEntry.builder(ModItems.FIRE_CRYSTAL)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 1)))
                        .conditionally(RandomChanceWithLootingLootCondition.builder(0.2f, 0.2f)))));
        exporter.accept(ModEntities.GUARDIAN_OF_THE_WAVES.getLootTableId(), LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1))
                .with(ItemEntry.builder(ModItems.TEAR_DROP)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0, 1)))
                        .apply(LootingEnchantLootFunction.builder(UniformLootNumberProvider.create(0, 1))))));
    }
}
