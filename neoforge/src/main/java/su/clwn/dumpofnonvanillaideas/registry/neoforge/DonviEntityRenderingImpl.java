package su.clwn.dumpofnonvanillaideas.registry.neoforge;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import su.clwn.dumpofnonvanillaideas.DumpOfNonVanillaIdeas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class DonviEntityRenderingImpl {
  public record EntityRendererEntry<T extends Entity>(
          Supplier<? extends EntityType<T>> type,
          EntityRendererProvider<T> provider
  ) {}

  public record ModelLayerEntry(
          ModelLayerLocation layerLocation,
          Supplier<LayerDefinition> definition
  ) {}

  private static final List<EntityRendererEntry<? extends Entity>> entityRenderers = new ArrayList<>();
  private static final List<ModelLayerEntry> modelLayers = new ArrayList<>();

  public static void registerModelLayer(ModelLayerLocation layerLocation, Supplier<LayerDefinition> definition) {
    modelLayers.add(new ModelLayerEntry(layerLocation, definition));
  }

  public static <T extends Entity> void registerEntityRenderer(Supplier<? extends EntityType<T>> type, EntityRendererProvider<T> provider) {
    entityRenderers.add(new EntityRendererEntry<>(type, provider));
  }

  @EventBusSubscriber(modid = DumpOfNonVanillaIdeas.MOD_ID, value = Dist.CLIENT)
  public static class DonviEntityRenderingEventRegister {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
      for (EntityRendererEntry<? extends Entity> entry : entityRenderers) {
        registerEntityRenderer(entry);
      }
    }

    private static <T extends Entity> void registerEntityRenderer(EntityRendererEntry<T> entry) {
      EntityRenderers.register(entry.type.get(), entry.provider);
    }

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
      for (ModelLayerEntry entry : modelLayers) {
        event.registerLayerDefinition(entry.layerLocation, entry.definition);
      }
    }
  }
}
