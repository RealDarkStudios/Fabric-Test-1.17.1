package net.thedarkgamer.fabricmod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import net.thedarkgamer.fabricmod.FabricTest;
import net.thedarkgamer.fabricmod.block.custom.StatusBlock;
import net.thedarkgamer.fabricmod.item.ModItemGroups;

public class ModBlocks {

    public static final Block OVERWORLD_EXOTIC_ORE = registerBlock("overworld_exotic_ore", new Block(FabricBlockSettings.of(Material.STONE).hardness(2).strength(2).requiresTool()), new FabricItemSettings().rarity(Rarity.RARE).fireproof().group(ModItemGroups.BLOCKS));
    public static final Block OVERWORLD_EXOTIC_BLOCK = registerBlock("overworld_exotic_block", new Block(FabricBlockSettings.of(Material.METAL).hardness(4).strength(3).requiresTool()), new FabricItemSettings().rarity(Rarity.RARE).fireproof().group(ModItemGroups.BLOCKS));
    //public static final Block STATUS_BLOCK = registerBlock("status_block", new StatusBlock(FabricBlockSettings.of(Material.METAL).hardness(1).strength(1).requiresTool()), new FabricItemSettings().rarity(Rarity.RARE).fireproof().group(ModItemGroups.TOOLS));

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
