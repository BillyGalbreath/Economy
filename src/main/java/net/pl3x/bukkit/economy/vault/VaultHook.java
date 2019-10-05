package net.pl3x.bukkit.economy.vault;

import net.milkbowl.vault.economy.Economy;
import net.pl3x.bukkit.economy.EconomyPlugin;
import org.bukkit.Bukkit;
import org.bukkit.plugin.ServicePriority;

public class VaultHook {
    private final EconomyPlugin plugin;
    private Economy provider;

    public VaultHook(EconomyPlugin plugin) {
        this.plugin = plugin;
    }

    public void hook() {
        Bukkit.getServicesManager().register(Economy.class, this.provider, this.plugin, ServicePriority.Normal);
        plugin.getLogger().info("Hooked into Vault");
    }

    public void unhook() {
        Bukkit.getServicesManager().unregister(Economy.class, this.provider);
        plugin.getLogger().info("Unhooked from Vault");
    }
}
