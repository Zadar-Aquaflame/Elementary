package fr.zadar.elementary.entity.client.renderer;

import fr.zadar.elementary.ElementaryFabric;
import fr.zadar.elementary.entity.client.ModModelLayers;
import fr.zadar.elementary.entity.client.model.AerorupturaModel;
import fr.zadar.elementary.entity.custom.AerorupturaEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class AerorupturaRenderer extends MobEntityRenderer<AerorupturaEntity, AerorupturaModel<AerorupturaEntity>> {
    private static final Identifier TEXTURE = new Identifier(ElementaryFabric.MOD_ID, "textures/entity/guardian_of_the_waves.png");

    public AerorupturaRenderer(EntityRendererFactory.Context context) {
        super(context, new AerorupturaModel<>(context.getPart(ModModelLayers.GUARDIAN_OF_THE_WAVES)), 1f);
    }

    @Override
    public Identifier getTexture(AerorupturaEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(AerorupturaEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
