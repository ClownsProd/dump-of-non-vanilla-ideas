package su.clwn.dumpofnonvanillaideas.entity;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class BasicNextBot extends Monster {
  protected int soundChance = 200;
  protected float soundVolume = 1f;
  public BasicNextBot(EntityType<? extends Monster> entityType, Level level) {
    super(entityType, level);
  }

  @Override
  protected void registerGoals() {
    super.registerGoals();
    this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.1D, false));
    this.goalSelector.addGoal(2, new FloatGoal(this));
    this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Player.class, false, false));
  }

  public static AttributeSupplier.Builder createAttributes() {
    return Monster.createMonsterAttributes()
            .add(Attributes.MOVEMENT_SPEED, 0.5D)
            .add(Attributes.MAX_HEALTH, 500.0D)
            .add(Attributes.ATTACK_DAMAGE, 5.0D)
            .add(Attributes.JUMP_STRENGTH, 0.45D)
            .add(Attributes.FOLLOW_RANGE, 96.0D);
  }

  protected SoundEvent getEntitySound() {
    return null;
  }

  private void playEntitySound() {
    if (this.random.nextInt(soundChance) == 0) {
      if (!this.level().isClientSide) {
        SoundEvent sound = getEntitySound();
        if (sound == null) {
          return;
        }

        float pitch = 0.8F + this.random.nextFloat() * 0.4F;
        this.level().playSound(
                null,
                this.blockPosition(),
                sound,
                SoundSource.HOSTILE,
                soundVolume,
                pitch
        );
      }
    }
  }

  @Override
  public void tick() {
    super.tick();
    playEntitySound();
  }
}
