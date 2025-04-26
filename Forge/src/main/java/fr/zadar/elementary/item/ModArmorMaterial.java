package fr.zadar.elementary.item;

import fr.zadar.elementary.ElementaryForge;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum ModArmorMaterial implements ArmorMaterial {
    EMBERSTONE("emberstone", 26, new int[]{4, 7, 6, 4}, 18,
            SoundEvents.ARMOR_EQUIP_DIAMOND, 1f, 0f, () -> Ingredient.of(ModItems.EMBERSTONE_INGOT.get())),
    HYDROSTONE("hydrostone", 27, new int[]{5, 7, 6, 5}, 19,
            SoundEvents.ARMOR_EQUIP_DIAMOND, 1f, 0.2f, () -> Ingredient.of(ModItems.HYDROSTONE_INGOT.get())),
    EMBERITE("emberite", 28, new int[]{5, 8, 7, 5}, 20,
            SoundEvents.ARMOR_EQUIP_NETHERITE, 1.5f, 0.3f, () -> Ingredient.of(ModItems.EMBERITE_INGOT.get())),
    AQUALITE("aqualite", 28, new int[]{5, 8, 8, 6}, 20,
            SoundEvents.ARMOR_EQUIP_NETHERITE, 1.8f, 0.4f, () -> Ingredient.of(ModItems.AQUALITE_INGOT.get()));



    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantmentValue;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    private static final int[] BASE_DURABILITY = { 11, 16, 16, 13};

    ModArmorMaterial(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantmentValue, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantmentValue = enchantmentValue;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }


    @Override
    public int getDurabilityForType(ArmorItem.Type type) {
        return BASE_DURABILITY[type.ordinal()] * this.durabilityMultiplier;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type type) {
        return this.protectionAmounts[type.ordinal()];
    }

    @Override
    public int getEnchantmentValue() {
        return enchantmentValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return ElementaryForge.MOD_ID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
