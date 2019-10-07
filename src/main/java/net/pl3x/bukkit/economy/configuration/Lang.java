package net.pl3x.bukkit.economy.configuration;

import com.google.common.base.Throwables;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

public class Lang {
    public static String COMMAND_NO_PERMISSION = "&4You do not have permission for that command!";
    public static String PLAYER_COMMAND = "&4This command is only available to players!";

    public static String EVENT_WAS_CANCELLED = "&4Event was cancelled";

    public static String MUST_SPECIFY_PLAYER = "&4Must specify a player";
    public static String PLAYER_HAS_NO_ACCOUNT = "&4Player has no account";

    public static String MUST_SPECIFY_AMOUNT = "&4Must specify an amount";
    public static String INVALID_AMOUNT = "&4Invalid amount specified";
    public static String AMOUNT_MUST_BE_POSITIVE = "&4Amount must be positive";

    public static String NOT_ENOUGH_FUNDS = "&4Not enough funds";

    public static String STARTING_AMOUNT_GIVEN = "&dYou have been given {amount} as a starting /balance";

    public static String PLAYER_BALANCE = "&d{player} Balance: {balance}";

    public static String PAID_PLAYER = "&dYou have paid {player} {amount}";

    private static void init() {
        COMMAND_NO_PERMISSION = getString("command-no-permission", COMMAND_NO_PERMISSION);
        PLAYER_COMMAND = getString("player-command", PLAYER_COMMAND);

        EVENT_WAS_CANCELLED = getString("event-was-cancelled", EVENT_WAS_CANCELLED);

        MUST_SPECIFY_PLAYER = getString("must-specify-player", MUST_SPECIFY_PLAYER);
        PLAYER_HAS_NO_ACCOUNT = getString("player-has-no-account", PLAYER_HAS_NO_ACCOUNT);

        MUST_SPECIFY_AMOUNT = getString("must-specify-amount", MUST_SPECIFY_AMOUNT);
        INVALID_AMOUNT = getString("invalid-amount", INVALID_AMOUNT);
        AMOUNT_MUST_BE_POSITIVE = getString("amount-must-be-positive", AMOUNT_MUST_BE_POSITIVE);

        NOT_ENOUGH_FUNDS = getString("not-enough-funds", NOT_ENOUGH_FUNDS);

        STARTING_AMOUNT_GIVEN = getString("starting-amount-given", STARTING_AMOUNT_GIVEN);

        PLAYER_BALANCE = getString("player-balance", PLAYER_BALANCE);

        PAID_PLAYER = getString("paid-player", PAID_PLAYER);
    }

    // ############################  DO NOT EDIT BELOW THIS LINE  ############################

    /**
     * Reload the language file
     */
    public static void reload(Plugin plugin) {
        File configFile = new File(plugin.getDataFolder(), Config.LANGUAGE_FILE);
        config = new YamlConfiguration();
        try {
            config.load(configFile);
        } catch (IOException ignore) {
        } catch (InvalidConfigurationException ex) {
            plugin.getLogger().log(Level.SEVERE, "Could not load " + Config.LANGUAGE_FILE + ", please correct your syntax errors", ex);
            throw Throwables.propagate(ex);
        }
        config.options().header("This is the main language file for " + plugin.getName());
        config.options().copyDefaults(true);

        Lang.init();

        try {
            config.save(configFile);
        } catch (IOException ex) {
            plugin.getLogger().log(Level.SEVERE, "Could not save " + configFile, ex);
        }
    }

    private static YamlConfiguration config;

    private static String getString(String path, String def) {
        config.addDefault(path, def);
        return config.getString(path, config.getString(path));
    }

    /**
     * Sends a message to a recipient
     *
     * @param recipient Recipient of message
     * @param message   Message to send
     */
    public static void send(CommandSender recipient, String message) {
        if (recipient != null) {
            for (String part : colorize(message).split("\n")) {
                recipient.sendMessage(part);
            }
        }
    }

    /**
     * Broadcast a message to server
     *
     * @param message Message to broadcast
     */
    public static void broadcast(String message) {
        for (String part : colorize(message).split("\n")) {
            Bukkit.getOnlinePlayers().forEach(recipient -> recipient.sendMessage(part));
            Bukkit.getConsoleSender().sendMessage(part);
        }
    }

    /**
     * Colorize a String
     *
     * @param str String to colorize
     * @return Colorized String
     */
    public static String colorize(String str) {
        if (str == null) {
            return "";
        }
        str = ChatColor.translateAlternateColorCodes('&', str);
        if (ChatColor.stripColor(str).isEmpty()) {
            return "";
        }
        return str;
    }
}
