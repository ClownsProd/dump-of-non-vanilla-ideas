package su.clwn.dumpofnonvanillaideas.neoforge;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import su.clwn.dumpofnonvanillaideas.DumpOfNonVanillaIdeas;
import su.clwn.dumpofnonvanillaideas.client.renderer.DonviEntityRendering;

@Mod(DumpOfNonVanillaIdeas.MOD_ID)
public final class DumpOfNonVanillaIdeasNeoForge {
  public DumpOfNonVanillaIdeasNeoForge() {
    // Run our common setup.
    DumpOfNonVanillaIdeas.init();
    DonviEntityRendering.initEntityRendering();
  }
}
