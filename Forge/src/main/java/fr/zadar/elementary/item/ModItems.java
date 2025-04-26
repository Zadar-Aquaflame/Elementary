package fr.zadar.elementary.item;

import fr.zadar.elementary.ElementaryForge;
import fr.zadar.elementary.entity.ModEntities;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ElementaryForge.MOD_ID);

    public static final RegistryObject<Item> EMBERSTONE_INGOT = ITEMS.register("emberstone_ingot", () -> new Item(new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> RAW_EMBERSTONE = ITEMS.register("raw_emberstone", () -> new Item(new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> EMBERSTONE_SWORD = ITEMS.register("emberstone_sword",
            () -> new SwordItem(ModToolTiers.EMBERSTONE, 5, -2.4f, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> EMBERSTONE_PICKAXE = ITEMS.register("emberstone_pickaxe",
            () -> new PickaxeItem(ModToolTiers.EMBERSTONE, 0, -2.4f, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> EMBERSTONE_AXE = ITEMS.register("emberstone_axe",
            () -> new AxeItem(ModToolTiers.EMBERSTONE, 7, -2.4f, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> EMBERSTONE_SHOVEL = ITEMS.register("emberstone_shovel",
            () -> new ShovelItem(ModToolTiers.EMBERSTONE, 0.5f, -2.4f, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> EMBERSTONE_HOE = ITEMS.register("emberstone_hoe",
            () -> new HoeItem(ModToolTiers.EMBERSTONE, -4, -2.4f, new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> EMBERSTONE_HELMET = ITEMS.register("emberstone_helmet",
            () -> new ArmorItem(ModArmorMaterial.EMBERSTONE, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> EMBERSTONE_CHESTPLATE = ITEMS.register("emberstone_chestplate",
            () -> new ArmorItem(ModArmorMaterial.EMBERSTONE, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> EMBERSTONE_LEGGINGS = ITEMS.register("emberstone_leggings",
            () -> new ArmorItem(ModArmorMaterial.EMBERSTONE, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> EMBERSTONE_BOOTS = ITEMS.register("emberstone_boots",
            () -> new ArmorItem(ModArmorMaterial.EMBERSTONE, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> HYDROSTONE_INGOT = ITEMS.register("hydrostone_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_HYDROSTONE = ITEMS.register("raw_hydrostone", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HYDROSTONE_SWORD = ITEMS.register("hydrostone_sword",
            () -> new SwordItem(ModToolTiers.HYDROSTONE, 6, -2.4f, new Item.Properties()));
    public static final RegistryObject<Item> HYDROSTONE_PICKAXE = ITEMS.register("hydrostone_pickaxe",
            () -> new PickaxeItem(ModToolTiers.HYDROSTONE, 6, -2.4f, new Item.Properties()));
    public static final RegistryObject<Item> HYDROSTONE_AXE = ITEMS.register("hydrostone_axe",
            () -> new AxeItem(ModToolTiers.HYDROSTONE, 6, -2.4f, new Item.Properties()));
    public static final RegistryObject<Item> HYDROSTONE_SHOVEL = ITEMS.register("hydrostone_shovel",
            () -> new ShovelItem(ModToolTiers.HYDROSTONE, 6, -2.4f, new Item.Properties()));
    public static final RegistryObject<Item> HYDROSTONE_HOE = ITEMS.register("hydrostone_hoe",
            () -> new HoeItem(ModToolTiers.HYDROSTONE, 6, -2.4f, new Item.Properties()));

    public static final RegistryObject<Item> HYDROSTONE_HELMET = ITEMS.register("hydrostone_helmet",
            () -> new ArmorItem(ModArmorMaterial.HYDROSTONE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> HYDROSTONE_CHESTPLATE = ITEMS.register("hydrostone_chestplate",
            () -> new ArmorItem(ModArmorMaterial.HYDROSTONE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> HYDROSTONE_LEGGINGS = ITEMS.register("hydrostone_leggings",
            () -> new ArmorItem(ModArmorMaterial.HYDROSTONE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> HYDROSTONE_BOOTS = ITEMS.register("hydrostone_boots",
            () -> new ArmorItem(ModArmorMaterial.HYDROSTONE, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> ETHEREAL_HEART = ITEMS.register("ethereal_heart", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FIRE_CRYSTAL = ITEMS.register("fire_crystal", () -> new Item(new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> MYSTIC_ASH = ITEMS.register("mystic_ash", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> HEAT_ESSENCE = ITEMS.register("heat_essence", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WATER_CRYSTAL = ITEMS.register("water_crystal", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TEAR_DROP = ITEMS.register("tear_drop", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WAVE_ESSENCE = ITEMS.register("wave_essence", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> EMBERITE_INGOT = ITEMS.register("emberite_ingot", () -> new Item(new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> FIRE_FERROCRYSTAL_INGOT = ITEMS.register("fire_ferrocrystal_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FIRE_FERROCRYSTAL_STICK = ITEMS.register("fire_ferrocrystal_stick", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> EMBERITE_SWORD = ITEMS.register("emberite_sword",
            () -> new SwordItem(ModToolTiers.EMBERITE, 5, -2.4f, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> EMBERITE_PICKAXE = ITEMS.register("emberite_pickaxe",
            () -> new PickaxeItem(ModToolTiers.EMBERITE, 2, -2.4f, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> EMBERITE_AXE = ITEMS.register("emberite_axe",
            () -> new AxeItem(ModToolTiers.EMBERITE, 7, -2.4f, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> EMBERITE_SHOVEL = ITEMS.register("emberite_shovel",
            () -> new ShovelItem(ModToolTiers.EMBERITE, 2.5f, -2.4f, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> EMBERITE_HOE = ITEMS.register("emberite_hoe",
            () -> new HoeItem(ModToolTiers.EMBERITE, -6, -2.4f, new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> EMBERITE_HELMET = ITEMS.register("emberite_helmet",
            () -> new ArmorItem(ModArmorMaterial.EMBERITE, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> EMBERITE_CHESTPLATE = ITEMS.register("emberite_chestplate",
            () -> new ArmorItem(ModArmorMaterial.EMBERITE, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> EMBERITE_LEGGINGS = ITEMS.register("emberite_leggings",
            () -> new ArmorItem(ModArmorMaterial.EMBERITE, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> EMBERITE_BOOTS = ITEMS.register("emberite_boots",
            () -> new ArmorItem(ModArmorMaterial.EMBERITE, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> AQUALITE_INGOT = ITEMS.register("aqualite_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WATER_FERROCRYSTAL_INGOT = ITEMS.register("water_ferrocrystal_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WATER_FERROCRYSTAL_STICK = ITEMS.register("water_ferrocrystal_stick", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> AQUALITE_SWORD = ITEMS.register("aqualite_sword",
            () -> new SwordItem(ModToolTiers.AQUALITE, 5, -2.4f, new Item.Properties()));
    public static final RegistryObject<Item> AQUALITE_PICKAXE = ITEMS.register("aqualite_pickaxe",
            () -> new PickaxeItem(ModToolTiers.AQUALITE, 2, -2.4f, new Item.Properties()));
    public static final RegistryObject<Item> AQUALITE_AXE = ITEMS.register("aqualite_axe",
            () -> new AxeItem(ModToolTiers.AQUALITE, 7, -2.4f, new Item.Properties()));
    public static final RegistryObject<Item> AQUALITE_SHOVEL = ITEMS.register("aqualite_shovel",
            () -> new ShovelItem(ModToolTiers.AQUALITE, 2.5f, -2.4f, new Item.Properties()));
    public static final RegistryObject<Item> AQUALITE_HOE = ITEMS.register("aqualite_hoe",
            () -> new HoeItem(ModToolTiers.AQUALITE, -6, -2.4f, new Item.Properties()));

    public static final RegistryObject<Item> AQUALITE_HELMET = ITEMS.register("aqualite_helmet",
            () -> new ArmorItem(ModArmorMaterial.AQUALITE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> AQUALITE_CHESTPLATE = ITEMS.register("aqualite_chestplate",
            () -> new ArmorItem(ModArmorMaterial.AQUALITE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> AQUALITE_LEGGINGS = ITEMS.register("aqualite_leggings",
            () -> new ArmorItem(ModArmorMaterial.AQUALITE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> AQUALITE_BOOTS = ITEMS.register("aqualite_boots",
            () -> new ArmorItem(ModArmorMaterial.AQUALITE, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> FLAME_SPIRIT_SPAWN_EGG = ITEMS.register("flame_spirit_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.FLAME_SPIRIT, 0x504948, 0xD66D03, new Item.Properties()));
    public static final RegistryObject<Item> GUARDIAN_OF_THE_WAVES_SPAWN_EGG = ITEMS.register("guardian_of_the_waves_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.GUARDIAN_OF_THE_WAVES, 0x0dc1f2, 0x07a75c, new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ElementaryForge.LOGGER.info("Registering Items for " + ElementaryForge.MOD_ID);

        ITEMS.register(eventBus);
    }
}
