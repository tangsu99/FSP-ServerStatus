package cn.tangsu99.fspServerStatus.mixins;

import cn.tangsu99.fspServerStatus.packet.Packet;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftServer.class)
public class MinecraftServerMixin {
    @Shadow private volatile boolean running;

    @Inject(method = "stop", at = @At("HEAD"))
    private void onStop(boolean bl, CallbackInfo ci) {
        if (this.running) {
            Packet.sendStatus(0);
        }
    }
}
