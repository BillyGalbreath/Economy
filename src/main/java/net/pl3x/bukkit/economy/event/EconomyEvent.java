package net.pl3x.bukkit.economy.event;

import org.bukkit.OfflinePlayer;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;

public abstract class EconomyEvent extends Event implements Cancellable {
    private boolean cancel = false;
    private final OfflinePlayer player;

    public EconomyEvent(OfflinePlayer player) {
        this.player = player;
    }

    public OfflinePlayer getPlayer() {
        return player;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean b) {
        this.cancel = true;
    }
}
