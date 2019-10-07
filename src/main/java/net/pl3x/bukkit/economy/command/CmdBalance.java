package net.pl3x.bukkit.economy.command;

import net.pl3x.bukkit.economy.EconomyPlugin;
import net.pl3x.bukkit.economy.EconomyProvider;
import net.pl3x.bukkit.economy.configuration.Lang;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CmdBalance implements TabExecutor {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1 && sender.hasPermission("command.balance.others")) {
            return Arrays.stream(Bukkit.getOfflinePlayers())
                    .filter(target -> target.getName().toLowerCase().startsWith(args[0].toLowerCase()))
                    .map(OfflinePlayer::getName)
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("command.balance")) {
            Lang.send(sender, Lang.COMMAND_NO_PERMISSION);
            return true;
        }

        EconomyProvider economy = EconomyPlugin.getProvider();

        OfflinePlayer target;

        if (args.length > 0) {
            target = Bukkit.getOfflinePlayer(args[0]);
        } else {
            if (!(sender instanceof Player)) {
                Lang.send(sender, Lang.PLAYER_COMMAND);
                return true;
            }
            target = (Player) sender;
        }

        if (target.getName() == null || !economy.hasAccount(target)) {
            Lang.send(sender, Lang.PLAYER_HAS_NO_ACCOUNT);
            return true;
        }

        double balance = economy.getBalance(target);
        Lang.send(sender, Lang.PLAYER_BALANCE
                .replace("{player}", target.getName())
                .replace("{balance}", economy.format(balance)));
        return true;
    }
}
