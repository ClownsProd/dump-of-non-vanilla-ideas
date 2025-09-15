package su.clwn.dumpofnonvanillaideas.util;

import net.minecraft.resources.ResourceLocation;
import su.clwn.dumpofnonvanillaideas.DumpOfNonVanillaIdeas;

public class DonviIdentifier {
  public static ResourceLocation get(String path) {
    return ResourceLocation.fromNamespaceAndPath(DumpOfNonVanillaIdeas.MOD_ID, path);
  }
}