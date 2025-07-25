package fr.zadar.elementary.event.custom;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class CustomItemEvents {
    public static final Event<OnRightClick> ON_RIGHT_CLICK = EventFactory.createArrayBacked(OnRightClick.class, (callbacks) -> ((player, world) -> {
        for (OnRightClick callback : callbacks) {
            if (!callback.onRightClick(player, world)) {
                return false;
            }
        }
        return true;
    }));

    @FunctionalInterface
    public interface OnRightClick {
        boolean onRightClick(PlayerEntity player, World world);
    }
}
