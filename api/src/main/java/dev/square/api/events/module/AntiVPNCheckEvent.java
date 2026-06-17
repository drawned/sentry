package dev.square.api.events.module;

import dev.square.api.entity.SentryPlayer;
import dev.square.api.events.SentryEvent;
import lombok.Getter;

/**
 * This event triggers when a player gets checked by the Anti-VPN module,
 * Check the ConnectionType to be able to distinguish if the player is indeed using a VPN/Proxy.
 */
public class AntiVPNCheckEvent implements SentryEvent.CancellableSentryEvent {

    private final @Getter SentryPlayer sentryPlayer;
    private final @Getter ConnectionType connectionType;

    private boolean cancelled = false;

    public AntiVPNCheckEvent(SentryPlayer sentryPlayer, ConnectionType connectionType) {
        this.sentryPlayer = sentryPlayer;
        this.connectionType = connectionType;
    }

    @Override public boolean isCancelled() { return cancelled; }
    @Override public void setCancelled(boolean cancel) { this.cancelled = cancel; }

    public static enum ConnectionType {
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
