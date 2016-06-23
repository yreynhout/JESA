package Jesa;

import java.util.function.Consumer;

/**
 * Base class for Entities that provides functionality to track state changes.
 */
public class Entity implements InstanceEventRouter {

    private final Consumer<Object> eventApplier;
    private final InstanceEventRouter router;

    public Entity(Consumer<Object> eventApplier, InstanceEventRouter router) {
        this.router = router;

        if(eventApplier == null)
            throw new IllegalArgumentException("eventApplier cannot be null");

        if(router == null)
            throw new IllegalArgumentException("router cannot be null");

        this.eventApplier = eventApplier;
    }

    @Override
    public <T> void configureRoute(Class<T> eventClass, Consumer<T> eventHandler) throws IllegalArgumentException {
        if(eventClass == null)
            throw new IllegalArgumentException("eventClass cannot be null");

        if(eventHandler == null)
            throw new IllegalArgumentException("eventHandler cannot be null");
    }

    @Override
    public void route(Object event) throws IllegalArgumentException {

    }
}
