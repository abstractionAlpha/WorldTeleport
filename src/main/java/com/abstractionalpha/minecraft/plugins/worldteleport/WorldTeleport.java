package com.abstractionalpha.minecraft.plugins.worldteleport;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class WorldTeleport extends JavaPlugin {

    /**
     * Plugin start-up logic.
     */
    @Override
    public void onEnable() {
        // Plugin startup logic

    }

    /**
     * Plugin shut-down logic.
     */
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("tpw")) {
            // tpw <world> <x> <y> <z>
            // tpw <usr> <world> <x> <y> <z>

            switch(args.length) {
                case 4:
                    sender.sendMessage("tpw <world> <x> <y> <z>");
                    break;
                case 5:
                    sender.sendMessage("tpw <usr> <world> <x> <y> <z>");
                    break;
                default:
                    sender.sendMessage("Args length: " + args.length);
                    break;
            }
        }

        return true;

    }
}
