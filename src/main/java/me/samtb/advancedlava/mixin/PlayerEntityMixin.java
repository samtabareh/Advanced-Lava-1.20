package me.samtb.advancedlava.mixin;

import me.samtb.advancedlava.item.ModArmorMaterials;
import me.samtb.advancedlava.statuseffect.ModStatusEffects;
import net.minecraft.block.Blocks;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.concurrent.atomic.AtomicBoolean;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {
    @Inject(method = "tickMovement", at = @At("TAIL"))
    private void tickMovement(CallbackInfo ci) {
        PlayerEntity player = (PlayerEntity) (Object) this;
        World world = player.getWorld();
        boolean wearingGraphite = true;
        boolean wearingAnyGraphite = false;

        for (ItemStack itemStack : player.getArmorItems()) {
            if (itemStack.getItem() == Items.AIR) {
                wearingGraphite = false;
                continue;
            }
            ArmorItem armorItem = (ArmorItem) itemStack.getItem();
            ArmorMaterial mat = armorItem.getMaterial();
            if (mat != ModArmorMaterials.GRAPHITE &&
                    mat != ModArmorMaterials.NETHERITE_GRAPHITE)
                wearingGraphite = false;
            else
                wearingAnyGraphite = true;
        }

        if (world.getRegistryKey() == World.NETHER) {
            if (!wearingGraphite) player.addStatusEffect(new StatusEffectInstance(ModStatusEffects.MELT, 1));
        }
        int r = 8;
        BlockPos playerPos = player.getBlockPos();
        boolean finalWearingAnyGraphite = wearingAnyGraphite;
        BlockPos.findClosest(playerPos, r, 3, pos -> world.getFluidState(pos).isIn(FluidTags.LAVA)).ifPresent(lavaPos -> {
//            int x1 = playerPos.getX();
//            int y1 = playerPos.getY();
//            int z1 = playerPos.getZ();
//
//            int x2 = lavaPos.getX();
//            int y2 = lavaPos.getY() + 1;
//            int z2 = lavaPos.getZ();
//            for (int x = Math.min(x1, x2); x <= Math.max(x1, x2); x++) for (int y = Math.min(y1, y2); y <= Math.max(y1, y2); y++) for (int z = Math.min(z1, z2); z <= Math.max(z1, z2); z++) {
//                BlockPos blockPos = new BlockPos(x, y, z);
//                if (!world.getBlockState(blockPos).isAir() && !world.getBlockState(blockPos).getFluidState().isIn(FluidTags.LAVA)) return;
//            }
            int lavaNear = 1;
            for (Direction direction : Direction.values()) {
                BlockPos pos2 = lavaPos.offset(direction);
                if (world.getBlockState(pos2) == Blocks.LAVA.getDefaultState()) lavaNear++;
            }
            float distance = playerPos.getManhattanDistance(lavaPos) / 3f;
            if (!finalWearingAnyGraphite) {
                player.addStatusEffect(new StatusEffectInstance(ModStatusEffects.MELT, 1, Math.round(1f / distance + lavaNear / 3f)));
            }
        });
    }
}