package core;

import Jesa.EventRouter;

import java.util.function.Consumer;

/**
 * Base class for aggregate entities that need some basic infrastructure for tracking state changes on their aggregate root entity.
 */

public abstract class Entity implements InstanceEventRouter {

    private final Consumer<Object> applier;
    private final EventRouter router;

    protected Entity(Consumer<Object> applier) {
        this.applier = applier;
        this.router = new EventRouter();
    }


    public void route(Object event) {

    }
}
