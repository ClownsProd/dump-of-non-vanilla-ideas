package su.clwn.dumpofnonvanillaideas.neoforge;

import net.neoforged.fml.common.Mod;
import su.clwn.dumpofnonvanillaideas.DumpOfNonVanillaIdeas;
import su.clwn.dumpofnonvanillaideas.registry.EntityRendererRegistry;

@Mod(DumpOfNonVanillaIdeas.MOD_ID)
public final class DumpOfNonVanillaIdeasNeoForge {
  public DumpOfNonVanillaIdeasNeoForge() {
    DumpOfNonVanillaIdeas.init();
    EntityRendererRegistry.initEntityRendering();
  }
}
