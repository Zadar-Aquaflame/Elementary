package fr.zadar.elementary.entity.client;

import fr.zadar.elementary.entity.animation.FlameSpiritAnimations;
import fr.zadar.elementary.entity.custom.FlameSpiritEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class FlameSpiritModel<T extends FlameSpiritEntity> extends SinglePartEntityModel<T> {
	private final ModelPart FlameSpirit;
	private final ModelPart Head;

	public FlameSpiritModel(ModelPart root) {
		this.FlameSpirit = root.getChild("FlameSpirit");
		this.Head = FlameSpirit.getChild("Head");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData FlameSpirit = modelPartData.addChild("FlameSpirit", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData Head = FlameSpirit.addChild("Head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -11.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -24.0F, 0.0F));

		ModelPartData Body = FlameSpirit.addChild("Body", ModelPartBuilder.create().uv(0, 16).cuboid(-4.0F, -3.0F, -2.0F, 8.0F, 14.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -24.0F, 0.0F));

		ModelPartData RightArm = FlameSpirit.addChild("RightArm", ModelPartBuilder.create().uv(16, 35).cuboid(-3.0F, -5.0F, -2.0F, 4.0F, 13.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-5.0F, -22.0F, 0.0F));

		ModelPartData LeftArm = FlameSpirit.addChild("LeftArm", ModelPartBuilder.create().uv(32, 35).cuboid(-1.0F, -5.0F, -2.0F, 4.0F, 13.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(5.0F, -22.0F, 0.0F));

		ModelPartData RightLeg = FlameSpirit.addChild("RightLeg", ModelPartBuilder.create().uv(24, 16).cuboid(-2.0F, -3.0F, -2.0F, 4.0F, 15.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.9F, -12.0F, 0.0F));

		ModelPartData LeftLeg = FlameSpirit.addChild("LeftLeg", ModelPartBuilder.create().uv(0, 34).cuboid(-2.0F, -3.0F, -2.0F, 4.0F, 15.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(1.9F, -12.0F, 0.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}
	@Override
	public void setAngles(FlameSpiritEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw, headPitch);

		this.animateMovement(FlameSpiritAnimations.FLAME_SPIRIT_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, FlameSpiritAnimations.FLAME_SPIRIT_IDLE, ageInTicks, 1f);
	}

	private void setHeadAngles(float headYaw, float headPitch) {
		headYaw = MathHelper.clamp(headYaw, -30.0f, 30.0f);
		headPitch = MathHelper.clamp(headPitch, -25.0f, 45.0f);

		this.Head.yaw = headYaw * 0.017453292f;
		this.Head.pitch = headPitch * 0.017453292f;
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		FlameSpirit.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return FlameSpirit;
	}
}