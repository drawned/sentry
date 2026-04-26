package dev.square.api.events.module;

import dev.square.api.entity.SentryPlayer;
import lombok.Getter;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@Getter
public class ClientTriggerEvent extends ModuleEvent {
    private static final HandlerList HANDLERS = new HandlerList();

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    private final SentryPlayer sentryPlayer;
    private final String clientName;
    private final String clientId;
    private final ModuleType moduleType;

    public ClientTriggerEvent(final SentryPlayer sentryPlayer, final String clientName, final String clientId, final ModuleType type) {
        this.sentryPlayer = sentryPlayer;
        this.clientName = clientName;
        this.clientId = clientId;
        this.moduleType = type;
    }

    public enum ModuleType {
        CLIENT_BLOCKER, HACK_BLOCKER
    }
}
