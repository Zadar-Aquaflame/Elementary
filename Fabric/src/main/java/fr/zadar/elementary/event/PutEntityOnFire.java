package fr.zadar.elementary.event;

import fr.zadar.elementary.item.ModItems;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;

import java.util.Arrays;

public class PutEntityOnFire {
    public PutEntityOnFire() {
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
}
