package nerdhub.textilelib.mixins;

import nerdhub.textilelib.eventhandlers.EventRegistry;
import nerdhub.textilelib.events.TickEvents;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.BooleanSupplier;

@Mixin(MinecraftServer.class)
public class MixinMinecraftServer {

    @Inject(method = "method_3748", at = @At("HEAD"))
    protected void method_3748(BooleanSupplier booleanSupplier_1, CallbackInfo ci) {
        TickEvents.ServerTickEvent serverTickEvent = new TickEvents.ServerTickEvent();
        EventRegistry.runEvent(serverTickEvent);
    }
}
