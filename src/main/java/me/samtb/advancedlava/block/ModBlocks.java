package me.samtb.advancedlava.block;

import me.samtb.advancedlava.AdvancedLava;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block GRAPHITE_ORE = registerBlock("graphite_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.COAL_ORE)));

    public static final Block DEEPSLATE_GRAPHITE_ORE = registerBlock("deepslate_graphite_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_COAL_ORE)));

    public static final Block NETHER_GRAPHITE_ORE = registerBlock("nether_graphite_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.NETHER_GOLD_ORE)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(AdvancedLava.MOD_ID, name),block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(AdvancedLava.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

     public static void registerModBlocks() {
         AdvancedLava.LOGGER.info("Registering mod block for "+ AdvancedLava.MOD_ID);
     }
}