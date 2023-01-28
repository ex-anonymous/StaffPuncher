package dev.bludenz.staffpuncher;

import org.bukkit.plugin.java.JavaPlugin;

public final class Staffpuncher extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new PunchListener(), this);
        getServer().getPluginManager().registerEvents(new JoinListener(), this);

        getCommand("punchon").setExecutor(new PunchOn());
        getCommand("punchoff").setExecutor(new PunchOff());
        getCommand("punchstate").setExecutor(new SetPunchState());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
