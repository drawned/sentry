package dev.square.api.events.module;

import dev.square.api.entity.SentryPlayer;
import lombok.Getter;
import org.bukkit.entity.Player;

/**
 * This event triggers when a player gets checked by the Anti-VPN module,
 * Check the ConnectionType to be able to distinguish if the player is indeed using a VPN/Proxy.
 */
@Getter
public class AntiVPNCheckEvent extends ModuleEvent {
    private final SentryPlayer sentryPlayer;
    private final ConnectionType connectionType;

    public AntiVPNCheckEvent(SentryPlayer sentryPlayer, ConnectionType connectionType) {
        this.sentryPlayer = sentryPlayer;
        this.connectionType = connectionType;
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