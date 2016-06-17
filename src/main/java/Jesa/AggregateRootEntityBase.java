package Jesa;

/**
 * Base class for aggregate root entities, provides basic change tracking capabilities.
 */

public abstract class AggregateRootEntityBase implements AggregateRootEntity {

    private final EventRecorder _eventRecorder;

    protected AggregateRootEntityBase() {
        _eventRecorder = new EventRecorder();
    }

    public void initialize(Iterable<Object> events) {

    }

    public boolean hasChanges() {
        return _eventRecorder.hasEvents();
    }

    public Object[] getChanges() {
        return _eventRecorder.toArray();
    }

    public void clearChanges() {
        _eventRecorder.clear();
    }
}
