package fr.zadar.elementary.sound;

import fr.zadar.elementary.ElementaryFabric;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent AERORUPTURA_AMBIENT = registerSoundEvent("aeroruptura_ambient");
    public static final SoundEvent AERORUPTURA_HURT = registerSoundEvent("aeroruptura_hurt");
    public static final SoundEvent AERORUPTURA_DEATH = registerSoundEvent("aeroruptura_death");


    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(ElementaryFabric.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        ElementaryFabric.LOGGER.info("Registering Sounds for " + ElementaryFabric.MOD_ID);
    }
}
