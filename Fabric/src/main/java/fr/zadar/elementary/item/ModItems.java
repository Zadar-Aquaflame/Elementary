package fr.zadar.elementary.item;

import fr.zadar.elementary.ElementaryFabric;
import fr.zadar.elementary.item.custom.ModArmorEffect;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item EMBERSTONE_INGOT = registerItem("emberstone_ingot", new Item(new FabricItemSettings().fireproof()));
    public static final Item RAW_EMBERSTONE = registerItem("raw_emberstone", new Item(new FabricItemSettings().fireproof()));

    public static final Item EMBERSTONE_SWORD = registerItem("emberstone_sword",
            new SwordItem(ModToolMaterial.EMBERSTONE, 5, -2.4f, new FabricItemSettings().fireproof()));
    public static final Item EMBERSTONE_PICKAXE = registerItem("emberstone_pickaxe",
            new PickaxeItem(ModToolMaterial.EMBERSTONE, 0, -2.4f, new FabricItemSettings().fireproof()));
    public static final Item EMBERSTONE_AXE = registerItem("emberstone_axe",
            new AxeItem(ModToolMaterial.EMBERSTONE, 7, -2.4f, new FabricItemSettings().fireproof()));
    public static final Item EMBERSTONE_SHOVEL = registerItem("emberstone_shovel",
            new ShovelItem(ModToolMaterial.EMBERSTONE, 0.5f, -2.4f, new FabricItemSettings().fireproof()));
    public static final Item EMBERSTONE_HOE = registerItem("emberstone_hoe",
            new HoeItem(ModToolMaterial.EMBERSTONE, -4, -2.4f, new FabricItemSettings().fireproof()));

    public static final Item EMBERSTONE_HELMET = registerItem("emberstone_helmet",
            new ModArmorEffect(ModArmorMaterials.EMBERSTONE, ArmorItem.Type.HELMET, new FabricItemSettings().fireproof()));
    public static final Item EMBERSTONE_CHESTPLATE = registerItem("emberstone_chestplate",
            new ModArmorEffect(ModArmorMaterials.EMBERSTONE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings().fireproof()));
    public static final Item EMBERSTONE_LEGGINGS = registerItem("emberstone_leggings",
            new ModArmorEffect(ModArmorMaterials.EMBERSTONE, ArmorItem.Type.LEGGINGS, new FabricItemSettings().fireproof()));
    public static final Item EMBERSTONE_BOOTS = registerItem("emberstone_boots",
            new ModArmorEffect(ModArmorMaterials.EMBERSTONE, ArmorItem.Type.BOOTS, new FabricItemSettings().fireproof()));

    public static final Item HYDROSTONE_INGOT = registerItem("hydrostone_ingot", new Item(new FabricItemSettings()));
    public static final Item RAW_HYDROSTONE = registerItem("raw_hydrostone", new Item(new FabricItemSettings()));

    public static final Item HYDROSTONE_SWORD = registerItem("hydrostone_sword",
            new SwordItem(ModToolMaterial.HYDROSTONE, 5, -2.4f, new FabricItemSettings()));
    public static final Item HYDROSTONE_PICKAXE = registerItem("hydrostone_pickaxe",
            new PickaxeItem(ModToolMaterial.HYDROSTONE, 2, -2.4f, new FabricItemSettings()));
    public static final Item HYDROSTONE_AXE = registerItem("hydrostone_axe",
            new AxeItem(ModToolMaterial.HYDROSTONE, 9, -2.4f, new FabricItemSettings()));
    public static final Item HYDROSTONE_SHOVEL = registerItem("hydrostone_shovel",
            new ShovelItem(ModToolMaterial.HYDROSTONE, 2.5f, -2.4f, new FabricItemSettings()));
    public static final Item HYDROSTONE_HOE = registerItem("hydrostone_hoe",
            new HoeItem(ModToolMaterial.HYDROSTONE, -2, -2.4f, new FabricItemSettings()));


    private static void addItemsToIngredientTab(FabricItemGroupEntries entries) {
        entries.add(EMBERSTONE_INGOT);
        entries.add(RAW_EMBERSTONE);
        entries.add(HYDROSTONE_INGOT);
        entries.add(RAW_HYDROSTONE);
    }

    private static void addItemsToCombatTab(FabricItemGroupEntries entries) {
        entries.add(EMBERSTONE_SWORD);
        entries.add(EMBERSTONE_AXE);
        entries.add(EMBERSTONE_HELMET);
        entries.add(EMBERSTONE_CHESTPLATE);
        entries.add(EMBERSTONE_LEGGINGS);
        entries.add(EMBERSTONE_BOOTS);

        entries.add(HYDROSTONE_SWORD);
        entries.add(HYDROSTONE_AXE);
    }

    private static void addItemsToToolTab(FabricItemGroupEntries entries) {
        entries.add(EMBERSTONE_SHOVEL);
        entries.add(EMBERSTONE_PICKAXE);
        entries.add(EMBERSTONE_AXE);
        entries.add(EMBERSTONE_HOE);

        entries.add(HYDROSTONE_SHOVEL);
        entries.add(HYDROSTONE_PICKAXE);
        entries.add(HYDROSTONE_AXE);
        entries.add(HYDROSTONE_HOE);
    }


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(ElementaryFabric.MOD_ID, name), item);
    }

    public static void registerModItems() {
        ElementaryFabric.LOGGER.info("Registering Items for " + ElementaryFabric.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientTab);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::addItemsToCombatTab);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ModItems::addItemsToToolTab);
    }
}
