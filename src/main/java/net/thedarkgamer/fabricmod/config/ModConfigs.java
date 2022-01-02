package net.thedarkgamer.fabricmod.config;

import com.mojang.datafixers.util.Pair;
import net.thedarkgamer.fabricmod.FabricTest;

public class ModConfigs {
    public static SimpleConfig CONFIG;
    private static ModConfigProvider configs;

    public static int EXOTIC_OVERWORLD_FULL_SET_DURATION;
    public static int EXOTIC_OVERWORLD_FULL_SET_AMPLIFIER;

    public static void registerConfigs() {
        configs = new ModConfigProvider();
        createConfigs();

        CONFIG = SimpleConfig.of(FabricTest.MOD_ID + "config").provider(configs).request();

        assignConfigs();
    }

    private static void createConfigs() {
        configs.addKeyValuePair(new Pair<>("armorStatuses.exotic.overworld.duration", 20), "duration in TICKS");
        configs.addKeyValuePair(new Pair<>("armorStatuses.exotic.overworld.amplifier", 1), "Effect level you want - 1");
    }

    private static void assignConfigs() {
        EXOTIC_OVERWORLD_FULL_SET_AMPLIFIER = CONFIG.getOrDefault("armorStatuses.exotic.overworld.amplifier", 1);
        EXOTIC_OVERWORLD_FULL_SET_DURATION = CONFIG.getOrDefault("armorStatuses.exotic.overworld.duration", 20);

        FabricTest.LOGGER.info("All " + configs.getConfigsList().size() + " configs have been set properly");
    }
}
