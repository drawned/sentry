package dev.square.api.manager;

import dev.square.api.entity.SentryPlayer;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

/**
 * Manager class to handle {@link SentryPlayer} instances.
 * This class is used by Sentry to handle (create, remove, update)
 * players automatically.
 * <p>
 * If you are looking to retrieve a player instance, use the {@link #get(Player)}
 * or {@link #get(UUID)} methods.
 *
 * @see SentryPlayer
 */
public interface IPlayerManager {
    /**
     * Gets all registered {@link SentryPlayer} instances.
     */
    Collection<SentryPlayer> getSentryPlayers();

    /**
     * Finds a {@link SentryPlayer} by the bukkit {@link Player}.
     */
    SentryPlayer get(Player player);

    /**
     * Finds a {@link SentryPlayer} by {@link UUID}.
     */
    SentryPlayer get(UUID uuid);

    /**
     * Finds a {@link SentryPlayer} using {@link Optional} for safety.
     */
    Optional<SentryPlayer> find(Player player);
}