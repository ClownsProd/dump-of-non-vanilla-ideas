package su.clwn.dumpofnonvanillaideas.entity;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import su.clwn.dumpofnonvanillaideas.registry.SoundEventRegistry;

public class SeregaEntity extends BasicNextBot {
  public SeregaEntity(EntityType<? extends Monster> entityType, Level level) {
    super(entityType, level);
    this.soundChance = 50;
    this.soundVolume = 0.3F;
  }

  @Override
  public SoundEvent getEntitySound() {
    return SoundEventRegistry.SEREGA.get();
  }
}
