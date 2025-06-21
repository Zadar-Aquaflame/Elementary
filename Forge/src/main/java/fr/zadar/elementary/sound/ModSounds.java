package fr.zadar.elementary.sound;

import fr.zadar.elementary.ElementaryForge;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENT =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, ElementaryForge.MOD_ID);

    public static final RegistryObject<SoundEvent> AERORUPTURA_AMBIENT = registerSoundEvents("aeroruptura_ambient");
    public static final RegistryObject<SoundEvent> AERORUPTURA_HURT = registerSoundEvents("aeroruptura_hurt");
    public static final RegistryObject<SoundEvent> AERORUPTURA_DEATH = registerSoundEvents("aeroruptura_death");

    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        return SOUND_EVENT.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(ElementaryForge.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENT.register(eventBus);
    }
}
