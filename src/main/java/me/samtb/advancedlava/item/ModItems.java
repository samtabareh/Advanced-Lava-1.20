package me.samtb.advancedlava.item;

import me.samtb.advancedlava.AdvancedLava;
import me.samtb.advancedlava.block.ModBlocks;
import me.samtb.advancedlava.util.ModTags;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModItems {

    public static final Item GRAPHITE = registerItem("graphite", new Item(new FabricItemSettings()));

    // Graphite Armor
    public static final Item GRAPHITE_HELMET = registerItem("graphite_helmet",
            new ArmorItem(ModArmorMaterials.GRAPHITE, ArmorItem.Type.HELMET, new FabricItemSettings().fireproof()));
    public static final Item GRAPHITE_CHESTPLATE = registerItem("graphite_chestplate",
            new ArmorItem(ModArmorMaterials.GRAPHITE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings().fireproof()));
    public static final Item GRAPHITE_LEGGINGS = registerItem("graphite_leggings",
            new ArmorItem(ModArmorMaterials.GRAPHITE, ArmorItem.Type.LEGGINGS, new FabricItemSettings().fireproof()));
    public static final Item GRAPHITE_BOOTS = registerItem("graphite_boots",
            new ArmorItem(ModArmorMaterials.GRAPHITE, ArmorItem.Type.BOOTS, new FabricItemSettings().fireproof()));

    // Netherite Graphite Armor
    public static final Item NETHERITE_GRAPHITE_HELMET = registerItem("netherite_graphite_helmet",
            new ArmorItem(ModArmorMaterials.NETHERITE_GRAPHITE, ArmorItem.Type.HELMET, new FabricItemSettings().fireproof()));
    public static final Item NETHERITE_GRAPHITE_CHESTPLATE = registerItem("netherite_graphite_chestplate",
            new ArmorItem(ModArmorMaterials.NETHERITE_GRAPHITE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings().fireproof()));
    public static final Item NETHERITE_GRAPHITE_LEGGINGS = registerItem("netherite_graphite_leggings",
            new ArmorItem(ModArmorMaterials.NETHERITE_GRAPHITE, ArmorItem.Type.LEGGINGS, new FabricItemSettings().fireproof()));
    public static final Item NETHERITE_GRAPHITE_BOOTS = registerItem("netherite_graphite_boots",
            new ArmorItem(ModArmorMaterials.NETHERITE_GRAPHITE, ArmorItem.Type.BOOTS, new FabricItemSettings().fireproof()));

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.addAfter(Items.DIAMOND, GRAPHITE);
    }

    private static void addItemsToNaturalBlocksItemGroup(FabricItemGroupEntries entries) {
        entries.addAfter(Blocks.DEEPSLATE_DIAMOND_ORE, ModBlocks.GRAPHITE_ORE);
        entries.addAfter(ModBlocks.GRAPHITE_ORE, ModBlocks.DEEPSLATE_GRAPHITE_ORE);
        entries.addAfter(ModBlocks.DEEPSLATE_GRAPHITE_ORE, ModBlocks.NETHER_GRAPHITE_ORE);
    }

    private static void addItemsToCombatItemGroup(FabricItemGroupEntries entries) {
        entries.addAfter(Items.DIAMOND_BOOTS, GRAPHITE_HELMET);
        entries.addAfter(GRAPHITE_HELMET, GRAPHITE_CHESTPLATE);
        entries.addAfter(GRAPHITE_CHESTPLATE, GRAPHITE_LEGGINGS);
        entries.addAfter(GRAPHITE_LEGGINGS, GRAPHITE_BOOTS);
        
        entries.addAfter(Items.NETHERITE_BOOTS, NETHERITE_GRAPHITE_HELMET);
        entries.addAfter(NETHERITE_GRAPHITE_HELMET, NETHERITE_GRAPHITE_CHESTPLATE);
        entries.addAfter(NETHERITE_GRAPHITE_CHESTPLATE, NETHERITE_GRAPHITE_LEGGINGS);
        entries.addAfter(NETHERITE_GRAPHITE_LEGGINGS, NETHERITE_GRAPHITE_BOOTS);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(AdvancedLava.MOD_ID, name), item);
    }

     public static void registerModItems() {
         AdvancedLava.LOGGER.info("Registering mod items for "+ AdvancedLava.MOD_ID);

         ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
         ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::addItemsToCombatItemGroup);
         ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(ModItems::addItemsToNaturalBlocksItemGroup);
     }
}