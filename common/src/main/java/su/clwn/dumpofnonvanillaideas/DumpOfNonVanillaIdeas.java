package su.clwn.dumpofnonvanillaideas;

import com.mojang.logging.LogUtils;
import dev.architectury.platform.Platform;
import dev.architectury.registry.level.entity.EntityAttributeRegistry;
import net.fabricmc.api.EnvType;
import org.slf4j.Logger;
import su.clwn.dumpofnonvanillaideas.client.DumpOfNonVanillaIdeasClient;
import su.clwn.dumpofnonvanillaideas.entity.SeregaEntity;
import su.clwn.dumpofnonvanillaideas.registry.EntityTypeRegistry;
import su.clwn.dumpofnonvanillaideas.registry.SoundEventRegistry;


public final class DumpOfNonVanillaIdeas {
  public static final String MOD_ID = "donvi";
  public static final Logger LOGGER = LogUtils.getLogger();

  public static void init() {
    EntityTypeRegistry.init();
    SoundEventRegistry.init();

    if (Platform.getEnv() == EnvType.CLIENT) {
      DumpOfNonVanillaIdeasClient.init();
    }

    EntityAttributeRegistry.register(EntityTypeRegistry.SEREGA, SeregaEntity::createAttributes);
  }
}
