package fr.zadar.elementary.event;

import fr.zadar.elementary.item.ModArmorMaterials;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;

public class ArmorEffectEvent {
    public static void onTick() {
        ServerTickEvents.END_WORLD_TICK.register((world) -> {
            for (PlayerEntity player : world.getPlayers()) {
                if (hasFullArmorOn(player)) {
                    addEffects(player);
                }
            }
        });
    }

    private static void addEffects(PlayerEntity player) {
        if (hasCorrectArmorOn(ModArmorMaterials.EMBERSTONE, player)) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 20, 1, false, false, true));
        }
        if (hasCorrectArmorOn(ModArmorMaterials.HYDROSTONE, player)) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 20, 0, false, false, true));
        }
        if (hasCorrectArmorOn(ModArmorMaterials.EMBERITE, player)) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 60, 2, false, false, true));
        }
        if (hasCorrectArmorOn(ModArmorMaterials.AQUALITE, player)) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 60, 2, false, false, true));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 60, 2, false, false, true));
        }
    }

    private static boolean hasFullArmorOn(PlayerEntity player) {
        ItemStack boots = player.getInventory().getArmorStack(0);
        ItemStack leggings = player.getInventory().getArmorStack(1);
        ItemStack breastplate = player.getInventory().getArmorStack(2);
        ItemStack helmet = player.getInventory().getArmorStack(3);

        return !helmet.isEmpty() && !breastplate.isEmpty() && ! leggings.isEmpty() && !boots.isEmpty();
    }

    private static boolean hasCorrectArmorOn(ArmorMaterial material, PlayerEntity player) {
        for (ItemStack armorStack : player.getArmorItems()) {
            if (!(armorStack.getItem() instanceof ArmorItem)) {
                return false;
            }
        }

        ArmorItem boots = ((ArmorItem) player.getInventory().getArmorStack(0).getItem());
        ArmorItem leggings = ((ArmorItem) player.getInventory().getArmorStack(1).getItem());
        ArmorItem breastplate = ((ArmorItem) player.getInventory().getArmorStack(2).getItem());
        ArmorItem helmet = ((ArmorItem) player.getInventory().getArmorStack(3).getItem());

        return helmet.getMaterial() == material && breastplate.getMaterial() == material &&
                leggings.getMaterial() == material && boots.getMaterial() == material;
    }
}
