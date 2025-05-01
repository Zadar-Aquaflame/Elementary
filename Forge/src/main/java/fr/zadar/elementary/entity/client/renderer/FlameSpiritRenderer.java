package fr.zadar.elementary.entity.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import fr.zadar.elementary.ElementaryForge;
import fr.zadar.elementary.entity.client.ModModelLayers;
import fr.zadar.elementary.entity.client.model.FlameSpiritModel;
import fr.zadar.elementary.entity.custom.FlameSpiritEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class FlameSpiritRenderer extends MobRenderer<FlameSpiritEntity, FlameSpiritModel<FlameSpiritEntity>> {
    public FlameSpiritRenderer(EntityRendererProvider.Context context) {
        super(context, new FlameSpiritModel<>(context.bakeLayer(ModModelLayers.FLAME_SPIRIT)), 1f);
    }

    @Override
    public ResourceLocation getTextureLocation(FlameSpiritEntity entity) {
        return new ResourceLocation(ElementaryForge.MOD_ID, "textures/entity/flame_spirit.png");
    }

    @Override
    public void render(FlameSpiritEntity entity, float entityYaw, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int packedLight) {
        super.render(entity, entityYaw, partialTicks, matrixStack, buffer, packedLight);
    }
}
