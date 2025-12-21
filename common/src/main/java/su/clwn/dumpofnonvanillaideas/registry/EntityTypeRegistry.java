package su.clwn.dumpofnonvanillaideas.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import su.clwn.dumpofnonvanillaideas.DumpOfNonVanillaIdeas;
import su.clwn.dumpofnonvanillaideas.entity.SeregaEntity;
import su.clwn.dumpofnonvanillaideas.util.DonviIdentifier;

import java.util.function.Supplier;

public class EntityTypeRegistry {
  private static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(DumpOfNonVanillaIdeas.MOD_ID, Registries.ENTITY_TYPE);

  public static RegistrySupplier<EntityType<SeregaEntity>> SEREGA;

  public static void init() {
    System.out.println(ResourceKey.create(Registries.ENTITY_TYPE, DonviIdentifier.get("serega")));

    SEREGA = registerEntityType("serega", () -> EntityType.Builder.of(SeregaEntity::new, MobCategory.MONSTER)
            .sized(1.5f, 1.8f)
            .clientTrackingRange(32)
            .build(ResourceKey.create(Registries.ENTITY_TYPE, DonviIdentifier.get("serega")).toString()));

    ENTITIES.register();

  }

  private static <T extends Entity> RegistrySupplier<EntityType<T>> registerEntityType(String name, Supplier<EntityType<T>> entityType) {
    return ENTITIES.register(DonviIdentifier.get(name), entityType);
  }

}
