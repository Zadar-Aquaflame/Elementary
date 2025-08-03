package fr.zadar.elementary.event;

import fr.zadar.elementary.event.network.CheckLangUsed;
import fr.zadar.elementary.event.network.UpdateChecker;

public class Events {
    public static void register() {
        ToolEvents.registerToolEvents();
        new AddCreativeTabs();
        ArmorEffectEvent.onTick();
        AddTrades.addWanderingTrades();
        MobEvents.registerAttributes();

        UpdateChecker.checkForUpdate();
        CheckLangUsed.checkTheLangUsed();
    }
}
