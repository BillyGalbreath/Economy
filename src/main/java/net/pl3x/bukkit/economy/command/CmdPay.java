package net.pl3x.bukkit.economy.command;

import net.milkbowl.vault.economy.EconomyResponse;
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

public class CmdPay implements TabExecutor {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1 && sender.hasPermission("command.pay")) {
            return Arrays.stream(Bukkit.getOfflinePlayers())
                    .filter(target -> target.getName().toLowerCase().startsWith(args[0].toLowerCase()))
                    .map(OfflinePlayer::getName)
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            Lang.send(sender, Lang.PLAYER_COMMAND);
            return true;
        }

        if (!sender.hasPermission("command.pay")) {
            Lang.send(sender, Lang.COMMAND_NO_PERMISSION);
            return true;
        }

        if (args.length < 1) {
            Lang.send(sender, Lang.MUST_SPECIFY_PLAYER);
            return true;
        }

        if (args.length < 2) {
            Lang.send(sender, Lang.MUST_SPECIFY_AMOUNT);
            return true;
        }

        EconomyProvider economy = EconomyPlugin.getProvider();

        OfflinePlayer target = Bukkit.getOfflinePlayer(args[0]);
        if (target.getName() == null || !economy.hasAccount(target)) {
            Lang.send(sender, Lang.PLAYER_HAS_NO_ACCOUNT);
            return true;
        }

        double amount;
        try {
            amount = Double.parseDouble(args[1]);
        } catch (NumberFormatException e) {
            Lang.send(sender, Lang.INVALID_AMOUNT);
            return true;
        }

        EconomyResponse withdraw = economy.withdrawPlayer((Player) sender, amount);
        if (!withdraw.transactionSuccess()) {
            Lang.send(sender, withdraw.errorMessage);
            return true;
        }

        EconomyResponse deposit = economy.depositPlayer(target, amount);
        if (!deposit.transactionSuccess()) {
            Lang.send(sender, deposit.errorMessage);
            return true;
        }

        Lang.send(sender, Lang.PAID_PLAYER
                .replace("{player}", target.getName())
                .replace("{amount}", economy.format(amount)));
        return true;
    }
}
