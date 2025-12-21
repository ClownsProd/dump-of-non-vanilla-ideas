package su.clwn.dumpofnonvanillaideas.entity;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import su.clwn.dumpofnonvanillaideas.entity.ai.goal.SeregaAttackGoal;
import su.clwn.dumpofnonvanillaideas.registry.SoundEventRegistry;

public class SeregaEntity extends BasicNextBot {
  public SeregaEntity(EntityType<? extends Monster> entityType, Level level) {
    super(entityType, level);
    this.soundChance = 50;
    this.soundVolume = 0.3F;
  }

  @Override
  protected void registerGoals() {
    super.registerGoals();
    this.goalSelector.addGoal(1, new SeregaAttackGoal(this, 1.1D, true));
    this.goalSelector.addGoal(2, new FloatGoal(this));
    this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Player.class, false, false));
  }

  @Override
  public SoundEvent getEntitySound() {
    return SoundEventRegistry.SEREGA.get();
  }
}
