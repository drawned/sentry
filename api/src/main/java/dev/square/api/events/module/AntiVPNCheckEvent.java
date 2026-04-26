package dev.square.api.events.module;

import dev.square.api.entity.SentryPlayer;
import lombok.Getter;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * This event triggers when a player gets checked by the Anti-VPN module,
 * Check the ConnectionType to be able to distinguish if the player is indeed using a VPN/Proxy.
 */
@Getter
public class AntiVPNCheckEvent extends ModuleEvent {
    private static final HandlerList HANDLERS = new HandlerList();

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    private final SentryPlayer sentryPlayer;
    private final ConnectionType connectionType;

    public AntiVPNCheckEvent(SentryPlayer sentryPlayer, ConnectionType connectionType) {
        this.sentryPlayer = sentryPlayer;
        this.connectionType = connectionType;
    }

    /**
     * Returns if this player is using a VPN/Proxy or even both at the same time.
     * @return boolean that if false = player is not using anything
     */
    public boolean isUsing() {
        return this.connectionType != ConnectionType.NOT_USING;
    }

    public enum ConnectionType {
        PROXY("Proxy"),
        VPN("VPN"),
        ALL("VPN & Proxy"),
        NOT_USING("Not using");

        public final String description;

        ConnectionType(String description) {
            this.description = description;
        }
    }
}