package fr.zadar.elementary.event;

import fr.zadar.elementary.item.ModItems;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Arrays;

@Mod.EventBusSubscriber
public class PutEntityOnFire {
    protected static void igniteTarget(LivingEntity target) {
        if (target != null) {
            target.setSecondsOnFire(3);
        }
    }

    @SubscribeEvent
    public static void onPlayerAttack(AttackEntityEvent event) {
        if (event.getTarget() instanceof LivingEntity target) {
            if (event.getEntity() instanceof Player) {
                Player attacker = (Player) event.getEntity();
                ItemStack heldItem = attacker.getMainHandItem();

                if (!heldItem.isEmpty() && isEmberstoneTool(heldItem.getItem())) {
                    igniteTarget(target);
                }
            }
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
}
