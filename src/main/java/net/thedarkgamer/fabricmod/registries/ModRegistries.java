package net.thedarkgamer.fabricmod.registries;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.thedarkgamer.fabricmod.FabricTest;
import net.thedarkgamer.fabricmod.item.ModItems;

public class ModRegistries {

    public static void registerModFuels() {
        FabricTest.LOGGER.info("Registering Mod Fuels for: " + FabricTest.MOD_DISPLAY_NAME);
        FuelRegistry registry = FuelRegistry.INSTANCE;

        registry.add(ModItems.EXOTIC_MATTER, 3200);
    }
}
