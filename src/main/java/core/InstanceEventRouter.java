package core;

/**
 * Routes an event to a configure state handler.
 */
public interface InstanceEventRouter {

    /**
     * Routes the specified event to a configured state handler, if any.
     * @param event The event to route.
     */
    void route(Object event);
}
