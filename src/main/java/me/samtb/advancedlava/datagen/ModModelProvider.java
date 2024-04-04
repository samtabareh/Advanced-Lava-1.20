package me.samtb.advancedlava.datagen;

import me.samtb.advancedlava.block.ModBlocks;
import me.samtb.advancedlava.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GRAPHITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_GRAPHITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_GRAPHITE_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.GRAPHITE, Models.GENERATED);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.GRAPHITE_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.GRAPHITE_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.GRAPHITE_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.GRAPHITE_BOOTS));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.NETHERITE_GRAPHITE_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.NETHERITE_GRAPHITE_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.NETHERITE_GRAPHITE_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.NETHERITE_GRAPHITE_BOOTS));
    }
}
