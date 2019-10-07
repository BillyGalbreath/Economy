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
    private static EconomyProvider provider;

    private VaultHook vaultHook;

    public EconomyPlugin() {
        instance = this;
    }

    public void onEnable() {
        Config.reload(this);
        Lang.reload(this);

        if (!getServer().getPluginManager().isPluginEnabled("Vault")) {
            getLogger().severe("Vault is a required dependency. Disabling " + getName());
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        provider = new EconomyProvider();

        vaultHook = new VaultHook();
        vaultHook.hook();

        getServer().getPluginManager().registerEvents(new BukkitListener(this), this);

        getCommand("economy").setExecutor(new CmdEconomy(this));
        getCommand("balance").setExecutor(new CmdBalance());
        getCommand("pay").setExecutor(new CmdPay());
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

    public static EconomyProvider getProvider() {
        return provider;
    }
}
