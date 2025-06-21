package fr.zadar.elementary.entity.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import fr.zadar.elementary.ElementaryForge;
import fr.zadar.elementary.entity.client.ModModelLayers;
import fr.zadar.elementary.entity.client.model.AerorupturaModel;
import fr.zadar.elementary.entity.custom.AerorupturaEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class AerorupturaRenderer extends MobRenderer<AerorupturaEntity, AerorupturaModel<AerorupturaEntity>> {
    public AerorupturaRenderer(EntityRendererProvider.Context context) {
        super(context, new AerorupturaModel<>(context.bakeLayer(ModModelLayers.AERORUPTURA)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(AerorupturaEntity entity) {
        return new ResourceLocation(ElementaryForge.MOD_ID, "textures/entity/aeroruptura.png");
    }

    @Override
    public void render(AerorupturaEntity entity, float entityYaw, float partialTick, PoseStack matrixStack, MultiBufferSource buffer, int packedLight) {
        super.render(entity, entityYaw, partialTick, matrixStack, buffer, packedLight);
    }
}
