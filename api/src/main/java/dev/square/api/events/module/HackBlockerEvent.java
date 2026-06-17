package dev.square.api.events.module;

import dev.square.api.entity.SentryPlayer;
import dev.square.api.events.SentryEvent;
import lombok.Getter;

/**
 * This even triggers everytime the HackBlocker module:
 * - Starts checking a player (Cancelling the event will stop all future checks for this player)
 * - Just checked a player (Cancelling the event will cancel all Sentry actions for this player)
 * - Ended all checks for a player (Cancelling is not possible, get all results through the {@link SentryPlayer} class.)
 * Check the {@link HackBlockerEvent.HackBlockerPhase} phase to get more details.
 * ClientEntry is only valid ant not null when the phase ({@link HackBlockerEvent.HackBlockerPhase}) is TRIGGER.
 */
public class HackBlockerEvent implements SentryEvent.CancellableSentryEvent {

    private final @Getter SentryPlayer sentryPlayer;
    private final @Getter ClientEntry detected;
    private final @Getter HackBlockerPhase phase;

    private boolean cancelled = false;

    @Override public boolean isCancelled() { return cancelled; }
    @Override public void setCancelled(boolean cancel) { this.cancelled = cancel; }

    public HackBlockerEvent(SentryPlayer sentryPlayer, ClientEntry detected, HackBlockerPhase phase) {
        this.sentryPlayer = sentryPlayer;
        this.detected = detected;
        this.phase = phase;
    }

    /**
     * Event Phase of the verification process for {@link HackBlockerEvent}
     */
    public enum HackBlockerPhase {
        /** Initial phase. Cancelling the event also cancels all future checks for the player. */
        STARTING,
        /** Triggered after each individual check. */
        TRIGGER,
        /** Final phase. All detections are available through the {@link dev.square.api.entity.SentryPlayer} class. */
        END
    }
}
