package me.samtb.advancedlava.statuseffect;

import me.samtb.advancedlava.util.ModDamageTypes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

public class MeltStatusEffect extends StatusEffect {
	public MeltStatusEffect() {
		super(
				StatusEffectCategory.HARMFUL, // whether beneficial or harmful for entities
				0xe85b23);
	}

	@Override
	public boolean canApplyUpdateEffect(int duration, int amplifier) {return true;}

	// This method is called when it applies the status effect.
	@Override
	public void applyUpdateEffect(LivingEntity entity, int amplifier) {
		if (entity instanceof PlayerEntity player) {
			player.damage(ModDamageTypes.of(player.getWorld(), ModDamageTypes.MELT), 2 << amplifier);
			// << shifts the numbers bits to the left by amplifier
		}
	}
}