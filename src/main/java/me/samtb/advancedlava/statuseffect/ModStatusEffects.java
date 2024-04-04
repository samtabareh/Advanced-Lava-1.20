package me.samtb.advancedlava.statuseffect;

import me.samtb.advancedlava.AdvancedLava;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModStatusEffects {

	public static final StatusEffect MELT = register("melt", new MeltStatusEffect());

	private static StatusEffect register(String name, StatusEffect effect) {
		return Registry.register(Registries.STATUS_EFFECT, new Identifier(AdvancedLava.MOD_ID, name), effect);
	}

	public static void registerModStatusEffects() {
		AdvancedLava.LOGGER.info("Registering mod status effects for "+ AdvancedLava.MOD_ID);
	}
}
