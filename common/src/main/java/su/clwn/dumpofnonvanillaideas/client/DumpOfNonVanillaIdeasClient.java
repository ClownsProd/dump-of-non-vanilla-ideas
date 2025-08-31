package su.clwn.dumpofnonvanillaideas.client;

import dev.architectury.event.events.client.ClientLifecycleEvent;
import su.clwn.dumpofnonvanillaideas.client.renderer.DonviEntityRendering;

public class DumpOfNonVanillaIdeasClient {
  public static void init() {
    ClientLifecycleEvent.CLIENT_STARTED.register(listener -> {
      DonviEntityRendering.initEntityRendering();
    });
  }
}
