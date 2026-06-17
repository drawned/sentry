package dev.square.api.events.module;

import dev.square.api.entity.SentryPlayer;
import dev.square.api.events.SentryEvent;
import lombok.Getter;

/**
 * This even triggers everytime the Client Blocker module checks a player,
 * check the {@link ClientEntry} result to get useful information about the detected mod/client.
 * Cancelling the event will cancel all Sentry actions for the player, however the check
 * will still happen and will still be logged.
 */
public class ClientBlockerEvent implements SentryEvent.CancellableSentryEvent {

    private final @Getter SentryPlayer sentryPlayer;
    private final @Getter ClientEntry detected;

    private boolean cancelled = false;

    @Override public boolean isCancelled() { return cancelled; }
    @Override public void setCancelled(boolean cancel) { this.cancelled = cancel; }

    public ClientBlockerEvent(final SentryPlayer sentryPlayer, final ClientEntry detected) {
        this.sentryPlayer = sentryPlayer;
        this.detected = detected;
    }
}
