package fr.zadar.elementary.event;

import fr.zadar.elementary.ElementaryForge;
import fr.zadar.elementary.block.ModBlocks;
import fr.zadar.elementary.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Mod.EventBusSubscriber(modid = ElementaryForge.MOD_ID)
public class ToolEvents {
    public static BlockPos[] farmlandBlockList;
    public static int rainDuration = 0;
    public static boolean isRaining = false;

    private static final Map<Block, ItemStack> ORE_TO_SMELTED = new HashMap<>();

    public static void initialize() {
        ORE_TO_SMELTED.put(Blocks.COPPER_ORE, new ItemStack(Items.COPPER_INGOT));
        ORE_TO_SMELTED.put(Blocks.DEEPSLATE_COPPER_ORE, new ItemStack(Items.COPPER_INGOT));
        ORE_TO_SMELTED.put(Blocks.IRON_ORE, new ItemStack(Items.IRON_INGOT));
        ORE_TO_SMELTED.put(Blocks.DEEPSLATE_IRON_ORE, new ItemStack(Items.IRON_INGOT));
        ORE_TO_SMELTED.put(Blocks.GOLD_ORE, new ItemStack(Items.GOLD_INGOT));
        ORE_TO_SMELTED.put(Blocks.DEEPSLATE_GOLD_ORE, new ItemStack(Items.GOLD_INGOT));
        ORE_TO_SMELTED.put(ModBlocks.EMBERSTONE_ORE.get(), new ItemStack(ModItems.EMBERSTONE_INGOT.get()));
        ORE_TO_SMELTED.put(ModBlocks.DEEPSLATE_EMBERSTONE_ORE.get(), new ItemStack(ModItems.EMBERSTONE_INGOT.get()));
        ORE_TO_SMELTED.put(ModBlocks.HYDROSTONE_ORE.get(), new ItemStack(ModItems.HYDROSTONE_INGOT.get()));
        ORE_TO_SMELTED.put(ModBlocks.DEEPSLATE_HYDROSTONE_ORE.get(), new ItemStack(ModItems.HYDROSTONE_INGOT.get()));
        ORE_TO_SMELTED.put(ModBlocks.AERITHIUM_ORE.get(), new ItemStack(ModItems.AERITHIUM_INGOT.get()));
        ORE_TO_SMELTED.put(ModBlocks.DEEPSLATE_AERITHIUM_ORE.get(), new ItemStack(ModItems.AERITHIUM_INGOT.get()));
    }

    @SubscribeEvent
    public static void fireToolsEvents(AttackEntityEvent event) {
        if (event.getTarget() instanceof LivingEntity target) {
            if (event.getEntity() != null) {
                Player attacker = event.getEntity();
                ItemStack heldItem = attacker.getMainHandItem();

                if (!heldItem.isEmpty()) {
                    if (isEmberstoneTool(heldItem.getItem())) {
                        igniteTarget(target, 3);
                    }

                    if (isEmberiteTool(heldItem.getItem())) {
                        igniteTarget(target, 5);
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public static void smeltBlockEvent(BlockEvent.BreakEvent event) {
        Level level = event.getPlayer().level();
        Player player = event.getPlayer();

        ItemStack heldItem = player.getMainHandItem();
        if (heldItem.getItem() == ModItems.EMBERITE_PICKAXE.get()) {
            BlockState blockState = event.getState();
            Block blockMined = blockState.getBlock();

            if (ORE_TO_SMELTED.containsKey(blockMined)) {
                ItemStack smeltedResult = ORE_TO_SMELTED.get(blockMined).copy();

                event.setCanceled(true);
                blockState.getBlock().popExperience((ServerLevel) event.getLevel(), event.getPos(), (int) 1.0f);
                event.getLevel().destroyBlock(event.getPos(), false);

                Block.popResource(level, event.getPos(), smeltedResult);
            }
        }
    }

    @SubscribeEvent
    public static void wetFarmlandEvent(PlayerInteractEvent.RightClickBlock event) {
        Item item = event.getItemStack().getItem();

        if (item == ModItems.AQUALITE_HOE.get()) {
            BlockPos blockPos = event.getPos();

            farmlandBlockList = addFarmlandBlock(farmlandBlockList, blockPos);
        }
    }

    @SubscribeEvent
    public static void onTick(TickEvent.LevelTickEvent event) {
        Level level = event.level;
        if (farmlandBlockList != null) {
            for (int i = 0; i < farmlandBlockList.length; i++) {
                Block farmlandBlock = Blocks.FARMLAND;
                farmlandBlock.getStateDefinition().any().setValue(BlockStateProperties.MOISTURE, 7);
                level.setBlock(farmlandBlockList[i], farmlandBlock.defaultBlockState().setValue(BlockStateProperties.MOISTURE, 7), 2);
            }
        }

        if (event.phase == TickEvent.Phase.END) {
            if (rainDuration > 0) {
                rainDuration--;
                level.setRainLevel(1.0f);
                level.setThunderLevel(0.0f);
                if (rainDuration <= 0) {
                    event.level.setRainLevel(0.0f);
                }
            }
        }
    }

    @SubscribeEvent
    public static void createRain(PlayerInteractEvent.RightClickItem event) {
        Level level = event.getLevel();
        ItemStack heldItem = event.getEntity().getMainHandItem();

        if (heldItem.getItem() == ModItems.AQUALITE_SWORD.get()) {
            if (!level.isClientSide()) {
                rainDuration = 1200;
                isRaining = true;
            }
            event.setCancellationResult(InteractionResult.SUCCESS);
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void windJumpBoost(PlayerInteractEvent.RightClickItem event) {
        Player player = event.getEntity();
        ItemStack heldItem = player.getMainHandItem();
        if (!heldItem.isEmpty()) {
            if (isAeriliteTool(heldItem.getItem())) {
                player.addEffect(new MobEffectInstance(MobEffects.JUMP, 100, 3, false, false, true));
            }
        }
    }

    protected static void igniteTarget(LivingEntity target, int time) {
        if (target != null) {
            target.setSecondsOnFire(time);
        }
    }

    private static boolean isEmberstoneTool(Item item) {
        return Arrays.asList(
                ModItems.EMBERSTONE_SWORD.get(),
                ModItems.EMBERSTONE_PICKAXE.get(),
                ModItems.EMBERSTONE_AXE.get(),
                ModItems.EMBERSTONE_SHOVEL.get(),
                ModItems.EMBERSTONE_HOE.get()
        ).contains(item);
    }

    private static boolean isEmberiteTool(Item item) {
        return Arrays.asList(
                ModItems.EMBERITE_SWORD.get(),
                ModItems.EMBERITE_PICKAXE.get(),
                ModItems.EMBERITE_AXE.get(),
                ModItems.EMBERITE_SHOVEL.get(),
                ModItems.EMBERITE_HOE.get()
        ).contains(item);
    }

    private static boolean isAeriliteTool(Item item) {
        return Arrays.asList(
                ModItems.AERILITE_SWORD.get(),
                ModItems.AERILITE_PICKAXE.get(),
                ModItems.AERILITE_AXE.get(),
                ModItems.AERILITE_SHOVEL.get(),
                ModItems.AERILITE_HOE.get()
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
