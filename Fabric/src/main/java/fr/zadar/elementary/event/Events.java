package fr.zadar.elementary.event;

public class Events {
    public static void register() {
        ToolEvents.registerToolEvents();
        new AddCreativeTabs();
        ArmorEffectEvent.onTick();
        AddTrades.addWanderingTrades();
        MobEvents.registerAttributes();

        UpdateChecker.checkForUpdate();
    }
}
