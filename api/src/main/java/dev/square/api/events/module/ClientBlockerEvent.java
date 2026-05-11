package dev.square.api.events.module;

import dev.square.api.entity.SentryPlayer;
import lombok.Getter;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * This even triggers everytime the Client Blocker module checks a player,
 * check the {@link ClientEntry} result to get useful information about the detected mod/client.
 * Cancelling the event will cancel all Sentry actions for the player, however the check
 * will still happen and will still be logged.
 */
@Getter
public class ClientBlockerEvent extends ModuleEvent {

    private static final HandlerList HANDLERS = new HandlerList();

    private final SentryPlayer sentryPlayer;
    private final @NotNull ClientEntry detected;

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }

    public ClientBlockerEvent(final SentryPlayer sentryPlayer, final @NotNull ClientEntry detected) {
        this.sentryPlayer = sentryPlayer;
        this.detected = detected;
    }
}
