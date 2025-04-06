package fr.zadar.elementary.entity.client;

import fr.zadar.elementary.ElementaryFabric;
import fr.zadar.elementary.entity.custom.FlameSpiritEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class FlameSpiritRenderer extends MobEntityRenderer<FlameSpiritEntity, FlameSpiritModel<FlameSpiritEntity>> {
    private static final Identifier TEXTURE = new Identifier(ElementaryFabric.MOD_ID, "textures/entity/flame_spirit.png");

    public FlameSpiritRenderer(EntityRendererFactory.Context context) {
        super(context, new FlameSpiritModel<>(context.getPart(ModModelLayers.FLAME_SPIRIT)), 1f);
    }

    @Override
    public Identifier getTexture(FlameSpiritEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(FlameSpiritEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if (!mobEntity.isBaby()) {
            matrixStack.scale(1f, 1f, 1f);
        }

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
