package su.clwn.dumpofnonvanillaideas.entity;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import su.clwn.dumpofnonvanillaideas.DumpOfNonVanillaIdeas;

import java.util.function.Supplier;

public class DonviEntityTypes {
  private static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(DumpOfNonVanillaIdeas.MOD_ID, Registries.ENTITY_TYPE);

  public static RegistrySupplier<EntityType<BasicNextBot>> SEREGA;

  public static void initEntityTypes() {
    System.out.println(ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(DumpOfNonVanillaIdeas.MOD_ID, "serega")));

    SEREGA = registerEntityType("serega", () -> EntityType.Builder.of(BasicNextBot::new, MobCategory.MONSTER)
            .sized(2f, 2.4f)
            .clientTrackingRange(10)
            .build(ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(DumpOfNonVanillaIdeas.MOD_ID, "serega")).toString()));

    ENTITIES.register();

  }

  private static <T extends Entity> RegistrySupplier<EntityType<T>> registerEntityType(String name, Supplier<EntityType<T>> entityType) {
    return ENTITIES.register(ResourceLocation.fromNamespaceAndPath(DumpOfNonVanillaIdeas.MOD_ID, name), entityType);
  }

}
