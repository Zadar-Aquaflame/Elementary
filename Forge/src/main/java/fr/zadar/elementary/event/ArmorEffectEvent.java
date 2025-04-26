package fr.zadar.elementary.event;

import fr.zadar.elementary.item.ModArmorMaterial;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static fr.zadar.elementary.ElementaryForge.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID)
public class ArmorEffectEvent {
    @SubscribeEvent
    public static void onTick(TickEvent.PlayerTickEvent event) {
        Player player = event.player;
        if (hasFullArmorOn(player)) {
            addEffects(player);
        }
    }

    private static void addEffects(Player player) {
        if (hasCorrectArmorOn(ModArmorMaterial.EMBERSTONE, player)) {
            player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 20, 1, false, false, true));
        }
        if (hasCorrectArmorOn(ModArmorMaterial.HYDROSTONE, player)) {
            player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 20, 0, false, false, true));
        }
        if (hasCorrectArmorOn(ModArmorMaterial.EMBERITE, player)) {
            player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 60, 2, false, false, true));
        }
        if (hasCorrectArmorOn(ModArmorMaterial.AQUALITE, player)) {
            player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 2, false, false, true));
            player.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 60, 2, false, false, true));
        }
    }

    private static boolean hasFullArmorOn(Player player) {
        ItemStack boots = player.getInventory().getArmor(0);
        ItemStack leggings = player.getInventory().getArmor(1);
        ItemStack breastplate = player.getInventory().getArmor(2);
        ItemStack helmet = player.getInventory().getArmor(3);

        return !helmet.isEmpty() && !breastplate.isEmpty() && !leggings.isEmpty() && !boots.isEmpty();
    }

    private static boolean hasCorrectArmorOn(ArmorMaterial material, Player player) {
        for (ItemStack armorStack : player.getArmorSlots()) {
            if (!(armorStack.getItem() instanceof ArmorItem)) {
                return false;
            }
        }

        ArmorItem boots = ((ArmorItem) player.getInventory().getArmor(0).getItem());
        ArmorItem leggings = ((ArmorItem) player.getInventory().getArmor(1).getItem());
        ArmorItem breastplate = ((ArmorItem) player.getInventory().getArmor(2).getItem());
        ArmorItem helmet = ((ArmorItem) player.getInventory().getArmor(3).getItem());

        return helmet.getMaterial() == material && breastplate.getMaterial() == material &&
                leggings.getMaterial() == material && boots.getMaterial() == material;
    }
}
