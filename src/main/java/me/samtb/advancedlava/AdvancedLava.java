package me.samtb.advancedlava;

import me.samtb.advancedlava.block.ModBlocks;
import me.samtb.advancedlava.item.ModItems;
import me.samtb.advancedlava.statuseffect.ModStatusEffects;
import me.samtb.advancedlava.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdvancedLava implements ModInitializer {
    public static final String MOD_ID = "advancedlava";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModStatusEffects.registerModStatusEffects();

		ModWorldGeneration.generateModWorldGen();
	}
}