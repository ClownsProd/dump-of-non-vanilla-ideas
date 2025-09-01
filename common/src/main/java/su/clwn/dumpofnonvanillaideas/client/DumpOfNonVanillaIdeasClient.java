package su.clwn.dumpofnonvanillaideas.client;

import dev.architectury.event.events.client.ClientLifecycleEvent;
import dev.architectury.platform.Platform;
import su.clwn.dumpofnonvanillaideas.client.renderer.DonviEntityRendering;

public class DumpOfNonVanillaIdeasClient {
  public static void init() {
    ClientLifecycleEvent.CLIENT_STARTED.register(listener -> {
      if(Platform.isFabric()) {
        DonviEntityRendering.initEntityRendering();
      }
    });
  }
}
