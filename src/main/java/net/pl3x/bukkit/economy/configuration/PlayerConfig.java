package net.pl3x.bukkit.economy.configuration;

import net.pl3x.bukkit.economy.EconomyPlugin;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class PlayerConfig extends YamlConfiguration {
    private static final Map<OfflinePlayer, PlayerConfig> configs = new HashMap<>();

    public static PlayerConfig getConfig(OfflinePlayer player) {
        synchronized (configs) {
            return configs.computeIfAbsent(player, k -> new PlayerConfig(player));
        }
    }

    public static void unload(OfflinePlayer player) {
        synchronized (configs) {
            configs.remove(player);
        }
    }

    public static void unloadAll() {
        synchronized (configs) {
            configs.clear();
        }
    }

    private final File file;
    private final Object saveLock = new Object();

    private PlayerConfig(OfflinePlayer player) {
        super();
        this.file = new File(EconomyPlugin.getInstance().getDataFolder(),
                "userdata" + File.separator + player.getUniqueId() + ".yml");
        reload();
    }

    private void reload() {
        synchronized (saveLock) {
            try {
                load(file);
            } catch (Exception ignore) {
            }
        }
    }

    private void save() {
        synchronized (saveLock) {
            try {
                save(file);
            } catch (Exception ignore) {
            }
        }
    }
}
