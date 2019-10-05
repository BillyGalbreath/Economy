package net.pl3x.bukkit.economy;

import com.google.common.collect.ImmutableList;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;

import java.util.List;

public class EconomyProvider implements Economy {
    @Override
    public boolean isEnabled() {
        return EconomyPlugin.getInstance().isEnabled();
    }

    @Override
    public String getName() {
        return "Economy";
    }

    @Override
    public boolean hasBankSupport() {
        return false;
    }

    @Override
    public int fractionalDigits() {
        return 0; // TODO
    }

    @Override
    public String format(double v) {
        return null; // TODO
    }

    @Override
    public String currencyNamePlural() {
        return null; // TODO
    }

    @Override
    public String currencyNameSingular() {
        return null; // TODO
    }

    @Override
    @Deprecated
    public boolean hasAccount(String player) {
        return hasAccount(Bukkit.getOfflinePlayer(player));
    }

    @Override
    public boolean hasAccount(OfflinePlayer offlinePlayer) {
        return false; // TODO
    }

    @Override
    @Deprecated
    public boolean hasAccount(String player, String world) {
        return hasAccount(player);
    }

    @Override
    @Deprecated
    public boolean hasAccount(OfflinePlayer offlinePlayer, String world) {
        return hasAccount(offlinePlayer);
    }

    @Override
    @Deprecated
    public double getBalance(String player) {
        return getBalance(Bukkit.getOfflinePlayer(player));
    }

    @Override
    public double getBalance(OfflinePlayer offlinePlayer) {
        return 0; // TODO
    }

    @Override
    @Deprecated
    public double getBalance(String player, String world) {
        return getBalance(player);
    }

    @Override
    @Deprecated
    public double getBalance(OfflinePlayer offlinePlayer, String world) {
        return getBalance(offlinePlayer);
    }

    @Override
    @Deprecated
    public boolean has(String player, double amount) {
        return has(Bukkit.getOfflinePlayer(player), amount);
    }

    @Override
    public boolean has(OfflinePlayer offlinePlayer, double amount) {
        return false; // TODO
    }

    @Override
    @Deprecated
    public boolean has(String player, String world, double amount) {
        return has(player, amount);
    }

    @Override
    @Deprecated
    public boolean has(OfflinePlayer offlinePlayer, String world, double amount) {
        return has(offlinePlayer, amount);
    }

    @Override
    @Deprecated
    public EconomyResponse withdrawPlayer(String player, double amount) {
        return withdrawPlayer(Bukkit.getOfflinePlayer(player), amount);
    }

    @Override
    public EconomyResponse withdrawPlayer(OfflinePlayer offlinePlayer, double amount) {
        return null; // TODO
    }

    @Override
    @Deprecated
    public EconomyResponse withdrawPlayer(String player, String world, double amount) {
        return withdrawPlayer(player, amount);
    }

    @Override
    @Deprecated
    public EconomyResponse withdrawPlayer(OfflinePlayer offlinePlayer, String world, double amount) {
        return withdrawPlayer(offlinePlayer, amount);
    }

    @Override
    @Deprecated
    public EconomyResponse depositPlayer(String player, double amount) {
        return depositPlayer(Bukkit.getOfflinePlayer(player), amount);
    }

    @Override
    public EconomyResponse depositPlayer(OfflinePlayer offlinePlayer, double amount) {
        return null; // TODO
    }

    @Override
    @Deprecated
    public EconomyResponse depositPlayer(String player, String world, double amount) {
        return depositPlayer(player, amount);
    }

    @Override
    @Deprecated
    public EconomyResponse depositPlayer(OfflinePlayer offlinePlayer, String world, double amount) {
        return depositPlayer(offlinePlayer, amount);
    }

    @Override
    @Deprecated
    public EconomyResponse createBank(String s, String s1) {
        return new EconomyResponse(0, 0, EconomyResponse.ResponseType.NOT_IMPLEMENTED, null);
    }

    @Override
    @Deprecated
    public EconomyResponse createBank(String s, OfflinePlayer offlinePlayer) {
        return new EconomyResponse(0, 0, EconomyResponse.ResponseType.NOT_IMPLEMENTED, null);
    }

    @Override
    @Deprecated
    public EconomyResponse deleteBank(String s) {
        return new EconomyResponse(0, 0, EconomyResponse.ResponseType.NOT_IMPLEMENTED, null);
    }

    @Override
    @Deprecated
    public EconomyResponse bankBalance(String s) {
        return new EconomyResponse(0, 0, EconomyResponse.ResponseType.NOT_IMPLEMENTED, null);
    }

    @Override
    @Deprecated
    public EconomyResponse bankHas(String s, double v) {
        return new EconomyResponse(0, 0, EconomyResponse.ResponseType.NOT_IMPLEMENTED, null);
    }

    @Override
    @Deprecated
    public EconomyResponse bankWithdraw(String s, double v) {
        return new EconomyResponse(0, 0, EconomyResponse.ResponseType.NOT_IMPLEMENTED, null);
    }

    @Override
    @Deprecated
    public EconomyResponse bankDeposit(String s, double v) {
        return new EconomyResponse(0, 0, EconomyResponse.ResponseType.NOT_IMPLEMENTED, null);
    }

    @Override
    @Deprecated
    public EconomyResponse isBankOwner(String s, String s1) {
        return new EconomyResponse(0, 0, EconomyResponse.ResponseType.NOT_IMPLEMENTED, null);
    }

    @Override
    @Deprecated
    public EconomyResponse isBankOwner(String s, OfflinePlayer offlinePlayer) {
        return new EconomyResponse(0, 0, EconomyResponse.ResponseType.NOT_IMPLEMENTED, null);
    }

    @Override
    @Deprecated
    public EconomyResponse isBankMember(String s, String s1) {
        return new EconomyResponse(0, 0, EconomyResponse.ResponseType.NOT_IMPLEMENTED, null);
    }

    @Override
    @Deprecated
    public EconomyResponse isBankMember(String s, OfflinePlayer offlinePlayer) {
        return new EconomyResponse(0, 0, EconomyResponse.ResponseType.NOT_IMPLEMENTED, null);
    }

    @Override
    @Deprecated
    public List<String> getBanks() {
        return ImmutableList.of();
    }

    @Override
    @Deprecated
    public boolean createPlayerAccount(String player) {
        return createPlayerAccount(Bukkit.getOfflinePlayer(player));
    }

    @Override
    public boolean createPlayerAccount(OfflinePlayer offlinePlayer) {
        return true; // TODO
    }

    @Override
    @Deprecated
    public boolean createPlayerAccount(String player, String world) {
        return createPlayerAccount(player);
    }

    @Override
    @Deprecated
    public boolean createPlayerAccount(OfflinePlayer offlinePlayer, String world) {
        return createPlayerAccount(offlinePlayer);
    }
}
