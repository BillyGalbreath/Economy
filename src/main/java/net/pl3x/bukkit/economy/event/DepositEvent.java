package net.pl3x.bukkit.economy.event;

import org.bukkit.OfflinePlayer;
import org.bukkit.event.HandlerList;

public class DepositEvent extends EconomyEvent {
    private static final HandlerList handlers = new HandlerList();
    private final double balance;
    private double amount;

    public DepositEvent(OfflinePlayer player, double balance, double amount) {
        super(player);
        this.balance = balance;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getBalance() {
        return balance;
    }

    public double getNewBalance() {
        return balance + amount;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
