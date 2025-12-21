package su.clwn.dumpofnonvanillaideas.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import org.jetbrains.annotations.NotNull;

public class BillboardRenderer<T extends Entity> extends EntityRenderer<T> {
  private final EntityModel<T> model;
  private final ResourceLocation texture;

  public BillboardRenderer(EntityRendererProvider.Context context, EntityModel<T> model, ResourceLocation texture) {
    super(context);
    this.model = model;
    this.texture = texture;
  }

  @Override
  public void render(T entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
    poseStack.pushPose();
    poseStack.translate(0.0, entity.getBbHeight() / 2.0, 0.0);

    // face camera
    poseStack.mulPose(this.entityRenderDispatcher.camera.rotation());

    // fix upside-down model
    poseStack.mulPose(Axis.XP.rotationDegrees(180f));

    VertexConsumer vc = buffer.getBuffer(net.minecraft.client.renderer.RenderType.entityCutoutNoCull(texture));
    model.renderToBuffer(poseStack, vc, packedLight, OverlayTexture.NO_OVERLAY);

    poseStack.popPose();
  }

  @Override
  public @NotNull ResourceLocation getTextureLocation(T entity) {
    return texture;
  }
}
