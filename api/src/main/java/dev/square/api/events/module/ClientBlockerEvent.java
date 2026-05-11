package dev.square.api.events.module;

import dev.square.api.entity.SentryPlayer;
import lombok.Getter;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Getter
public class ClientBlockerEvent extends ModuleEvent {

    private static final HandlerList HANDLERS = new HandlerList();

    private final SentryPlayer sentryPlayer;
    private final @Nullable ClientEntry detected;

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }

    public ClientBlockerEvent(final SentryPlayer sentryPlayer, final @Nullable ClientEntry detected) {
        this.sentryPlayer = sentryPlayer;
        this.detected = detected;
    }
}
