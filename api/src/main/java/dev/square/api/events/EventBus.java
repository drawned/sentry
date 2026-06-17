package dev.square.api.events;

import dev.square.api.events.module.AntiVPNCheckEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

public class EventBus {
    private final Map<Class<? extends SentryEvent>,
                List<Consumer<SentryEvent>>> listeners = new ConcurrentHashMap<>();

    /**
     * Use this method to register a clean listener for any {@link SentryEvent} API event.
     * @param eventClass a valid event class that implements {@link SentryEvent}
     * @param listener consumer to run when this event is triggered
     */
    @SuppressWarnings("unchecked")
    public <T extends SentryEvent> void register(Class<T> eventClass, Consumer<T> listener) {
        listeners.computeIfAbsent(eventClass, k -> new ArrayList<>())
                .add((event) -> listener.accept((T) event));
    }

    public boolean call(SentryEvent event) {
        List<Consumer<SentryEvent>> eventListeners = listeners.get(event.getClass());
        if (eventListeners != null) {
            for (Consumer<SentryEvent> listener : eventListeners) {
                try {
                    listener.accept(event);
                } catch (Throwable t) {
                    t.printStackTrace();
                }
            }
        }

        if (event instanceof SentryEvent.CancellableSentryEvent) {
            return !((SentryEvent.CancellableSentryEvent) event).isCancelled();
        }
        return true;
    }
}
