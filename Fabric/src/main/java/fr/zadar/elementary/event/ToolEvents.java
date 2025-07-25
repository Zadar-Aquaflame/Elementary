package fr.zadar.elementary.event;

import fr.zadar.elementary.ElementaryFabric;
import fr.zadar.elementary.block.ModBlocks;
import fr.zadar.elementary.event.custom.CustomBlockEvents;
import fr.zadar.elementary.event.custom.CustomItemEvents;
import fr.zadar.elementary.item.ModItems;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ToolEvents {
    public static BlockPos[] farmlandBlockList;
    public static int rainDuration = 0;
    public static boolean isRaining = false;

    public static final Map<Block, ItemStack> ORE_TO_SMELTED = new HashMap<>();

    public static void initialize() {
        ORE_TO_SMELTED.put(Blocks.COPPER_ORE, new ItemStack(Items.COPPER_INGOT));
        ORE_TO_SMELTED.put(Blocks.DEEPSLATE_COPPER_ORE, new ItemStack(Items.COPPER_INGOT));
        ORE_TO_SMELTED.put(Blocks.IRON_ORE, new ItemStack(Items.IRON_INGOT));
        ORE_TO_SMELTED.put(Blocks.DEEPSLATE_IRON_ORE, new ItemStack(Items.IRON_INGOT));
        ORE_TO_SMELTED.put(Blocks.GOLD_ORE, new ItemStack(Items.GOLD_INGOT));
        ORE_TO_SMELTED.put(Blocks.DEEPSLATE_GOLD_ORE, new ItemStack(Items.GOLD_INGOT));
        ORE_TO_SMELTED.put(ModBlocks.EMBERSTONE_ORE, new ItemStack(ModItems.EMBERSTONE_INGOT));
        ORE_TO_SMELTED.put(ModBlocks.DEEPSLATE_EMBERSTONE_ORE, new ItemStack(ModItems.EMBERSTONE_INGOT));
        ORE_TO_SMELTED.put(ModBlocks.HYDROSTONE_ORE, new ItemStack(ModItems.HYDROSTONE_INGOT));
        ORE_TO_SMELTED.put(ModBlocks.DEEPSLATE_HYDROSTONE_ORE, new ItemStack(ModItems.HYDROSTONE_INGOT));
        ORE_TO_SMELTED.put(ModBlocks.AERITHIUM_ORE, new ItemStack(ModItems.AERITHIUM_INGOT));
        ORE_TO_SMELTED.put(ModBlocks.DEEPSLATE_AERITHIUM_ORE, new ItemStack(ModItems.AERITHIUM_INGOT));
    }

    public static void registerToolEvents() {
        initialize();
        fireToolsEvents();
        smeltBlockEvent();
        wetFarmlandEvent();
        createRain();
        windJumpBoost();
    }

    public static void fireToolsEvents() {
        ServerLivingEntityEvents.ALLOW_DAMAGE.register((entity, damageSource, amount) -> {
            if (entity != null && damageSource.getAttacker() instanceof LivingEntity attacker) {
                Item item = attacker.getEquippedStack(EquipmentSlot.MAINHAND).getItem();
                if (isEmberstoneTool(item)) {
                    igniteTarget(entity, 3);
                }

                if (isEmberiteTool(item)) {
                    igniteTarget(entity, 5);
                }
            }
            return true;
        });
    }

    public static void smeltBlockEvent() {
        CustomBlockEvents.IS_BLOCK_BREAK.register((player, world, pos, state, drop) -> {
            ElementaryFabric.LOGGER.info("event is called");

            ItemStack heldItem = player.getMainHandStack();
            if (heldItem.getItem() == ModItems.EMBERITE_PICKAXE) {
                Block blockMined = state.getBlock();

                ElementaryFabric.LOGGER.info("has an emberite pickaxe in hand");
                if (ORE_TO_SMELTED.containsKey(blockMined)) {
                    ElementaryFabric.LOGGER.info("block break is a good key");

                    ItemStack smeltedResult = ORE_TO_SMELTED.get(blockMined).copy();

                    world.removeBlock(pos, false);
                    drop.setCount(0);

                    int xp = 1;
                    ExperienceOrbEntity xpOrb = new ExperienceOrbEntity(world, pos.getX(), pos.getY(), pos.getZ(), xp);
                    world.spawnEntity(xpOrb);

                    Block.dropStack(world, pos, smeltedResult);

                    return false;
                }
            }
            return true;
        });
    }

    public static void wetFarmlandEvent() {
        CustomBlockEvents.ON_RIGHT_CLICK.register((player, world, pos) -> {
            Item item = player.getMainHandStack().getItem();
            if (item == ModItems.AQUALITE_HOE) {
                farmlandBlockList = addFarmlandBlock(farmlandBlockList, pos);
            }
            return true;
        });

        ServerTickEvents.END_WORLD_TICK.register(serverWorld -> {
            if (farmlandBlockList != null) {
                for (int i = 0; i < farmlandBlockList.length; i++) {
                    Block farmlandBlock = Blocks.FARMLAND;
                    farmlandBlock.getDefaultState().with(Properties.MOISTURE, 7);
                    serverWorld.setBlockState(farmlandBlockList[i], farmlandBlock.getDefaultState().with(Properties.MOISTURE, 7), 2);
                }
            }
        });
    }

    public static void createRain() {
        CustomItemEvents.ON_RIGHT_CLICK.register((player, world) -> {
            ItemStack heldItem = player.getMainHandStack();
            if (heldItem.getItem() == ModItems.AQUALITE_SWORD) {
                if (!world.isClient()) {
                    rainDuration = 1200;
                    isRaining = true;
                }
            }
            return true;
        });
        ServerTickEvents.END_WORLD_TICK.register(serverWorld -> {
            if (rainDuration > 0) {
                rainDuration--;
                serverWorld.setRainGradient(1.0f);
                serverWorld.setThunderGradient(0.0f);
                if (rainDuration <= 0) {
                    serverWorld.setRainGradient(0.0f);
                }
            }
        });
    }

    public static void windJumpBoost() {
        CustomItemEvents.ON_RIGHT_CLICK.register((player, world) -> {
            ItemStack heldItem = player.getMainHandStack();
            if (!heldItem.isEmpty()) {
                if (isAeriliteTool(heldItem.getItem())) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 100, 3, false, false, true));
                }
            }
            return true;
        });
    }

    public static void igniteTarget(LivingEntity entity, int time) {
        if (entity != null) {
            entity.setFireTicks(time * 20);
        }
    }

    private static boolean isEmberstoneTool(Item item) {
        return Arrays.asList(
                ModItems.EMBERSTONE_SWORD,
                ModItems.EMBERSTONE_PICKAXE,
                ModItems.EMBERSTONE_AXE,
                ModItems.EMBERSTONE_SHOVEL,
                ModItems.EMBERSTONE_HOE
        ).contains(item);
    }

    private static boolean isEmberiteTool(Item item) {
        return Arrays.asList(
                ModItems.EMBERITE_SWORD,
                ModItems.EMBERITE_PICKAXE,
                ModItems.EMBERITE_AXE,
                ModItems.EMBERITE_SHOVEL,
                ModItems.EMBERITE_HOE
        ).contains(item);
    }

    private static boolean isAeriliteTool(Item item) {
        return Arrays.asList(
                ModItems.AERILITE_SWORD,
                ModItems.AERILITE_PICKAXE,
                ModItems.AERILITE_AXE,
                ModItems.AERILITE_SHOVEL,
                ModItems.AERILITE_HOE
        ).contains(item);
    }

    public static BlockPos[] addFarmlandBlock(BlockPos[] blockList, BlockPos blockPos) {
        int size = 1;
        if (blockList != null) {
            size = blockList.length + 1;
        }

        BlockPos[] blockPos1 = new BlockPos[size];

        if (blockList != null) {
            for (int i = 0; i < blockList.length; i++) {
                blockPos1[i] = blockList[i];
            }
        }
        blockPos1[size - 1] = blockPos;

        return blockPos1;
    }
 }
