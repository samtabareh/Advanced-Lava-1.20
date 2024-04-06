package me.samtb.advancedlava.datagen;

import me.samtb.advancedlava.util.ModDamageTypes;
import net.minecraft.data.DataOutput;
import net.minecraft.data.server.tag.vanilla.VanillaDamageTypeTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.DamageTypeTags;

import java.util.concurrent.CompletableFuture;

public class ModDamageTypeTagProvider extends VanillaDamageTypeTagProvider {
	public ModDamageTypeTagProvider(DataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> maxChainedNeighborUpdates) {
		super(output, maxChainedNeighborUpdates);
	}

	@Override
	protected void configure(RegistryWrapper.WrapperLookup lookup) {
		getOrCreateTagBuilder(DamageTypeTags.BYPASSES_ARMOR).add(ModDamageTypes.MELT);
	}
}
