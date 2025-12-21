package su.clwn.dumpofnonvanillaideas;

import dev.architectury.event.events.client.ClientLifecycleEvent;
import dev.architectury.platform.Platform;
import su.clwn.dumpofnonvanillaideas.registry.EntityRendererRegistry;

public class DumpOfNonVanillaIdeasClient {
  public static void init() {
    ClientLifecycleEvent.CLIENT_STARTED.register(listener -> {
      if (Platform.isFabric()) {
        EntityRendererRegistry.initEntityRendering();
      }
    });
  }
}
