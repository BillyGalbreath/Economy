package net.pl3x.bukkit.economy;

import net.pl3x.bukkit.economy.command.CmdBalance;
import net.pl3x.bukkit.economy.command.CmdEconomy;
import net.pl3x.bukkit.economy.command.CmdPay;
import net.pl3x.bukkit.economy.configuration.Config;
import net.pl3x.bukkit.economy.configuration.Lang;
import net.pl3x.bukkit.economy.configuration.PlayerConfig;
import net.pl3x.bukkit.economy.listener.BukkitListener;
import net.pl3x.bukkit.economy.vault.VaultHook;
import org.bukkit.plugin.java.JavaPlugin;

public class EconomyPlugin extends JavaPlugin {
    private static EconomyPlugin instance;

    private VaultHook vaultHook;

    public EconomyPlugin() {
        instance = this;
    }

    public void onEnable() {
        Config.reload(this);
        Lang.reload(this);

        vaultHook = new VaultHook(this);

        getServer().getPluginManager().registerEvents(new BukkitListener(), this);

        getCommand("economy").setExecutor(new CmdEconomy(this));
        getCommand("balance").setExecutor(new CmdBalance(this));
        getCommand("pay").setExecutor(new CmdPay(this));
    }

    public void onDisable() {
        if (vaultHook != null) {
            vaultHook.unhook();
            vaultHook = null;
        }

        PlayerConfig.unloadAll();
    }

    public static EconomyPlugin getInstance() {
        return instance;
    }
}
