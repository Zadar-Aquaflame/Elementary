package fr.zadar.elementary.data;

import fr.zadar.elementary.ElementaryForge;
import fr.zadar.elementary.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.LinkedHashMap;

public class ItemModels extends ItemModelProvider {
    private static final LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }


    public ItemModels(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ElementaryForge.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.EMBERSTONE_INGOT);
        simpleItem(ModItems.RAW_EMBERSTONE);

        handheldItem(ModItems.EMBERSTONE_SWORD);
        handheldItem(ModItems.EMBERSTONE_PICKAXE);
        handheldItem(ModItems.EMBERSTONE_AXE);
        handheldItem(ModItems.EMBERSTONE_SHOVEL);
        handheldItem(ModItems.EMBERSTONE_HOE);

        trimmedArmorItem(ModItems.EMBERSTONE_HELMET);
        trimmedArmorItem(ModItems.EMBERSTONE_CHESTPLATE);
        trimmedArmorItem(ModItems.EMBERSTONE_LEGGINGS);
        trimmedArmorItem(ModItems.EMBERSTONE_BOOTS);

        simpleItem(ModItems.HYDROSTONE_INGOT);
        simpleItem(ModItems.RAW_HYDROSTONE);

        handheldItem(ModItems.HYDROSTONE_SWORD);
        handheldItem(ModItems.HYDROSTONE_PICKAXE);
        handheldItem(ModItems.HYDROSTONE_AXE);
        handheldItem(ModItems.HYDROSTONE_SHOVEL);
        handheldItem(ModItems.HYDROSTONE_HOE);

        trimmedArmorItem(ModItems.HYDROSTONE_HELMET);
        trimmedArmorItem(ModItems.HYDROSTONE_CHESTPLATE);
        trimmedArmorItem(ModItems.HYDROSTONE_LEGGINGS);
        trimmedArmorItem(ModItems.HYDROSTONE_BOOTS);

        simpleItem(ModItems.AERITHIUM_INGOT);
        simpleItem(ModItems.RAW_AERITHIUM);

        handheldItem(ModItems.AERITHIUM_SWORD);
        handheldItem(ModItems.AERITHIUM_PICKAXE);
        handheldItem(ModItems.AERITHIUM_AXE);
        handheldItem(ModItems.AERITHIUM_SHOVEL);
        handheldItem(ModItems.AERITHIUM_HOE);

        trimmedArmorItem(ModItems.AERITHIUM_HELMET);
        trimmedArmorItem(ModItems.AERITHIUM_CHESTPLATE);
        trimmedArmorItem(ModItems.AERITHIUM_LEGGINGS);
        trimmedArmorItem(ModItems.AERITHIUM_BOOTS);

        simpleItem(ModItems.ETHEREAL_HEART);
        simpleItem(ModItems.FIRE_CRYSTAL);
        simpleItem(ModItems.MYSTIC_ASH);
        simpleItem(ModItems.HEAT_ESSENCE);
        simpleItem(ModItems.TEAR_DROP);
        simpleItem(ModItems.WATER_CRYSTAL);
        simpleItem(ModItems.WAVE_ESSENCE);
        simpleItem(ModItems.AIR_CRYSTAL);
        simpleItem(ModItems.HURRICANE_FRAGMENT);
        simpleItem(ModItems.STORM_ESSENCE);

        simpleItem(ModItems.SPARK_EMERALD);
        simpleItem(ModItems.POND_EMERALD);
        simpleItem(ModItems.SQUALL_EMERALD);

        simpleItem(ModItems.EMBERITE_INGOT);
        simpleItem(ModItems.FIRE_FERROCRYSTAL_INGOT);
        simpleItem(ModItems.FIRE_FERROCRYSTAL_STICK);

        handheldItem(ModItems.EMBERITE_SWORD);
        handheldItem(ModItems.EMBERITE_PICKAXE);
        handheldItem(ModItems.EMBERITE_AXE);
        handheldItem(ModItems.EMBERITE_SHOVEL);
        handheldItem(ModItems.EMBERITE_HOE);

        trimmedArmorItem(ModItems.EMBERITE_HELMET);
        trimmedArmorItem(ModItems.EMBERITE_CHESTPLATE);
        trimmedArmorItem(ModItems.EMBERITE_LEGGINGS);
        trimmedArmorItem(ModItems.EMBERITE_BOOTS);

        simpleItem(ModItems.AQUALITE_INGOT);
        simpleItem(ModItems.WATER_FERROCRYSTAL_INGOT);
        simpleItem(ModItems.WATER_FERROCRYSTAL_STICK);

        handheldItem(ModItems.AQUALITE_SWORD);
        handheldItem(ModItems.AQUALITE_PICKAXE);
        handheldItem(ModItems.AQUALITE_AXE);
        handheldItem(ModItems.AQUALITE_SHOVEL);
        handheldItem(ModItems.AQUALITE_HOE);

        trimmedArmorItem(ModItems.AQUALITE_HELMET);
        trimmedArmorItem(ModItems.AQUALITE_CHESTPLATE);
        trimmedArmorItem(ModItems.AQUALITE_LEGGINGS);
        trimmedArmorItem(ModItems.AQUALITE_BOOTS);

        simpleItem(ModItems.AERILITE_INGOT);
        simpleItem(ModItems.AIR_FERROCRYSTAL_INGOT);
        simpleItem(ModItems.AIR_FERROCRYSTAL_STICK);

        handheldItem(ModItems.AERILITE_SWORD);
        handheldItem(ModItems.AERILITE_PICKAXE);
        handheldItem(ModItems.AERILITE_AXE);
        handheldItem(ModItems.AERILITE_SHOVEL);
        handheldItem(ModItems.AERILITE_HOE);

        trimmedArmorItem(ModItems.AERILITE_HELMET);
        trimmedArmorItem(ModItems.AERILITE_CHESTPLATE);
        trimmedArmorItem(ModItems.AERILITE_LEGGINGS);
        trimmedArmorItem(ModItems.AERILITE_BOOTS);

        withExistingParent(ModItems.FLAME_SPIRIT_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.GUARDIAN_OF_THE_WAVES_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.AERORUPTURA_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
    }

    private void trimmedArmorItem(RegistryObject<Item> itemRegistryObject) {
        final String MOD_ID = ElementaryForge.MOD_ID;

        if (itemRegistryObject.get() instanceof ArmorItem armorItem) {
            trimMaterials.entrySet().forEach(entry -> {

                ResourceKey<TrimMaterial> trimMaterial = entry.getKey();
                float trimValue = entry.getValue();

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = "item/" + armorItem;
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = new ResourceLocation(MOD_ID, armorItemPath);
                ResourceLocation trimResLoc = new ResourceLocation(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = new ResourceLocation(MOD_ID, currentTrimName);

                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc)
                        .texture("layer1", trimResLoc);

                this.withExistingParent(itemRegistryObject.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0", new ResourceLocation(MOD_ID, "item/" + itemRegistryObject.getId().getPath()));
            });
        }
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ElementaryForge.MOD_ID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(ElementaryForge.MOD_ID, "item/" + item.getId().getPath()));
    }

}
