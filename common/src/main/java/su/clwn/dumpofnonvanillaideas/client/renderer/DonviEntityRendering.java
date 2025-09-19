package su.clwn.dumpofnonvanillaideas.client.renderer;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import su.clwn.dumpofnonvanillaideas.client.model.SeregaModel;
import su.clwn.dumpofnonvanillaideas.entity.SeregaEntity;
import su.clwn.dumpofnonvanillaideas.registry.EntityTypeRegistry;
import su.clwn.dumpofnonvanillaideas.util.DonviIdentifier;

import java.util.function.Supplier;

public class DonviEntityRendering {
  public static void initEntityRendering() {
    registerModelLayer(SeregaModel.LAYER_LOCATION, SeregaModel::createBodyLayer);
    registerEntityRenderer(EntityTypeRegistry.SEREGA, context -> {
      SeregaModel<SeregaEntity> model = new SeregaModel<>(context.bakeLayer(SeregaModel.LAYER_LOCATION));
      ResourceLocation texture = DonviIdentifier.get("textures/entity/serega.png");
      return new BillboardRenderer<>(context, model, texture);
    });
  }

  @ExpectPlatform
  public static void registerModelLayer(ModelLayerLocation layerLocation, Supplier<LayerDefinition> definition) {
    throw new AssertionError();
  }

  @ExpectPlatform
  public static <T extends Entity> void registerEntityRenderer(Supplier<? extends EntityType<? extends T>> type, EntityRendererProvider<T> provider) {
    throw new AssertionError();
  }
}
