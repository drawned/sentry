package dev.square.api.manager;

import dev.square.api.entity.SentryPlayer;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

/**
 * Manager class to handle {@link SentryPlayer} instances.
 * This class is used by Sentry to handle (create, remove, update)
 * players automatically.
 * <p>
 * If you are looking to retrieve a player instance, use {@link #get(UUID)} or {@link #find(UUID)}
 *
 * @see SentryPlayer
 */
public interface IPlayerManager {
    /**
     * Gets all registered {@link SentryPlayer} instances.
     */
    Collection<SentryPlayer> getSentryPlayers();

    /**
     * Finds a {@link SentryPlayer} by {@link UUID}.
     */
    SentryPlayer get(UUID uuid);

    /**
     * Finds a {@link SentryPlayer} using {@link Optional} for safety.
     */
    Optional<SentryPlayer> find(UUID uuid);
}