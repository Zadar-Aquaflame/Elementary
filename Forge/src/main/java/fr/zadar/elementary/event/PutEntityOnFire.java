package fr.zadar.elementary.event;

import fr.zadar.elementary.ElementaryForge;
import fr.zadar.elementary.item.ModItems;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Arrays;

@Mod.EventBusSubscriber(modid = ElementaryForge.MOD_ID)
public class PutEntityOnFire {
    protected static void igniteTarget(LivingEntity target, int time) {
        if (target != null) {
            target.setSecondsOnFire(time);
        }
    }

    @SubscribeEvent
    public static void onPlayerAttack(AttackEntityEvent event) {
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
}
