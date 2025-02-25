package fr.zadar.elementary.item;

import fr.zadar.elementary.ElementaryForge;
import fr.zadar.elementary.item.custom.ModArmorEffect;
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
            () -> new ModArmorEffect(ModArmorMaterial.EMBERSTONE, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> EMBERSTONE_CHESTPLATE = ITEMS.register("emberstone_chestplate",
            () -> new ModArmorEffect(ModArmorMaterial.EMBERSTONE, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> EMBERSTONE_LEGGINGS = ITEMS.register("emberstone_leggings",
            () -> new ModArmorEffect(ModArmorMaterial.EMBERSTONE, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> EMBERSTONE_BOOTS = ITEMS.register("emberstone_boots",
            () -> new ModArmorEffect(ModArmorMaterial.EMBERSTONE, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));

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
            () -> new ModArmorEffect(ModArmorMaterial.HYDROSTONE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> HYDROSTONE_CHESTPLATE = ITEMS.register("hydrostone_chestplate",
            () -> new ModArmorEffect(ModArmorMaterial.HYDROSTONE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> HYDROSTONE_LEGGINGS = ITEMS.register("hydrostone_leggings",
            () -> new ModArmorEffect(ModArmorMaterial.HYDROSTONE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> HYDROSTONE_BOOTS = ITEMS.register("hydrostone_boots",
            () -> new ModArmorEffect(ModArmorMaterial.HYDROSTONE, ArmorItem.Type.BOOTS, new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ElementaryForge.LOGGER.info("Registering Items for " + ElementaryForge.MOD_ID);

        ITEMS.register(eventBus);
    }
}
