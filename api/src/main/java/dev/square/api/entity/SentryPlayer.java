package dev.square.api.entity;

import dev.square.api.manager.IPlayerManager;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Handles Sentry-controlled players, you can
 * get the Spigot player by using {@link #getSpigotPlayer}
 * <p>
 * You can get a SentryPlayer class using the Manager:
 * {@link IPlayerManager}
 *
 * @see IPlayerManager
 */
@Getter
public class SentryPlayer {
    private final UUID uuid;
    private final List<String> clients;
    private final List<String> hacks;

    public SentryPlayer(UUID uuid) {
        this.uuid = uuid;
        this.clients = new ArrayList<>();
        this.hacks = new ArrayList<>();
    }

    @Nullable
    public Player getSpigotPlayer() {
        return Bukkit.getPlayer(this.uuid);
    }
}