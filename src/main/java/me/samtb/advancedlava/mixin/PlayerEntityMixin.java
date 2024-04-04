package me.samtb.advancedlava.mixin;

import me.samtb.advancedlava.item.ModArmorMaterials;
import me.samtb.advancedlava.util.ModDamageTypes;
import me.samtb.advancedlava.statuseffect.ModStatusEffects;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {
    @Inject(method = "tickMovement", at = @At("HEAD"))
    private void tickMovement(CallbackInfo ci) {
        PlayerEntity player = (PlayerEntity) (Object) this;
        World world = player.getWorld();
        if (world.getRegistryKey() == World.NETHER) {
            boolean wearingGraphite = true;

            for (ItemStack itemStack : player.getArmorItems()) {
                if (itemStack.getItem() == Items.AIR) {
                    wearingGraphite = false;
                    continue;
                }
                ArmorItem armorItem = (ArmorItem) itemStack.getItem();
                ArmorMaterial mat = armorItem.getMaterial();
                if (mat != ModArmorMaterials.GRAPHITE &&
                    mat != ModArmorMaterials.NETHERITE_GRAPHITE) wearingGraphite = false;
            }
            if (!wearingGraphite) player.addStatusEffect(new StatusEffectInstance(ModStatusEffects.MELT, 1));
        }

        int r = 10;
        BlockPos blockPos = player.getBlockPos();
        BlockPos.findClosest(blockPos, r, 3, pos -> world.getFluidState(pos).isIn(FluidTags.LAVA)).ifPresent(pos -> {
            float distance = blockPos.getManhattanDistance(pos) / 3f;
            float dmg = 0f;
            for (ItemStack itemStack : player.getArmorItems()) {
                if (itemStack.getItem() == Items.AIR) {
                    dmg += 0.5f;
                    continue;
                }
                ArmorItem armorItem = (ArmorItem) itemStack.getItem();
                ArmorMaterial mat = armorItem.getMaterial();
                if (mat != ModArmorMaterials.GRAPHITE &&
                    mat != ModArmorMaterials.NETHERITE_GRAPHITE) dmg += MathHelper.clamp((1f / mat.getProtection(armorItem.getType()) * 10f), 0.5f, 3.5f);
            }
            if (dmg != 0f) {
                player.addStatusEffect(new StatusEffectInstance(ModStatusEffects.MELT, 1, Math.round(1f / (distance + dmg))));
            }
        });
    }
}