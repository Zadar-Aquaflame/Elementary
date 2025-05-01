package fr.zadar.elementary.item;

import fr.zadar.elementary.ElementaryFabric;
import fr.zadar.elementary.entity.ModEntities;
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
            new ArmorItem(ModArmorMaterials.EMBERSTONE, ArmorItem.Type.HELMET, new Item.Settings().fireproof()));
    public static final Item EMBERSTONE_CHESTPLATE = registerItem("emberstone_chestplate",
            new ArmorItem(ModArmorMaterials.EMBERSTONE, ArmorItem.Type.CHESTPLATE, new Item.Settings().fireproof()));
    public static final Item EMBERSTONE_LEGGINGS = registerItem("emberstone_leggings",
            new ArmorItem(ModArmorMaterials.EMBERSTONE, ArmorItem.Type.LEGGINGS, new Item.Settings().fireproof()));
    public static final Item EMBERSTONE_BOOTS = registerItem("emberstone_boots",
            new ArmorItem(ModArmorMaterials.EMBERSTONE, ArmorItem.Type.BOOTS, new Item.Settings().fireproof()));

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
            new ArmorItem(ModArmorMaterials.HYDROSTONE, ArmorItem.Type.HELMET, new Item.Settings()));
    public static final Item HYDROSTONE_CHESTPLATE = registerItem("hydrostone_chestplate",
            new ArmorItem(ModArmorMaterials.HYDROSTONE, ArmorItem.Type.CHESTPLATE, new Item.Settings()));
    public static final Item HYDROSTONE_LEGGINGS = registerItem("hydrostone_leggings",
            new ArmorItem(ModArmorMaterials.HYDROSTONE, ArmorItem.Type.LEGGINGS, new Item.Settings()));
    public static final Item HYDROSTONE_BOOTS = registerItem("hydrostone_boots",
            new ArmorItem(ModArmorMaterials.HYDROSTONE, ArmorItem.Type.BOOTS, new Item.Settings()));

    public static final Item FIRE_CRYSTAL = registerItem("fire_crystal", new Item(new Item.Settings().fireproof()));
    public static final Item MYSTIC_ASH = registerItem("mystic_ash", new Item(new Item.Settings()));
    public static final Item HEAT_ESSENCE = registerItem("heat_essence", new Item(new Item.Settings()));
    public static final Item WATER_CRYSTAL = registerItem("water_crystal", new Item(new Item.Settings()));
    public static final Item TEAR_DROP = registerItem("tear_drop", new Item(new Item.Settings()));
    public static final Item WAVE_ESSENCE = registerItem("wave_essence", new Item(new Item.Settings()));
    public static final Item ETHEREAL_HEART = registerItem("ethereal_heart", new Item(new Item.Settings()));

    public static final Item EMBERITE_INGOT = registerItem("emberite_ingot", new Item(new Item.Settings().fireproof()));
    public static final Item FIRE_FERROCRYSTAL_INGOT = registerItem("fire_ferrocrystal_ingot", new Item(new Item.Settings()));
    public static final Item FIRE_FERROCRYSTAL_STICK = registerItem("fire_ferrocrystal_stick", new Item(new Item.Settings()));

    public static final Item EMBERITE_SWORD = registerItem("emberite_sword",
            new SwordItem(ModToolMaterial.EMBERITE, 5, -2.4f, new Item.Settings().fireproof()));
    public static final Item EMBERITE_PICKAXE = registerItem("emberite_pickaxe",
            new PickaxeItem(ModToolMaterial.EMBERITE, 2, -2.4f, new Item.Settings().fireproof()));
    public static final Item EMBERITE_AXE = registerItem("emberite_axe",
            new AxeItem(ModToolMaterial.EMBERITE, 7, -2.4f, new Item.Settings().fireproof()));
    public static final Item EMBERITE_SHOVEL = registerItem("emberite_shovel",
            new ShovelItem(ModToolMaterial.EMBERITE, 2.5f, -2.4f, new Item.Settings().fireproof()));
    public static final Item EMBERITE_HOE = registerItem("emberite_hoe",
            new HoeItem(ModToolMaterial.EMBERITE, -6, -2.4f, new Item.Settings().fireproof()));

    public static final Item EMBERITE_HELMET = registerItem("emberite_helmet",
            new ArmorItem(ModArmorMaterials.EMBERITE, ArmorItem.Type.HELMET, new Item.Settings().fireproof()));
    public static final Item EMBERITE_CHESTPLATE = registerItem("emberite_chestplate",
            new ArmorItem(ModArmorMaterials.EMBERITE, ArmorItem.Type.CHESTPLATE, new Item.Settings().fireproof()));
    public static final Item EMBERITE_LEGGINGS = registerItem("emberite_leggings",
            new ArmorItem(ModArmorMaterials.EMBERITE, ArmorItem.Type.LEGGINGS, new Item.Settings().fireproof()));
    public static final Item EMBERITE_BOOTS = registerItem("emberite_boots",
            new ArmorItem(ModArmorMaterials.EMBERITE, ArmorItem.Type.BOOTS, new Item.Settings().fireproof()));

    public static final Item AQUALITE_INGOT = registerItem("aqualite_ingot", new Item(new Item.Settings()));
    public static final Item WATER_FERROCRYSTAL_INGOT = registerItem("water_ferrocrystal_ingot", new Item(new Item.Settings()));
    public static final Item WATER_FERROCRYSTAL_STICK = registerItem("water_ferrocrystal_stick", new Item(new Item.Settings()));

    public static final Item AQUALITE_SWORD = registerItem("aqualite_sword",
            new SwordItem(ModToolMaterial.AQUALITE, 5, -2.4f, new Item.Settings()));
    public static final Item AQUALITE_PICKAXE = registerItem("aqualite_pickaxe",
            new PickaxeItem(ModToolMaterial.AQUALITE, 2, -2.4f, new Item.Settings()));
    public static final Item AQUALITE_AXE = registerItem("aqualite_axe",
            new AxeItem(ModToolMaterial.AQUALITE, 7, -2.4f, new Item.Settings()));
    public static final Item AQUALITE_SHOVEL = registerItem("aqualite_shovel",
            new ShovelItem(ModToolMaterial.AQUALITE, 2.5f, -2.4f, new Item.Settings()));
    public static final Item AQUALITE_HOE = registerItem("aqualite_hoe",
            new HoeItem(ModToolMaterial.AQUALITE, -6, -2.4f, new Item.Settings()));

    public static final Item AQUALITE_HELMET = registerItem("aqualite_helmet",
            new ArmorItem(ModArmorMaterials.AQUALITE, ArmorItem.Type.HELMET, new Item.Settings()));
    public static final Item AQUALITE_CHESTPLATE = registerItem("aqualite_chestplate",
            new ArmorItem(ModArmorMaterials.AQUALITE, ArmorItem.Type.CHESTPLATE, new Item.Settings()));
    public static final Item AQUALITE_LEGGINGS = registerItem("aqualite_leggings",
            new ArmorItem(ModArmorMaterials.AQUALITE, ArmorItem.Type.LEGGINGS, new Item.Settings()));
    public static final Item AQUALITE_BOOTS = registerItem("aqualite_boots",
            new ArmorItem(ModArmorMaterials.AQUALITE, ArmorItem.Type.BOOTS, new Item.Settings()));

    public static final Item FLAME_SPIRIT_SPAWN_EGG = registerItem("flame_spirit_spawn_egg",
            new SpawnEggItem(ModEntities.FLAME_SPIRIT, 0x504948, 0xD66D03, new Item.Settings()));
    public static final Item GUARDIAN_OF_THE_WAVES_SPAWN_EGG = registerItem("guardian_of_the_waves_spawn_egg",
            new SpawnEggItem(ModEntities.GUARDIAN_OF_THE_WAVES, 0x0dc1f2, 0x07a75c, new Item.Settings()));

    private static Item registerItem(String id, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(ElementaryFabric.MOD_ID, id), item);
    }

    public static void registerModItems() {
        ElementaryFabric.LOGGER.info("Registering Items for " + ElementaryFabric.MOD_ID);
    }
}
