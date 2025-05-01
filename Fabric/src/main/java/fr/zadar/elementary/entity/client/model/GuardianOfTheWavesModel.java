package fr.zadar.elementary.entity.client.model;

import fr.zadar.elementary.entity.animation.FlameSpiritAnimations;
import fr.zadar.elementary.entity.animation.GuardianOfTheWavesAnimations;
import fr.zadar.elementary.entity.custom.GuardianOfTheWavesEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class GuardianOfTheWavesModel<T extends GuardianOfTheWavesEntity> extends SinglePartEntityModel<T> {
	private final ModelPart guardian_of_the_waves;
	private final ModelPart head;

	public GuardianOfTheWavesModel(ModelPart root) {
		this.guardian_of_the_waves = root.getChild("guardian_of_the_waves");
		this.head = guardian_of_the_waves.getChild("head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData guardian_of_the_waves = modelPartData.addChild("guardian_of_the_waves", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData head = guardian_of_the_waves.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -24.0F, 0.0F));

		ModelPartData body = guardian_of_the_waves.addChild("body", ModelPartBuilder.create().uv(16, 16).cuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -24.0F, 0.0F));

		ModelPartData right_arm = guardian_of_the_waves.addChild("right_arm", ModelPartBuilder.create().uv(40, 16).cuboid(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-5.0F, -22.0F, 0.0F));

		ModelPartData left_arm = guardian_of_the_waves.addChild("left_arm", ModelPartBuilder.create().uv(32, 48).cuboid(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(5.0F, -22.0F, 0.0F));

		ModelPartData right_leg = guardian_of_the_waves.addChild("right_leg", ModelPartBuilder.create().uv(0, 16).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.9F, -12.0F, 0.0F));

		ModelPartData left_leg = guardian_of_the_waves.addChild("left_leg", ModelPartBuilder.create().uv(16, 48).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(1.9F, -12.0F, 0.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}

	@Override
	public void setAngles(GuardianOfTheWavesEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw, headPitch);

		this.animateMovement(GuardianOfTheWavesAnimations.WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, GuardianOfTheWavesAnimations.IDLE, ageInTicks, 1f);
	}

	private void setHeadAngles(float headYaw, float headPitch) {
		headYaw = MathHelper.clamp(headYaw, -30.0f, 30.0f);
		headPitch = MathHelper.clamp(headPitch, -25.0f, 45.0f);

		this.head.yaw = headYaw * 0.017453292f;
		this.head.pitch = headPitch * 0.017453292f;
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		guardian_of_the_waves.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return guardian_of_the_waves;
	}
}