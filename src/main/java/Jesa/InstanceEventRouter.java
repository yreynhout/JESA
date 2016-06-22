package Jesa;

import java.util.function.Consumer;

/**
 * Implementors route events to configured event handlers
 */
public interface InstanceEventRouter {
    <T> void configureRoute(Class<T> eventClass, Consumer<T> eventHandler) throws IllegalArgumentException;

    void route(Object event) throws IllegalArgumentException;
}
