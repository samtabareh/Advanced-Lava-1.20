package me.samtb.advancedlava.item;

import net.minecraft.item.SmithingTemplateItem;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.List;

public class GraphiteUpgradeSmithingTemplate extends SmithingTemplateItem {
	
	private static final Formatting TITLE_FORMATTING = Formatting.GRAY;
	private static final Formatting DESCRIPTION_FORMATTING = Formatting.BLUE;

	private static final Text GRAPHITE_UPGRADE_TEXT = Text.translatable(Util.createTranslationKey("upgrade", new Identifier("graphite_upgrade"))).formatted(TITLE_FORMATTING);
	private static final Text GRAPHITE_UPGRADE_APPLIES_TO_TEXT = Text.translatable(Util.createTranslationKey("item", new Identifier("smithing_template.graphite_upgrade.applies_to"))).formatted(DESCRIPTION_FORMATTING);
	private static final Text GRAPHITE_UPGRADE_INGREDIENTS_TEXT = Text.translatable(Util.createTranslationKey("item", new Identifier("smithing_template.graphite_upgrade.ingredients"))).formatted(DESCRIPTION_FORMATTING);
	private static final Text GRAPHITE_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT = Text.translatable(Util.createTranslationKey("item", new Identifier("smithing_template.graphite_upgrade.base_slot_description")));
	private static final Text GRAPHITE_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT = Text.translatable(Util.createTranslationKey("item", new Identifier("smithing_template.graphite_upgrade.additions_slot_description")));

	private static final Identifier EMPTY_ARMOR_SLOT_HELMET_TEXTURE = new Identifier("item/empty_armor_slot_helmet");
	private static final Identifier EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE = new Identifier("item/empty_armor_slot_chestplate");
	private static final Identifier EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE = new Identifier("item/empty_armor_slot_leggings");
	private static final Identifier EMPTY_ARMOR_SLOT_BOOTS_TEXTURE = new Identifier("item/empty_armor_slot_boots");
	private static final Identifier EMPTY_SLOT_GRAPHITE_TEXTURE = new Identifier("advancedlava", "item/empty_slot_graphite");

	public GraphiteUpgradeSmithingTemplate(Text appliesToText, Text ingredientsText, Text titleText, Text baseSlotDescriptionText, Text additionsSlotDescriptionText, List<Identifier> emptyBaseSlotTextures, List<Identifier> emptyAdditionsSlotTextures) {
		super(appliesToText, ingredientsText, titleText, baseSlotDescriptionText, additionsSlotDescriptionText, emptyBaseSlotTextures, emptyAdditionsSlotTextures);
	}

	private static List<Identifier> getGraphiteUpgradeEmptyBaseSlotTextures() {
		return List.of(EMPTY_ARMOR_SLOT_HELMET_TEXTURE, EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE, EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE, EMPTY_ARMOR_SLOT_BOOTS_TEXTURE);
	}

	private static List<Identifier> getGraphiteUpgradeEmptyAdditionsSlotTextures() {
		return List.of(EMPTY_SLOT_GRAPHITE_TEXTURE);
	}

	public static SmithingTemplateItem createGraphiteUpgrade() {
		return new SmithingTemplateItem(GRAPHITE_UPGRADE_APPLIES_TO_TEXT, GRAPHITE_UPGRADE_INGREDIENTS_TEXT, GRAPHITE_UPGRADE_TEXT, GRAPHITE_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT, GRAPHITE_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT, getGraphiteUpgradeEmptyBaseSlotTextures(), getGraphiteUpgradeEmptyAdditionsSlotTextures());
	}
}
