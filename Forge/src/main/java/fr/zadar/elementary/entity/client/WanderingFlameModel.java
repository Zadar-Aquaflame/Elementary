package fr.zadar.elementary.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

public class WanderingFlameModel<T extends Entity> extends HierarchicalModel<T> {
	private final ModelPart wandering_flame;
	private final ModelPart head;
	/*private final ModelPart flame;
	private final ModelPart flame1;
	private final ModelPart flame2;
	private final ModelPart flame3;
	private final ModelPart flame4;
	private final ModelPart flame5;
	private final ModelPart flame6;*/

	public WanderingFlameModel(ModelPart root) {
		this.wandering_flame = root.getChild("wandering_flame");
		this.head = wandering_flame.getChild("flame").getChild("flame1").getChild("flame2")
				.getChild("flame3").getChild("flame4").getChild("flame5").getChild("flame6");
		/*this.flame = this.wandering_flame.getChild("flame");
		this.flame1 = this.wandering_flame.getChild("flame1");
		this.flame2 = this.wandering_flame.getChild("flame2");
		this.flame3 = this.wandering_flame.getChild("flame3");
		this.flame4 = this.wandering_flame.getChild("flame4");
		this.flame5 = this.wandering_flame.getChild("flame5");
		this.flame6 = this.wandering_flame.getChild("flame6");*/
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition wandering_flame = partdefinition.addOrReplaceChild("wandering_flame", CubeListBuilder.create(), PartPose.offset(0.0F, 10.0F, 0.0F));

		PartDefinition head = wandering_flame.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -18.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(1.0F)), PartPose.offset(0.0F, 14.0F, 0.0F));

		PartDefinition flame = wandering_flame.addOrReplaceChild("flame", CubeListBuilder.create().texOffs(0, 12).addBox(-1.0F, -2.5F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.5F, 6.0F));

		PartDefinition flame1 = wandering_flame.addOrReplaceChild("flame1", CubeListBuilder.create().texOffs(0, 12).addBox(-1.0F, -2.5F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, -4.5F, 5.0F));

		PartDefinition flame2 = wandering_flame.addOrReplaceChild("flame2", CubeListBuilder.create().texOffs(0, 12).addBox(-8.0F, -19.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 14.0F, 0.0F));

		PartDefinition flame3 = wandering_flame.addOrReplaceChild("flame3", CubeListBuilder.create().texOffs(0, 12).addBox(-5.0F, -18.0F, -7.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 14.0F, 0.0F));

		PartDefinition flame4 = wandering_flame.addOrReplaceChild("flame4", CubeListBuilder.create().texOffs(0, 12).addBox(4.0F, -20.0F, -7.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 14.0F, 0.0F));

		PartDefinition flame5 = wandering_flame.addOrReplaceChild("flame5", CubeListBuilder.create().texOffs(0, 12).addBox(6.0F, -19.0F, 4.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 14.0F, 0.0F));

		PartDefinition flame6 = wandering_flame.addOrReplaceChild("flame6", CubeListBuilder.create().texOffs(0, 12).addBox(12.0F, 2.0F, -6.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, -5.0F, 5.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		wandering_flame.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return wandering_flame;
	}
}