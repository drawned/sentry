package dev.square.api;

import dev.square.api.manager.IPlayerManager;
import lombok.Setter;

public class SentryAPI {

    @Setter
    private static IPlayerManager playerManager;

    public static IPlayerManager getPlayerManager() {
        if (playerManager == null) {
            throw new IllegalStateException("SentryAPI is not initialized yet!");
        }
        return playerManager;
    }

}
