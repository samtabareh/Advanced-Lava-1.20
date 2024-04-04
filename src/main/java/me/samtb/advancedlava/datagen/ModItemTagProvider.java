package me.samtb.advancedlava.datagen;

import me.samtb.advancedlava.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
            .add(ModItems.GRAPHITE_HELMET, ModItems.GRAPHITE_CHESTPLATE, ModItems.GRAPHITE_LEGGINGS, ModItems.GRAPHITE_BOOTS)
            .add(ModItems.NETHERITE_GRAPHITE_HELMET, ModItems.NETHERITE_GRAPHITE_CHESTPLATE,
                    ModItems.NETHERITE_GRAPHITE_LEGGINGS, ModItems.NETHERITE_GRAPHITE_BOOTS);
    }
}