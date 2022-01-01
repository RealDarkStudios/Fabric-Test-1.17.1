package net.thedarkgamer.fabricmod.item;


import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Arm;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import net.thedarkgamer.fabricmod.FabricTest;
import net.thedarkgamer.fabricmod.item.custom.*;

public class ModItems {

    //Exotics
    public static final Item EXOTIC_MATTER = registerItem("overworld_exotic_matter", new Item(new FabricItemSettings().group(ModItemGroups.ITEMS).fireproof().rarity(Rarity.RARE).food(new FoodComponent.Builder().hunger(1).saturationModifier(0.2f).snack().alwaysEdible().build())));

    //Tools
    public static final Item ORE_FINDER = registerItem("ore_finder", new OreFinderItem(new FabricItemSettings().group(ModItemGroups.TOOLS).maxDamage(32).rarity(Rarity.RARE)));
    public static final Item EXOTIC_AXE = registerItem("overworld_exotic_axe", new ModAxeItem(ModToolMaterial.EXOTIC_OVERWORLD, 6.0F, -1.9F, new FabricItemSettings().group(ModItemGroups.TOOLS).rarity(Rarity.RARE)));
    public static final Item EXOTIC_HOE = registerItem("overworld_exotic_hoe", new ModHoeItem(ModToolMaterial.EXOTIC_OVERWORLD, -2, 1.0F, new FabricItemSettings().group(ModItemGroups.TOOLS).rarity(Rarity.RARE)));
    public static final Item EXOTIC_PICKAXE = registerItem("overworld_exotic_pickaxe", new ModPickaxeItem(ModToolMaterial.EXOTIC_OVERWORLD,1, -1.8F, new FabricItemSettings().group(ModItemGroups.TOOLS).rarity(Rarity.RARE)));
    public static final Item EXOTIC_SHOVEL = registerItem("overworld_exotic_shovel", new ShovelItem(ModToolMaterial.EXOTIC_OVERWORLD, 1.5F, -3.0F, new FabricItemSettings().group(ModItemGroups.TOOLS).rarity(Rarity.RARE)));
public static final Item EXOTIC_SWORD = registerItem("overworld_exotic_sword", new SwordItem(ModToolMaterial.EXOTIC_OVERWORLD, 3, -1.4F, new FabricItemSettings().group(ModItemGroups.TOOLS).rarity(Rarity.RARE)));
    public static final Item EXOTIC_HELMET = registerItem("overworld_exotic_helmet", new ModArmorItem(ModArmorMaterial.OVERWORLD_EXOTIC, EquipmentSlot.HEAD, 2, new FabricItemSettings().group(ModItemGroups.ARMOR).rarity(Rarity.RARE)));
    public static final Item EXOTIC_CHESTPLATE = registerItem("overworld_exotic_chestplate", new ArmorItem(ModArmorMaterial.OVERWORLD_EXOTIC, EquipmentSlot.CHEST, new FabricItemSettings().group(ModItemGroups.ARMOR).rarity(Rarity.RARE)));
    public static final Item EXOTIC_LEGGINGS = registerItem("overworld_exotic_leggings", new ArmorItem(ModArmorMaterial.OVERWORLD_EXOTIC, EquipmentSlot.LEGS, new FabricItemSettings().group(ModItemGroups.ARMOR).rarity(Rarity.RARE)));
    public static final Item EXOTIC_BOOTS = registerItem("overworld_exotic_boots", new ArmorItem(ModArmorMaterial.OVERWORLD_EXOTIC, EquipmentSlot.FEET, new FabricItemSettings().group(ModItemGroups.ARMOR).rarity(Rarity.RARE)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(FabricTest.MOD_ID, name), item);
    }

    public static void registerModItems() {
        FabricTest.LOGGER.info("Registering Mod Items for: " + FabricTest.MOD_DISPLAY_NAME);
    }

}

