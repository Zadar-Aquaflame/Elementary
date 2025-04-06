package fr.zadar.elementary.item;

import fr.zadar.elementary.ElementaryFabric;
import fr.zadar.elementary.entity.ModEntities;
import fr.zadar.elementary.item.custom.ModArmorEffect;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item EMBERSTONE_INGOT = registerItem("emberstone_ingot", new Item(new Item.Settings().fireproof()));
    public static final Item RAW_EMBERSTONE = registerItem("raw_emberstone", new Item(new Item.Settings().fireproof()));

    public static final Item EMBERSTONE_SWORD = registerItem("emberstone_sword",
            new SwordItem(ModToolMaterial.EMBERSTONE, 5, -2.4f, new Item.Settings().fireproof()));
    public static final Item EMBERSTONE_PICKAXE = registerItem("emberstone_pickaxe",
            new PickaxeItem(ModToolMaterial.EMBERSTONE, 0, -2.4f, new Item.Settings().fireproof()));
    public static final Item EMBERSTONE_AXE = registerItem("emberstone_axe",
            new AxeItem(ModToolMaterial.EMBERSTONE, 7, -2.4f, new Item.Settings().fireproof()));
    public static final Item EMBERSTONE_SHOVEL = registerItem("emberstone_shovel",
            new ShovelItem(ModToolMaterial.EMBERSTONE, 0.5f, -2.4f, new Item.Settings().fireproof()));
    public static final Item EMBERSTONE_HOE = registerItem("emberstone_hoe",
            new HoeItem(ModToolMaterial.EMBERSTONE, -4, -2.4f, new Item.Settings().fireproof()));

    public static final Item EMBERSTONE_HELMET = registerItem("emberstone_helmet",
            new ModArmorEffect(ModArmorMaterials.EMBERSTONE, ArmorItem.Type.HELMET, new Item.Settings().fireproof()));
    public static final Item EMBERSTONE_CHESTPLATE = registerItem("emberstone_chestplate",
            new ModArmorEffect(ModArmorMaterials.EMBERSTONE, ArmorItem.Type.CHESTPLATE, new Item.Settings().fireproof()));
    public static final Item EMBERSTONE_LEGGINGS = registerItem("emberstone_leggings",
            new ModArmorEffect(ModArmorMaterials.EMBERSTONE, ArmorItem.Type.LEGGINGS, new Item.Settings().fireproof()));
    public static final Item EMBERSTONE_BOOTS = registerItem("emberstone_boots",
            new ModArmorEffect(ModArmorMaterials.EMBERSTONE, ArmorItem.Type.BOOTS, new Item.Settings().fireproof()));

    public static final Item HYDROSTONE_INGOT = registerItem("hydrostone_ingot", new Item(new Item.Settings()));
    public static final Item RAW_HYDROSTONE = registerItem("raw_hydrostone", new Item(new Item.Settings()));

    public static final Item HYDROSTONE_SWORD = registerItem("hydrostone_sword",
            new SwordItem(ModToolMaterial.HYDROSTONE, 5, -2.4f, new Item.Settings()));
    public static final Item HYDROSTONE_PICKAXE = registerItem("hydrostone_pickaxe",
            new PickaxeItem(ModToolMaterial.HYDROSTONE, 2, -2.4f, new Item.Settings()));
    public static final Item HYDROSTONE_AXE = registerItem("hydrostone_axe",
            new AxeItem(ModToolMaterial.HYDROSTONE, 9, -2.4f, new Item.Settings()));
    public static final Item HYDROSTONE_SHOVEL = registerItem("hydrostone_shovel",
            new ShovelItem(ModToolMaterial.HYDROSTONE, 2.5f, -2.4f, new Item.Settings()));
    public static final Item HYDROSTONE_HOE = registerItem("hydrostone_hoe",
            new HoeItem(ModToolMaterial.HYDROSTONE, -2, -2.4f, new Item.Settings()));

    public static final Item HYDROSTONE_HELMET = registerItem("hydrostone_helmet",
            new ModArmorEffect(ModArmorMaterials.HYDROSTONE, ArmorItem.Type.HELMET, new Item.Settings()));
    public static final Item HYDROSTONE_CHESTPLATE = registerItem("hydrostone_chestplate",
            new ModArmorEffect(ModArmorMaterials.HYDROSTONE, ArmorItem.Type.CHESTPLATE, new Item.Settings()));
    public static final Item HYDROSTONE_LEGGINGS = registerItem("hydrostone_leggings",
            new ModArmorEffect(ModArmorMaterials.HYDROSTONE, ArmorItem.Type.LEGGINGS, new Item.Settings()));
    public static final Item HYDROSTONE_BOOTS = registerItem("hydrostone_boots",
            new ModArmorEffect(ModArmorMaterials.HYDROSTONE, ArmorItem.Type.BOOTS, new Item.Settings()));

    public static final Item FLAME_SPIRIT_SPAWN_EGG = registerItem("flame_spirit_spawn_egg",
            new SpawnEggItem(ModEntities.FLAME_SPIRIT, 0x504948, 0xD66D03, new Item.Settings()));

    public static final Item FIRE_CRYSTAL = registerItem("fire_crystal", new Item(new Item.Settings().fireproof()));
    public static final Item MYSTIC_ASH = registerItem("mystic_ash", new Item(new Item.Settings()));
    public static final Item HEAT_ESSENCE = registerItem("heat_essence", new Item(new Item.Settings()));
    public static final Item ETHEREAL_HEART = registerItem("ethereal_heart", new Item(new Item.Settings()));

    private static Item registerItem(String id, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(ElementaryFabric.MOD_ID, id), item);
    }

    public static void registerModItems() {
        ElementaryFabric.LOGGER.info("Registering Items for " + ElementaryFabric.MOD_ID);
    }
}
