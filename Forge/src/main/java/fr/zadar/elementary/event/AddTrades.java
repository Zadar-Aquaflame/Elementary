package fr.zadar.elementary.event;

import fr.zadar.elementary.ElementaryForge;
import fr.zadar.elementary.item.ModItems;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = ElementaryForge.MOD_ID)
public class AddTrades {
    @SubscribeEvent
    public static void addWanderingTrades(WandererTradesEvent event) {
        List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();

        genericTrades.add((trader, random) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 15),
                new ItemStack(ModItems.SPARK_EMERALD.get(), 1),
                3, 2, 0.2f));
        genericTrades.add((trader, random) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 15),
                new ItemStack(ModItems.POND_EMERALD.get(), 1),
                3, 2, 0.2f));
        genericTrades.add((trader, random) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 15),
                new ItemStack(ModItems.SQUALL_EMERALD.get(), 1),
                3, 2, 0.2f));
    }
}
