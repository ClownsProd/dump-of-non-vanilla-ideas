package su.clwn.dumpofnonvanillaideas.net.packet;

import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import org.jetbrains.annotations.NotNull;
import su.clwn.dumpofnonvanillaideas.util.DonviIdentifier;

public record SeregaAttackPacket implements CustomPacketPayload {
  public static final CustomPacketPayload.Type<SeregaAttackPacket> TYPE = new CustomPacketPayload.Type<>(DonviIdentifier.get("serega_attack"));

  @Override
  public @NotNull Type<? extends CustomPacketPayload> type() {
    return TYPE;
  }
}
