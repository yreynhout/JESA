package Jesa;

import java.util.function.Consumer;

/**
 * Base class for aggregate root entities, provides basic change tracking capabilities.
 */

public abstract class AggregateRootEntityBase implements AggregateRootEntity {

    private final EventRecorder eventRecorder;
    private final InstanceEventRouter eventRouter;

    protected AggregateRootEntityBase() {

        eventRecorder = new EventRecorder();
        eventRouter = new EventRouter();
    }

    public void initialize(Iterable<Object> events) {
        if(events == null)
            throw new IllegalArgumentException("Argument Events cannot be null");
        if(hasChanges())
            throw new IllegalArgumentException("Cannot initialize an AggregateRootEntity that already has changes.");

        for(Object event : events) {
            play(event);
        }
    }

    public <T> void register(Class<T> eventType, Consumer<T> handler) {
        if(handler == null)
            throw new IllegalArgumentException("Argument handler cannot be null");

        eventRouter.configureRoute(eventType, handler);
    }

    public boolean hasChanges() {
        return eventRecorder.hasEvents();
    }

    public Object[] getChanges() {
        return eventRecorder.toArray();
    }

    public void clearChanges() {
        eventRecorder.clear();
    }

    public void applyChange(Object event) {
        if(event == null)
            throw new IllegalArgumentException("The event cannot be null.");

        play(event);
        record(event);
    }

    private void play(Object event) {
        eventRouter.route(event);
    }

    private void record(Object event) {
        eventRecorder.record(event);
    }
}
