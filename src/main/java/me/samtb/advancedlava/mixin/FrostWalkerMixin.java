package me.samtb.advancedlava.mixin;

import me.samtb.advancedlava.item.ModArmorMaterials;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.enchantment.FrostWalkerEnchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.LavaFluid;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FrostWalkerEnchantment.class)
public class FrostWalkerMixin {
    @Inject(at = @At("HEAD"), method = "freezeWater")
    private static void freezeWater(LivingEntity entity, World world, BlockPos blockPos, int level, CallbackInfo ci) {
        if (!entity.isOnGround()) return;

        if (entity.getEquippedStack(EquipmentSlot.FEET).getItem() instanceof ArmorItem armorItem
                && armorItem.getMaterial() != ModArmorMaterials.GRAPHITE
                && armorItem.getMaterial() != ModArmorMaterials.NETHERITE_GRAPHITE
                && (entity instanceof PlayerEntity player && player.isSneaking())) return;

        int i = 2 + level;
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        for (BlockPos blockPos2 : BlockPos.iterate(blockPos.add(-i, -1, -i), blockPos.add(i, -1, i))) {

            if (!blockPos2.isWithinDistance(entity.getPos(), i)) continue;
            mutable.set(blockPos2.getX(), blockPos2.getY() + 1, blockPos2.getZ());
            BlockState blockState2 = world.getBlockState(mutable);

            BlockState blockState3 = world.getBlockState(blockPos2); // BlockState that is gonna be replaced
            BlockState blockState = blockState3; // BlockState that will be placed

            if (blockState3 == Blocks.LAVA.getDefaultState()) blockState = Blocks.BASALT.getDefaultState();
            else if (blockState3 == Blocks.MAGMA_BLOCK.getDefaultState()) blockState = Blocks.COBBLESTONE.getDefaultState();
            else if (!blockState2.isAir() || !world.canPlace(blockState, blockPos2, ShapeContext.absent())) continue;

            world.setBlockState(blockPos2, blockState);
        }
    }
}
