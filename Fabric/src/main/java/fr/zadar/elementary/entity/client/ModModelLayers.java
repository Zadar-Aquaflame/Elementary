package fr.zadar.elementary.entity.client;

import fr.zadar.elementary.ElementaryFabric;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
    public static final EntityModelLayer FLAME_SPIRIT =
            new EntityModelLayer(new Identifier(ElementaryFabric.MOD_ID, "flame_spirit"), "main");
}
