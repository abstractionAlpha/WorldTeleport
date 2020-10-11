package com.abstractionalpha.minecraft.plugins.worldteleport;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class WorldTeleport extends JavaPlugin {

    DoTeleport doTeleport;

    /**
     * Plugin start-up logic.
     */
    @Override
    public void onEnable() {
        doTeleport = new DoTeleport(this);
        getServer().getPluginManager().registerEvents(doTeleport, this);
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
                    doTeleport.SelfTeleport(sender, args);
                    break;
                case 5:
                    // Player teleport
                    break;
                default:
                    sender.sendMessage("Args length: " + args.length);
                    break;
            }
        }

        return true;

    }
}
