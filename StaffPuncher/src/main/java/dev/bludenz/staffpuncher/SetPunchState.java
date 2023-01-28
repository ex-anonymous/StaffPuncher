package dev.bludenz.staffpuncher;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetPunchState implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("group.admin")) {
            if (args.length == 0) {
                sender.sendMessage("§cYou need to provide more arguments!");
            } else if (args.length == 1) {
                sender.sendMessage("§cYou need to provide more arguments!");
            } else if (args.length == 2) {
                String playerName = args[0];
                if (args[1].equalsIgnoreCase("yes") || args[1].equalsIgnoreCase("true") || args[1].equalsIgnoreCase("on")) {
                    Player target = Bukkit.getPlayer(playerName);
                    PunchListener.punchable.put(target.getUniqueId(), true);
                    sender.sendMessage("§aYou set " + playerName + "'s punch state to &3&lTRUE!");
                    return true;
                }
                if (args[1].equalsIgnoreCase("no") || args[1].equalsIgnoreCase("false") || args[1].equalsIgnoreCase("off")) {
                    Player target = Bukkit.getPlayer(playerName);
                    PunchListener.punchable.put(target.getUniqueId(), false);
                    sender.sendMessage("§aYou set " + playerName + "'s punch state to &3&lFALSE!");
                    return true;
                }

            }

        }
        return false;
    }
}

