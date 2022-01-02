package net.thedarkgamer.fabricmod.util;

import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.thedarkgamer.fabricmod.events.PlayerEvents;

public class ModEventsRegister {
    public static void registerEvents() {
        ServerPlayerEvents.COPY_FROM.register(new PlayerEvents());
    }
}
