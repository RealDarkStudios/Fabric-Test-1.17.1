package net.thedarkgamer.fabricmod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import net.thedarkgamer.fabricmod.FabricTest;
import net.thedarkgamer.fabricmod.block.custom.ModPressurePlateBlock;
import net.thedarkgamer.fabricmod.block.custom.ModStoneButtonBlock;
import net.thedarkgamer.fabricmod.item.ModItemGroups;
import net.thedarkgamer.fabricmod.block.custom.ModStairsBlock;

public class ModBlocks {

    public static final Block OVERWORLD_EXOTIC_ORE = registerBlock("overworld_exotic_ore", new Block(FabricBlockSettings.of(Material.STONE).hardness(2).strength(2).requiresTool()), new FabricItemSettings().rarity(Rarity.RARE).fireproof().group(ModItemGroups.BLOCKS));
    public static final Block OVERWORLD_EXOTIC_BLOCK = registerBlock("overworld_exotic_block", new Block(FabricBlockSettings.of(Material.METAL).hardness(4).strength(3).requiresTool()), new FabricItemSettings().rarity(Rarity.RARE).fireproof().group(ModItemGroups.BLOCKS));
    //public static final Block STATUS_BLOCK = registerBlock("status_block", new StatusBlock(FabricBlockSettings.of(Material.METAL).hardness(1).strength(1).requiresTool()), new FabricItemSettings().rarity(Rarity.RARE).fireproof().group(ModItemGroups.TOOLS));
    public static final Block OVERWORLD_EXOTIC_STAIRS = registerBlock("overworld_exotic_stairs", new ModStairsBlock(ModBlocks.OVERWORLD_EXOTIC_BLOCK.getDefaultState(), FabricBlockSettings.of(Material.METAL).hardness(4).strength(3).requiresTool()), new FabricItemSettings().rarity(Rarity.RARE).fireproof().group(ModItemGroups.BLOCKS));
    public static final Block OVERWORLD_EXOTIC_SLAB = registerBlock("overworld_exotic_slab", new SlabBlock(FabricBlockSettings.of(Material.METAL).hardness(4).strength(3).requiresTool()), new FabricItemSettings().rarity(Rarity.RARE).fireproof().group(ModItemGroups.BLOCKS));
    public static final Block OVERWORLD_EXOTIC_FENCE = registerBlock("overworld_exotic_fence", new FenceBlock(FabricBlockSettings.of(Material.METAL).hardness(4).strength(3).requiresTool()), new FabricItemSettings().rarity(Rarity.RARE).fireproof().group(ModItemGroups.BLOCKS));
    public static final Block OVERWORLD_EXOTIC_FENCE_GATE = registerBlock("overworld_exotic_fence_gate", new FenceGateBlock(FabricBlockSettings.of(Material.METAL).hardness(4).strength(3).requiresTool()), new FabricItemSettings().rarity(Rarity.RARE).fireproof().group(ModItemGroups.BLOCKS));
    public static final Block OVERWORLD_EXOTIC_BUTTON = registerBlock("overworld_exotic_button", new ModStoneButtonBlock(FabricBlockSettings.of(Material.METAL).hardness(4).strength(3).requiresTool()), new FabricItemSettings().rarity(Rarity.RARE).fireproof().group(ModItemGroups.BLOCKS));
    public static final Block OVERWORLD_EXOTIC_PRESSURE_PLATE = registerBlock("overworld_exotic_pressure_plate", new ModPressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.of(Material.METAL).hardness(4).strength(3).requiresTool()), new FabricItemSettings().rarity(Rarity.RARE).fireproof().group(ModItemGroups.BLOCKS));

    private static Block registerBlock(String name, Block block, FabricItemSettings settings) {
        registerBlockItem(name, block, settings);
        return Registry.register(Registry.BLOCK, new Identifier(FabricTest.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, FabricItemSettings settings) {
        return Registry.register(Registry.ITEM, new Identifier(FabricTest.MOD_ID, name), new BlockItem(block, settings));
    }

    public static void registerModBlocks() {
        FabricTest.LOGGER.info("Registering Mod Blocks for: " + FabricTest.MOD_DISPLAY_NAME);
    }
}
