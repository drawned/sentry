# Sentry

Sentry is an all-in-one **server security** solution designed to protect your Minecraft server from common threats. It includes protection against unauthorized client modifications, hacked clients, malicious bots, VPN/Proxy connections, crash-items, and more!

### Downloading
- [SpigotMC](https://www.spigotmc.org/resources/102233/)
- [Modrinth](https://modrinth.com/plugin/sentry-plugin)

### Documentation (Wiki)
You can access the plugin's official documentation using this link: 
https://squareplugins.gitbook.io/sentry

---

## Developer API

Sentry provides an API for developers who need to interact with player security data, check for active detections, or manage player sessions programmatically.

To use the Sentry API in your project, add the JitPack repository and the dependency to your build configuration.

Replace `LATEST` with the latest stable API [release from here](https://github.com/drawned/sentry/releases/latest).

### Gradle (build.gradle)

Add the JitPack repository to your `repositories` block, and the dependency to your `dependencies` block:

```gradle
repositories {
    maven { url = 'https://jitpack.io' }
}

dependencies {
    compileOnly 'com.github.drawned.sentry:api:LATEST'
}
```

### Maven (pom.xml)

Add the JitPack repository to your `repositories` block, and the dependency to your `dependencies` block:

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>com.github.drawned.sentry</groupId>
        <artifactId>api</artifactId>
        <version>LATEST</version>
        <scope>provided</scope>
    </dependency>
</dependencies>
```

---

### Usage

You can access the main management interface through the [SentryAPI](https://github.com/drawned/sentry/blob/master/api/src/main/java/dev/square/api/SentryAPI.java) class.

Example to retrieve a player's security instance:

```java
import dev.square.api.SentryAPI;
import dev.square.api.entity.SentryPlayer;

// Retrieving a player instance
SentryPlayer sentryPlayer = SentryAPI.getPlayerManager().get(player);
if (sentryPlayer != null) {
    // Perform your checks
}
```

Example of how you can listen to API events, does not depend on the platform:

```java
import dev.square.api.SentryAPI;
import dev.square.api.events;
import dev.square.api.events.module.AntiVPNCheckEvent;
import dev.square.api.entity.SentryPlayer;

SentryAPI.getEventBus().register(AntiVPNCheckEvent.class, (event) -> {
    if(event.getConnectionType() == AntiVPNCheckEvent.ConnectionType.VPN) {
        event.setCancelled(true);
        return;
    }
    
    final UUID uuid = event.getSentryPlayer().getUniqueId();
    
    // do your things here
    Bukkit.getPlayer(uuid);                          // Paper
    MinecraftServer.getPlayerList().getPlayer(uuid); // Fabric
});
```

If you are using the API on a Bukkit plugin, make sure that your plugin loads after Sentry by adding `depend: [Sentry]` (or `softdepend: [Sentry]`) to your `plugin.yml` file.