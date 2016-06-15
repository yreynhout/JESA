package core;

import java.util.function.Consumer;

/**
 * A configurable instance event router with state handles that events are routed to.
 */
public interface configurableInstanceEventRouter extends InstanceEventRouter {

    /**
     * Adds a route for a specific class of event to an event handler.
     * @param eventClass The string name of the event class to route.
     * @param eventHandler The state handler that must be invoked for the event class.
     */
    void configureRoute(String eventClass, Consumer<Object> eventHandler);

}
