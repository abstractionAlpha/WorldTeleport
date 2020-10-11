package com.abstractionalpha.minecraft.plugins.worldteleport;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class DoTeleport implements Listener {

    private final WorldTeleport worldTeleport;

    public DoTeleport(WorldTeleport worldTeleport) {
        this.worldTeleport = worldTeleport;
    }

    public Boolean SelfTeleport(CommandSender sender, String[] args) {
        String worldName = args[0];
        int x;
        int y;
        int z;

        Player player;
        World world;

        try {
            x = Integer.parseInt(args[1]);
            y = Integer.parseInt(args[2]);
            z = Integer.parseInt(args[3]);
        } catch (IllegalArgumentException e) {
            sender.sendMessage(ChatColor.RED + "[WorldTeleport] Expected integer for coordinates.");
            return false;
        }

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "[WorldTeleport] Must be player to teleport!");
            return false;
        }

        try {
            player = worldTeleport.getServer().getPlayer(sender.getName());
        } catch (IllegalArgumentException e) {
            sender.sendMessage(ChatColor.RED + "[WorldTeleport] Unable to locate player to teleport.");
            return false;
        }

        try {
            world = worldTeleport.getServer().getWorld(worldName);
        } catch (IllegalArgumentException e) {
            sender.sendMessage(ChatColor.RED + "[WorldTeleport] World" + worldName + " not found.");
            return false;
        }

        if (world == null) {
            sender.sendMessage(ChatColor.RED + "[WorldTeleport] World " + worldName + " not found.");
            return false;
        }

        sender.sendMessage(world + " " + x + " " + y + " " + z);

        Location location = new Location(world, x, y, z);

        player.sendMessage(ChatColor.GREEN + "Teleporting...");

        player.teleport(location);

        return true;
    }

    public void PlayerTp(String[] args) {
        // Command functionality
    }

}
