package dev.square.api.events;

import lombok.Getter;

import java.util.function.Consumer;

public interface SentryEvent {

    interface CancellableSentryEvent extends SentryEvent {
        boolean isCancelled();
        void setCancelled(boolean cancel);
    }

    // TODO: Move to record on a future update (would also drop version support)
    @Getter
    class ClientEntry {
        private final String name;
        private final String id;
        public ClientEntry(String name, String id) {
            this.name = name;
            this.id = id;
        }
    }

}
