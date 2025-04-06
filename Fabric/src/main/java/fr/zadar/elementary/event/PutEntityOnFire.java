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
            if (entity != null && damageSource.getAttacker() instanceof LivingEntity) {
                LivingEntity attacker = (LivingEntity) damageSource.getAttacker();
                Item item = attacker.getEquippedStack(EquipmentSlot.MAINHAND).getItem();
                if (isEmberstoneTool(item)) {
                    igniteTarget(entity);
                }
            }
            return true;
        });
    }

    public static void igniteTarget(LivingEntity entity) {
        if (entity != null) {
            entity.setFireTicks(60);
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
}
