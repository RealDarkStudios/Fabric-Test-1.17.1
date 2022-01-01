package net.thedarkgamer.fabricmod.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.thedarkgamer.fabricmod.FabricTest;
import net.thedarkgamer.fabricmod.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup ITEMS = FabricItemGroupBuilder.build(new Identifier(FabricTest.MOD_ID, "items"), () -> new ItemStack(ModItems.EXOTIC_MATTER));
    public static final ItemGroup BLOCKS = FabricItemGroupBuilder.build(new Identifier(FabricTest.MOD_ID, "blocks"), () -> new ItemStack(ModBlocks.OVERWORLD_EXOTIC_ORE.asItem()));
    public static final ItemGroup TOOLS = FabricItemGroupBuilder.build(new Identifier(FabricTest.MOD_ID, "tools"), () -> new ItemStack(ModItems.ORE_FINDER));
    public static final ItemGroup ARMOR = FabricItemGroupBuilder.build(new Identifier(FabricTest.MOD_ID, "armor"), () -> new ItemStack(ModItems.EXOTIC_CHESTPLATE));

}
