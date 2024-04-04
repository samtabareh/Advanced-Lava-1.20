package me.samtb.advancedlava.datagen;

import me.samtb.advancedlava.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.AdvancementRewards;
import net.minecraft.advancement.CriterionMerger;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.data.server.advancement.vanilla.VanillaStoryTabAdvancementGenerator;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class ModAdvancementProvider extends FabricAdvancementProvider {
	public ModAdvancementProvider(FabricDataOutput output) {
		super(output);
	}

	@Override
	public void generateAdvancement(Consumer<Advancement> consumer) {
		Advancement graphiteItemAdvancement = Advancement.Builder.create()
				.display(
						ModItems.GRAPHITE, // The display icon
						Text.literal("Black Diamonds!"), // The title
						Text.literal("Acquire Graphite"), // The description
						null, // Background image used
						AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
						true, // Show toast top right
						true, // Announce to chat
						false // Hidden in the advancement tab
				)
				// The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
				.criterion("graphite", InventoryChangedCriterion.Conditions.items(ModItems.GRAPHITE))
				.build(consumer, "advancedlava" + "/black_diamond");

		Advancement graphiteArmorAdvancement = Advancement.Builder.create()
				.parent(graphiteItemAdvancement)
				.display(
						ModItems.GRAPHITE_CHESTPLATE, // The display icon
						Text.literal("Cover Me in Carbon"), // The title
						Text.literal("Get Graphite armor"), // The description
						null, // Background image used
						AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
						true, // Show toast top right
						true, // Announce to chat
						false // Hidden in the advancement tab
				)
				.criteriaMerger(CriterionMerger.OR)
				// The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
				.criterion("graphite_helmet", InventoryChangedCriterion.Conditions.items(ModItems.GRAPHITE_HELMET))
				.criterion("graphite_chestplate", InventoryChangedCriterion.Conditions.items(ModItems.GRAPHITE_CHESTPLATE))
				.criterion("graphite_leggings", InventoryChangedCriterion.Conditions.items(ModItems.GRAPHITE_LEGGINGS))
				.criterion("graphite_boots", InventoryChangedCriterion.Conditions.items(ModItems.GRAPHITE_BOOTS))
				.build(consumer, "advancedlava" + "/black_armor");

		Advancement netheriteGraphiteArmorAdvancement = Advancement.Builder.create()
				.parent(graphiteArmorAdvancement)
				.display(
						ModItems.NETHERITE_GRAPHITE_CHESTPLATE, // The display icon
						Text.literal("The Dark Knight"), // The title
						Text.literal("Get a full suit of Netherite Graphite armor"), // The description
						null, // Background image used
						AdvancementFrame.CHALLENGE, // Options: TASK, CHALLENGE, GOAL
						true, // Show toast top right
						true, // Announce to chat
						true // Hidden in the advancement tab
				)
				// The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
				.criterion("netherite_graphite_helmet", InventoryChangedCriterion.Conditions.items(ModItems.NETHERITE_GRAPHITE_HELMET))
				.criterion("netherite_graphite_chestplate", InventoryChangedCriterion.Conditions.items(ModItems.NETHERITE_GRAPHITE_CHESTPLATE))
				.criterion("netherite_graphite_leggings", InventoryChangedCriterion.Conditions.items(ModItems.NETHERITE_GRAPHITE_LEGGINGS))
				.criterion("netherite_graphite_boots", InventoryChangedCriterion.Conditions.items(ModItems.NETHERITE_GRAPHITE_BOOTS))
				.build(consumer, "advancedlava" + "/dark_knight");
	}
}
