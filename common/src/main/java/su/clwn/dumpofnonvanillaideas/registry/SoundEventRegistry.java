package su.clwn.dumpofnonvanillaideas.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import su.clwn.dumpofnonvanillaideas.DumpOfNonVanillaIdeas;
import su.clwn.dumpofnonvanillaideas.util.DonviIdentifier;

public class SoundEventRegistry {
  public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
          DeferredRegister.create(DumpOfNonVanillaIdeas.MOD_ID, Registries.SOUND_EVENT);

  public static final RegistrySupplier<SoundEvent> SEREGA = create("mob.serega.random");

  private static RegistrySupplier<SoundEvent> create(String name) {
    return SOUND_EVENTS.register(name,
            () -> SoundEvent.createVariableRangeEvent(DonviIdentifier.get(name)));
  }

  public static void init() {
    SOUND_EVENTS.register();
  }
}
