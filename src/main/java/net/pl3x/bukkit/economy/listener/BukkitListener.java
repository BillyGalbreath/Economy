package net.pl3x.bukkit.economy.listener;

import net.pl3x.bukkit.economy.EconomyPlugin;
import net.pl3x.bukkit.economy.configuration.PlayerConfig;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class BukkitListener implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerJoin(PlayerJoinEvent event) {
        EconomyPlugin.getProvider().createPlayerAccount(event.getPlayer());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerQuit(PlayerQuitEvent event) {
        PlayerConfig.unload(event.getPlayer());
    }
}
