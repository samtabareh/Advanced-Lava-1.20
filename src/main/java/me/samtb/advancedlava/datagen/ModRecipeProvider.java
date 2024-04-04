package me.samtb.advancedlava.datagen;

import me.samtb.advancedlava.block.ModBlocks;
import me.samtb.advancedlava.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> GRAPHITE_SMELTABLES = List.of(ModBlocks.GRAPHITE_ORE,
            ModBlocks.DEEPSLATE_GRAPHITE_ORE, ModBlocks.NETHER_GRAPHITE_ORE);

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerSmelting(exporter, GRAPHITE_SMELTABLES, RecipeCategory.MISC, ModItems.GRAPHITE,
                0.7f, 300, "graphite");
        offerBlasting(exporter, GRAPHITE_SMELTABLES, RecipeCategory.MISC, ModItems.GRAPHITE,
                0.7f, 150, "graphite");

        offerNetheriteUpgradeRecipe(exporter, ModItems.GRAPHITE_HELMET, RecipeCategory.COMBAT, ModItems.NETHERITE_GRAPHITE_HELMET);
        offerNetheriteUpgradeRecipe(exporter, ModItems.GRAPHITE_CHESTPLATE, RecipeCategory.COMBAT, ModItems.NETHERITE_GRAPHITE_CHESTPLATE);
        offerNetheriteUpgradeRecipe(exporter, ModItems.GRAPHITE_LEGGINGS, RecipeCategory.COMBAT, ModItems.NETHERITE_GRAPHITE_LEGGINGS);
        offerNetheriteUpgradeRecipe(exporter, ModItems.GRAPHITE_BOOTS, RecipeCategory.COMBAT, ModItems.NETHERITE_GRAPHITE_BOOTS);

        // Graphite Helmet
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.GRAPHITE_HELMET)
                .pattern("GDG")
                .pattern("G G")
                .pattern("   ")
                .input('G', ModItems.GRAPHITE)
                .input('D', Items.DIAMOND)
                .criterion(hasItem(ModItems.GRAPHITE), conditionsFromItem(ModItems.GRAPHITE))
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.GRAPHITE_HELMET)));
        // Graphite Chestplate
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.GRAPHITE_CHESTPLATE)
                .pattern("G G")
                .pattern("GDG")
                .pattern("DGD")
                .input('G', ModItems.GRAPHITE)
                .input('D', Items.DIAMOND)
                .criterion(hasItem(ModItems.GRAPHITE), conditionsFromItem(ModItems.GRAPHITE))
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.GRAPHITE_CHESTPLATE)));
        // Graphite Leggings
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.GRAPHITE_LEGGINGS)
                .pattern("GDG")
                .pattern("D D")
                .pattern("G G")
                .input('G', ModItems.GRAPHITE)
                .input('D', Items.DIAMOND)
                .criterion(hasItem(ModItems.GRAPHITE), conditionsFromItem(ModItems.GRAPHITE))
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.GRAPHITE_LEGGINGS)));
        // Graphite Boots
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.GRAPHITE_BOOTS)
                .pattern("   ")
                .pattern("D D")
                .pattern("G G")
                .input('G', ModItems.GRAPHITE)
                .input('D', Items.DIAMOND)
                .criterion(hasItem(ModItems.GRAPHITE), conditionsFromItem(ModItems.GRAPHITE))
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.GRAPHITE_BOOTS)));
    }
}
