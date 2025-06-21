package fr.zadar.elementary.event;

import fr.zadar.elementary.item.ModItems;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;

public class AddTrades {
    public static void addWanderingTrades() {
        TradeOfferHelper.registerWanderingTraderOffers(1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 5),
                            new ItemStack(ModItems.SPARK_EMERALD, 1),
                            3, 2, 0.2f
                    ));
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 5),
                            new ItemStack(ModItems.POND_EMERALD, 1),
                            3, 2, 0.2f
                    ));
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 5),
                            new ItemStack(ModItems.SQUALL_EMERALD, 1),
                            3, 2, 0.2f
                    ));
                });
    }
}
