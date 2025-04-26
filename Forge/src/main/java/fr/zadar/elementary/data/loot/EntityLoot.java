package fr.zadar.elementary.data.loot;

import fr.zadar.elementary.entity.ModEntities;
import fr.zadar.elementary.item.ModItems;
import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.LootingEnchantFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceWithLootingCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public class EntityLoot extends EntityLootSubProvider {
    public EntityLoot() {
        super(FeatureFlags.REGISTRY.allFlags(), FeatureFlagSet.of());
    }

    @Override
    public void generate() {
        add(ModEntities.FLAME_SPIRIT.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(ModItems.MYSTIC_ASH.get())
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 2)))
                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0, 1))))
                .add(LootItem.lootTableItem(ModItems.FIRE_CRYSTAL.get())
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 1)))
                        .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(0.2f, 0.2f)))));
        add(ModEntities.GUARDIAN_OF_THE_WAVES.get(), LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(ModItems.TEAR_DROP.get())
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0, 1)))
                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0, 1))))));
    }
}
