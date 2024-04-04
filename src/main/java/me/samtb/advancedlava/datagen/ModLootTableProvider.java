package me.samtb.advancedlava.datagen;

import me.samtb.advancedlava.block.ModBlocks;
import me.samtb.advancedlava.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.GRAPHITE_ORE, oreDrops(ModBlocks.GRAPHITE_ORE, ModItems.GRAPHITE));
        addDrop(ModBlocks.DEEPSLATE_GRAPHITE_ORE, oreDrops(ModBlocks.DEEPSLATE_GRAPHITE_ORE, ModItems.GRAPHITE));
        addDrop(ModBlocks.NETHER_GRAPHITE_ORE, oreDrops(ModBlocks.NETHER_GRAPHITE_ORE, ModItems.GRAPHITE));
    }

    public LootTable.Builder oreDrops(Block dropWithSilkTouch, Item drop) {
        return BlockLootTableGenerator.dropsWithSilkTouch(dropWithSilkTouch, this.applyExplosionDecay(dropWithSilkTouch,
                ItemEntry.builder(drop).apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
    }
}
