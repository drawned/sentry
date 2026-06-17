package dev.square.api.entity;

import dev.square.api.manager.IPlayerManager;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Handles Sentry-controlled players, you can
 * get the relative Player by using the UUID {@link #getUniqueId()}
 * <p>
 * You can get a SentryPlayer class using the Manager:
 * {@link IPlayerManager}
 *
 * @see IPlayerManager
 */
@Getter
public class SentryPlayer {
    private final UUID uniqueId;
    private final List<String> clients;
    private final List<String> hacks;

    public SentryPlayer(UUID uuid) {
        this.uniqueId = uuid;
        this.clients = new ArrayList<>();
        this.hacks = new ArrayList<>();
    }
}