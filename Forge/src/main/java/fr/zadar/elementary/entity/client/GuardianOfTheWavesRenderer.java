package fr.zadar.elementary.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import fr.zadar.elementary.ElementaryForge;
import fr.zadar.elementary.entity.custom.GuardianOfTheWavesEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class GuardianOfTheWavesRenderer extends MobRenderer<GuardianOfTheWavesEntity, GuardianOfTheWavesModel<GuardianOfTheWavesEntity>> {
    public GuardianOfTheWavesRenderer(EntityRendererProvider.Context context) {
        super(context, new GuardianOfTheWavesModel<>(context.bakeLayer(ModModelLayers.GUARDIAN_OF_THE_WAVES)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(GuardianOfTheWavesEntity entity) {
        return new ResourceLocation(ElementaryForge.MOD_ID, "textures/entity/guardian_of_the_waves.png");
    }

    @Override
    public void render(GuardianOfTheWavesEntity entity, float entityYaw, float partialTick, PoseStack matrixStack, MultiBufferSource buffer, int packedLight) {
        super.render(entity, entityYaw, partialTick, matrixStack, buffer, packedLight);
    }
}
