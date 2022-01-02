package net.thedarkgamer.fabricmod.util;

import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.thedarkgamer.fabricmod.command.ReturnHomeCommand;
import net.thedarkgamer.fabricmod.command.SetHomeCommand;

public class ModCommandRegister {
    public static void registerCommands() {
        CommandRegistrationCallback.EVENT.register(SetHomeCommand::register);
        CommandRegistrationCallback.EVENT.register(ReturnHomeCommand::register);
    }
}
