package dev.square.api;

import dev.square.api.events.EventBus;
import dev.square.api.events.module.AntiVPNCheckEvent;
import dev.square.api.events.module.ClientBlockerEvent;
import dev.square.api.manager.IPlayerManager;
import lombok.Getter;
import lombok.Setter;

public class SentryAPI {
    private static @Getter @Setter EventBus eventBus;
    private static @Setter IPlayerManager playerManager;

    public static IPlayerManager getPlayerManager() {
        if (playerManager == null) {
            throw new IllegalStateException("SentryAPI is not initialized yet!");
        }
        return playerManager;
    }
}