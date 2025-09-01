package su.clwn.dumpofnonvanillaideas.client.renderer.fabric;

import dev.architectury.registry.client.level.entity.EntityModelLayerRegistry;
import dev.architectury.registry.client.level.entity.EntityRendererRegistry;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;

import java.util.function.Supplier;

public class DonviEntityRenderingImpl {
  public static void registerModelLayer(ModelLayerLocation layerLocation, Supplier<LayerDefinition> definition) {
    EntityModelLayerRegistry.register(layerLocation, definition);
  }

  public static <T extends Entity> void registerEntityRenderer(Supplier<? extends EntityType<? extends T>> type, EntityRendererProvider<T> provider) {
    EntityRendererRegistry.register(type, provider);
  }
}