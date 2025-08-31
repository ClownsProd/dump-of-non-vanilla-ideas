package su.clwn.dumpofnonvanillaideas.client.renderer;

import dev.architectury.registry.client.level.entity.EntityModelLayerRegistry;
import dev.architectury.registry.client.level.entity.EntityRendererRegistry;
import net.minecraft.resources.ResourceLocation;
import su.clwn.dumpofnonvanillaideas.DumpOfNonVanillaIdeas;
import su.clwn.dumpofnonvanillaideas.client.model.SeregaModel;
import su.clwn.dumpofnonvanillaideas.entity.BasicNextBot;
import su.clwn.dumpofnonvanillaideas.entity.DonviEntityTypes;

public class DonviEntityRendering {
  public static void initEntityRendering() {
    EntityModelLayerRegistry.register(SeregaModel.LAYER_LOCATION, SeregaModel::createBodyLayer);
    EntityRendererRegistry.register(DonviEntityTypes.SEREGA, context -> {
      SeregaModel<BasicNextBot> model = new SeregaModel<>(context.bakeLayer(SeregaModel.LAYER_LOCATION));
      ResourceLocation texture = ResourceLocation.fromNamespaceAndPath(DumpOfNonVanillaIdeas.MOD_ID, "textures/entity/serega.png");
      return new BillboardRenderer<>(context, model, texture);
    });
  }
}
