package dev.bludenz.staffpuncher;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PunchOn implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        PunchListener.punchable.remove(p.getUniqueId());
        PunchListener.punchable.put(p.getUniqueId(), true);
        p.sendMessage("§aYou are punchable now!");
        return true;
    }
}
