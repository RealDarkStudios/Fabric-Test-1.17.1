package net.thedarkgamer.fabricmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.thedarkgamer.fabricmod.block.ModBlocks;
import net.thedarkgamer.fabricmod.block.custom.ModDoorBlock;
import net.thedarkgamer.fabricmod.item.ModItems;
import net.thedarkgamer.fabricmod.registries.ModRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FabricTest implements ModInitializer {
	public static final String MOD_ID = "fabricmod";
	private static final String s1 = FabricTest.MOD_ID.substring(0, 1).toUpperCase();
	private static final String s2 = FabricTest.MOD_ID.substring(6, 7).toUpperCase();
	public static final String MOD_DISPLAY_NAME = s1 + MOD_ID.substring(1, 6) + s2 + MOD_ID.substring(7);
	public static final Logger LOGGER = LogManager.getLogger(MOD_DISPLAY_NAME);

	@Override
	public void onInitialize() {
		LOGGER.info("Loading mod: " + MOD_DISPLAY_NAME);

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModRegistries.registerModFuels();

		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.OVERWORLD_EXOTIC_DOOR, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.OVERWORLD_EXOTIC_TRAPDOOR, RenderLayer.getCutout());
	}
}
