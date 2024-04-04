package me.samtb.advancedlava.util;

import me.samtb.advancedlava.AdvancedLava;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
	public static class Blocks {

		public static final TagKey<Block> GRAPHITE_ORES = createTag("graphite_ores");

		private static TagKey<Block> createTag(String name) {
			return TagKey.of(RegistryKeys.BLOCK, new Identifier(AdvancedLava.MOD_ID, name));
		}
	}

	public static class Items {

		private static TagKey<Item> createTag(String name) {
			return TagKey.of(RegistryKeys.ITEM, new Identifier(AdvancedLava.MOD_ID, name));
		}
	}
}
