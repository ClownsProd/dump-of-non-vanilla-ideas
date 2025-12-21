package su.clwn.dumpofnonvanillaideas.entity.ai.goal;

import dev.architectury.networking.NetworkManager;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import su.clwn.dumpofnonvanillaideas.net.packet.SeregaAttackPacket;

public class SeregaAttackGoal extends MeleeAttackGoal {
  public SeregaAttackGoal(PathfinderMob pathfinderMob, double speedModifier, boolean followingTargetEvenIfNotSeen) {
    super(pathfinderMob, speedModifier, followingTargetEvenIfNotSeen);
  }

  @Override
  protected void checkAndPerformAttack(LivingEntity livingEntity) {
    if (this.canPerformAttack(livingEntity)) {
      if (livingEntity instanceof ServerPlayer serverPlayer) {
        NetworkManager.sendToPlayer(serverPlayer, new SeregaAttackPacket());
      }
    }
  }
}
