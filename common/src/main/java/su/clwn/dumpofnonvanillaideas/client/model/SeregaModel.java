package su.clwn.dumpofnonvanillaideas.client.model;

// Made with Blockbench 4.12.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;
import su.clwn.dumpofnonvanillaideas.util.DonviIdentifier;

public class SeregaModel<T extends Entity> extends EntityModel<T> {
  // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
  public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(DonviIdentifier.get("serega"), "main");
  private final ModelPart bb_main;

  public SeregaModel(ModelPart root) {
    this.bb_main = root.getChild("bb_main");
  }

  public static LayerDefinition createBodyLayer() {
    MeshDefinition meshdefinition = new MeshDefinition();
    PartDefinition partdefinition = meshdefinition.getRoot();

    PartDefinition bb_main = partdefinition.addOrReplaceChild(
            "bb_main",
            CubeListBuilder.create()
                    .texOffs(0, 0)
                    .addBox(-24.0F, -48.0F, 0.0F, 48.0F, 32.0F, 0.0625F,
                            new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

    return LayerDefinition.create(meshdefinition, 47, 32);
  }

  @Override
  public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

  }

  @Override
  public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int i, int j, int k) {
    bb_main.render(poseStack, vertexConsumer, i, j, k);
  }
}