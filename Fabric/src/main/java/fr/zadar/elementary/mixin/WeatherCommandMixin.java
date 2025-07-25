package fr.zadar.elementary.mixin;

import fr.zadar.elementary.event.ToolEvents;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.command.WeatherCommand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(WeatherCommand.class)
public class WeatherCommandMixin {
    @Inject(method = "executeClear", at = @At("HEAD"))
    private static void onSetClear(ServerCommandSource source, int duration, CallbackInfoReturnable<Integer> cir) {
        if (ToolEvents.isRaining) {
            ToolEvents.isRaining = false;
            ToolEvents.rainDuration = 0;
        }
    }
}
