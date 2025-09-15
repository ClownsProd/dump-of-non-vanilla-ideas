package su.clwn.dumpofnonvanillaideas.neoforge;

import net.neoforged.fml.common.Mod;
import su.clwn.dumpofnonvanillaideas.DumpOfNonVanillaIdeas;
import su.clwn.dumpofnonvanillaideas.client.renderer.DonviEntityRendering;

@Mod(DumpOfNonVanillaIdeas.MOD_ID)
public final class DumpOfNonVanillaIdeasNeoForge {
  public DumpOfNonVanillaIdeasNeoForge() {
    DumpOfNonVanillaIdeas.init();
    DonviEntityRendering.initEntityRendering();
  }
}
