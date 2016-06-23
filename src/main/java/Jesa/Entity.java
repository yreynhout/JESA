package Jesa;

import java.util.function.Consumer;

/**
 * Base class for Entities that provides functionality to track state changes.
 */
public class Entity implements InstanceEventRouter {

    private final Consumer<Object> eventApplier;
    private final InstanceEventRouter router;

    public Entity(Consumer<Object> eventApplier) {

        if(eventApplier == null)
            throw new IllegalArgumentException("eventApplier cannot be null");

        this.eventApplier = eventApplier;
        this.router = new EventRouter();
    }

    @Override
    public <T> void configureRoute(Class<T> eventClass, Consumer<T> eventHandler) throws IllegalArgumentException {
        if(eventClass == null)
            throw new IllegalArgumentException("eventClass cannot be null");

        if(eventHandler == null)
            throw new IllegalArgumentException("eventHandler cannot be null");

        router.configureRoute(eventClass, eventHandler);
    }

    @Override
    public void route(Object event) throws IllegalArgumentException {
        if(event == null)
            throw new IllegalArgumentException("Cannot route a null event");

        router.route(event);
    }

    protected void apply(Object event) {
        if(event == null)
            throw new IllegalArgumentException("Cannot apply a null event");

        eventApplier.accept(event);
    }
}
