package fr.zadar.elementary.mixin;

import fr.zadar.elementary.event.custom.CustomBlockEvents;
import fr.zadar.elementary.event.custom.CustomItemEvents;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.network.ServerPlayerInteractionManager;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ServerPlayerInteractionManager.class)
public class MixinServerPlayerInteractionManager {
    @Shadow
    public ServerPlayerEntity player;

    @Shadow
    public ServerWorld world;

    @Inject(method = "tryBreakBlock", at = @At(
            "INVOKE"))
            //target = "net/minecraft/block/Block.onBreak (Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;Lnet/minecraft/entity/player/PlayerEntity;)V",
            //shift = At.Shift.AFTER))
    private void onTryBreakBlock(BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        BlockState state = world.getBlockState(pos);
        ItemStack drop = new ItemStack(state.getBlock());

        boolean shouldBreak = CustomBlockEvents.IS_BLOCK_BREAK.invoker().isBlockBreak(player, world, pos, state, drop);

        if (!shouldBreak) {
            cir.setReturnValue(false);
        }
    }

    @Inject(method = "interactBlock", at = @At(
            "HEAD"))
            //target = "Lnet/minecraft/server/network/ServerPlayerInteractionManager;interactBlock(Lnet/minecraft/server/network/ServerPlayerEntity;Lnet/minecraft/world/World;Lnet/minecraft/item/ItemStack;)V",
            //shift = At.Shift.AFTER))
    private void onTryRightClickBlock(ServerPlayerEntity player, World world, ItemStack stack, Hand hand, BlockHitResult hitResult, CallbackInfoReturnable<Boolean> cir) {
        BlockPos pos = hitResult.getBlockPos();

        boolean shouldClick = CustomBlockEvents.ON_RIGHT_CLICK.invoker().onRightClick(player, world, pos);

        if (!shouldClick) {
            cir.setReturnValue(false);
        }
    }

    @Inject(method = "interactItem", at = @At("HEAD"))
    private void onTryRightClickItem(ServerPlayerEntity player, World world, ItemStack stack, Hand hand, CallbackInfoReturnable<Boolean> cir) {
        boolean shouldClick = CustomItemEvents.ON_RIGHT_CLICK.invoker().onRightClick(player, world);

        if (!shouldClick) {
            cir.setReturnValue(false);
        }
    }
}
