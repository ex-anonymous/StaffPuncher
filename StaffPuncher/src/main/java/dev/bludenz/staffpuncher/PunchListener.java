package dev.bludenz.staffpuncher;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import java.util.HashMap;
import java.util.UUID;

public class PunchListener implements Listener {
    public static HashMap<UUID, Boolean> punchable = new HashMap<>();

    @EventHandler
    public void playerPunch(PlayerInteractEntityEvent e) {
        Player p = e.getPlayer();
        Player staff = (Player) e.getRightClicked();

        if (staff.getType() == EntityType.PLAYER && p.getItemInHand().getType() == Material.AIR && staff.hasPermission("group.mod")) {
            if (punchable.get(staff.getUniqueId()) == true) {
                Location loc = staff.getLocation().add(0,10,0);
                staff.teleport(loc);
                staff.setVelocity(staff.getLocation().getDirection().setY(0.5));
                Bukkit.broadcastMessage(staff.getDisplayName() + " §awas §d§lPUNCHED §r§ainto the air by " + p.getDisplayName());
            } else if (punchable.get(staff.getUniqueId()) == false) {
                p.sendMessage("§aThat player is not punchable right now!");
            } else {
                p.sendMessage("§aThat player is not a staff member.");
            }

        }

    }
    @EventHandler
    public void staffPunch(PlayerInteractEntityEvent e) {
        Player staff = e.getPlayer();
        Player player = (Player) e.getRightClicked();

        if (player.getType() == EntityType.PLAYER && staff.getItemInHand().getType() == Material.AIR && staff.hasPermission("group.mod")) {
            if (punchable.get(player.getUniqueId()) == true) {
                Location loc = player.getLocation().add(0,10,0);
                player.teleport(loc);
                player.setVelocity(player.getLocation().getDirection().setY(0.5));
                Bukkit.broadcastMessage(player.getDisplayName() + " §awas §d§lPUNCHED §r§ainto the air by " + staff.getDisplayName());
            } else if (punchable.get(staff.getUniqueId()) == false) {
                staff.sendMessage("§aThat player is not punchable right now!");
            }

        }

    }
}
