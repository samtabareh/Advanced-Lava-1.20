package me.samtb.advancedlava.world;

import me.samtb.advancedlava.AdvancedLava;
import me.samtb.advancedlava.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> GRAPHITE_ORE_KEY = registerKey("graphite_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_GRAPHITE_ORE_KEY = registerKey("nether_graphite_ore");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplacables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplacables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplacables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);

        List<OreFeatureConfig.Target> overworldGraphiteOres =
                List.of(OreFeatureConfig.createTarget(stoneReplacables, ModBlocks.GRAPHITE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplacables, ModBlocks.DEEPSLATE_GRAPHITE_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> netherGraphiteOres =
                List.of(OreFeatureConfig.createTarget(netherReplacables, ModBlocks.NETHER_GRAPHITE_ORE.getDefaultState()));

        register(context, GRAPHITE_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldGraphiteOres, 12 /* Max Blocks per vain */, 0.25f));
        register(context, NETHER_GRAPHITE_ORE_KEY, Feature.SCATTERED_ORE, new OreFeatureConfig(netherGraphiteOres, 8 /* Max Blocks per vain */, 1f));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(AdvancedLava.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
