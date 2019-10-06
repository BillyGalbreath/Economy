package net.pl3x.bukkit.economy.vault;

import net.milkbowl.vault.economy.Economy;
import net.pl3x.bukkit.economy.EconomyPlugin;
import org.bukkit.Bukkit;
import org.bukkit.plugin.ServicePriority;

public class VaultHook {
    public void hook() {
        Bukkit.getServicesManager().register(Economy.class, EconomyPlugin.getProvider(), EconomyPlugin.getInstance(), ServicePriority.Normal);
        EconomyPlugin.getInstance().getLogger().info("Hooked into Vault");
    }

    public void unhook() {
        Bukkit.getServicesManager().unregister(Economy.class, EconomyPlugin.getProvider());
        EconomyPlugin.getInstance().getLogger().info("Unhooked from Vault");
    }
}
