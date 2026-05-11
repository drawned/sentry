package dev.square.api.events.module;

import dev.square.api.entity.SentryPlayer;
import lombok.Getter;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * This even triggers everytime the HackBlocker module:
 * - Starts checking a player (Cancelling the event will stop all future checks for this player)
 * - Just checked a player (Cancelling the event will cancel all Sentry actions for this player)
 * - Ended all checks for a player (Cancelling is not possible, get all results through the {@link SentryPlayer} class.)
 * Check the {@link HackBlockerPhase} phase to get more details.
 * ClientEntry is only valid ant not null when the phase ({@link HackBlockerPhase}) is TRIGGER.
 */
@Getter
public class HackBlockerEvent extends ModuleEvent {

    private static final HandlerList HANDLERS = new HandlerList();

    private final SentryPlayer sentryPlayer;
    private final @Nullable ClientEntry detected;
    private final HackBlockerPhase phase;

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
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

    public HackBlockerEvent(final SentryPlayer sentryPlayer, final @Nullable ClientEntry detected,
                            final HackBlockerPhase phase) {
        this.sentryPlayer = sentryPlayer;
        this.detected = detected;
        this.phase = phase;
    }
}
