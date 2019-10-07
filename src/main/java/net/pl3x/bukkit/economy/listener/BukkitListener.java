package net.pl3x.bukkit.economy.listener;

import net.pl3x.bukkit.economy.EconomyPlugin;
import net.pl3x.bukkit.economy.configuration.PlayerConfig;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class BukkitListener implements Listener {
    private final EconomyPlugin plugin;

    public BukkitListener(EconomyPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerJoin(PlayerJoinEvent event) {
        new BukkitRunnable() {
            @Override
            public void run() {
                EconomyPlugin.getProvider().createPlayerAccount(event.getPlayer());
            }
        }.runTaskLater(plugin, 20);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerQuit(PlayerQuitEvent event) {
        PlayerConfig.unload(event.getPlayer());
    }
}
