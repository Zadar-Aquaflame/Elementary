package fr.zadar.elementary.event.custom;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CustomBlockEvents {
    public static final Event<IsBlockBreak> IS_BLOCK_BREAK = EventFactory.createArrayBacked(IsBlockBreak.class, (callbacks) -> ((player, world, pos, state, drop) -> {
        for (IsBlockBreak callback : callbacks) {
            if (!callback.isBlockBreak(player, world, pos, state, drop)) {
                return false;
            }
        }
        return true;
    }));
    public static final Event<OnRightClick> ON_RIGHT_CLICK = EventFactory.createArrayBacked(OnRightClick.class, (callbacks) -> ((player, world, pos) -> {
        for (OnRightClick callback : callbacks) {
            if (!callback.onRightClick(player, world, pos)) {
                return false;
            }
        }
        return true;
    }));

    @FunctionalInterface
    public interface IsBlockBreak {
        boolean isBlockBreak(PlayerEntity player, World world, BlockPos pos, BlockState state, ItemStack drop);
    }

    @FunctionalInterface
    public interface OnRightClick {
        boolean onRightClick(PlayerEntity player, World world, BlockPos pos);
    }
}
