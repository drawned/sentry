# Sentry

Sentry is an all-in-one **server security** solution designed to protect your Minecraft server from common threats. It includes protection against unauthorized client modifications, hacked clients, malicious bots, VPN/Proxy connections, crash-items, and unauthorized OP assignments.

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

Replace `LATEST` with the latest API [release from here](https://github.com/drawned/sentry/releases/latest).

### Gradle (build.gradle)

Add the JitPack repository to your `repositories` block:

```gradle
repositories {
    maven { url = 'https://jitpack.io' }
}
```

Add the dependency:

```gradle
dependencies {
    compileOnly 'com.github.drawned.sentry:api:LATEST'
}
```

### Maven (pom.xml)

Add the JitPack repository to your `repositories` block:

```xml
<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>
```

Add the dependency:

```xml
<dependency>
    <groupId>com.github.drawned.sentry</groupId>
    <artifactId>api</artifactId>
    <version>LATEST</version>
    <scope>provided</scope>
</dependency>
```

---

## Usage

You can access the main management interface through the [SentryAPI](https://github.com/drawned/sentry/blob/master/api/src/main/java/dev/square/api/SentryAPI.java) class.

Example to retrieve a player's security instance:

```java
import dev.square.api.SentryAPI;
import dev.square.api.player.SentryPlayer;

// Retrieving a player instance
SentryPlayer sentryPlayer = SentryAPI.getPlayerManager().get(player);
if (sentryPlayer != null) {
    // Perform your checks
}
```

Make sure that your plugin loads after Sentry by adding `depend: [Sentry]` (or `softdepend: [Sentry]`) to your `plugin.yml` file.