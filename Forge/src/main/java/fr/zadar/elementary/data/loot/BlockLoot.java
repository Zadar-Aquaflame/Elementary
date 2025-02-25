package fr.zadar.elementary.data.loot;

import fr.zadar.elementary.block.ModBlocks;
import fr.zadar.elementary.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class BlockLoot extends BlockLootSubProvider {
    public BlockLoot() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.EMBERSTONE_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_EMBERSTONE_BLOCK.get());

        this.add(ModBlocks.EMBERSTONE_ORE.get(),
                block -> oreDrops(ModBlocks.EMBERSTONE_ORE.get(), ModItems.RAW_EMBERSTONE.get()));
        this.add(ModBlocks.DEEPSLATE_EMBERSTONE_ORE.get(),
                block -> oreDrops(ModBlocks.DEEPSLATE_EMBERSTONE_ORE.get(), ModItems.RAW_EMBERSTONE.get()));
        this.add(ModBlocks.NETHER_EMBERSTONE_ORE.get(),
                block -> oreDrops(ModBlocks.NETHER_EMBERSTONE_ORE.get(), ModItems.RAW_EMBERSTONE.get()));

        this.dropSelf(ModBlocks.HYDROSTONE_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_HYDROSTONE_BLOCK.get());

        this.add(ModBlocks.HYDROSTONE_ORE.get(),
                block -> oreDrops(ModBlocks.HYDROSTONE_ORE.get(), ModItems.RAW_HYDROSTONE.get()));
        this.add(ModBlocks.DEEPSLATE_HYDROSTONE_ORE.get(),
                block -> oreDrops(ModBlocks.DEEPSLATE_HYDROSTONE_ORE.get(), ModItems.RAW_HYDROSTONE.get()));

        this.dropSelf(ModBlocks.ELEMENTS_IMPROVEMENT.get());
    }

    protected LootTable.Builder oreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 1.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
