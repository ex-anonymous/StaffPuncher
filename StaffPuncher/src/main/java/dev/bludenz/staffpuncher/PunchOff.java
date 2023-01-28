package dev.bludenz.staffpuncher;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PunchOff implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;

        PunchListener.punchable.remove(p.getUniqueId());
        PunchListener.punchable.put(p.getUniqueId(), false);
        p.sendMessage("§aYou aren't punchable now!");
        return true;
    }
}
