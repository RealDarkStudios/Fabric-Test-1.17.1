package net.thedarkgamer.fabricmod.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.thedarkgamer.fabricmod.FabricTest;
import org.lwjgl.system.CallbackI;

public class ModEnchantments {

    public static Enchantment BOLT = register("bolt", new BoltEnchantment(Enchantment.Rarity.UNCOMMON, EnchantmentTarget.WEAPON, EquipmentSlot.MAINHAND));

    private static Enchantment register(String name, Enchantment enchantment) {
        return Registry.register(Registry.ENCHANTMENT, new Identifier(FabricTest.MOD_ID, name), enchantment);
    }

    public static void registerModEnchantments() {
        FabricTest.LOGGER.info("Registering Mod Enchantments for: " + FabricTest.MOD_DISPLAY_NAME);
    }

}
