package core;

/**
 * Base class for aggregate root entities, provides basic change tracking capabilities.
 */

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class AggregateRootEntityBase implements AggregateRootEntity {

    private final List<Object> _eventRecorder;

    AggregateRootEntityBase() {
        _eventRecorder = Collections.emptyList();
    }

    public void initialize(Iterable<Object> events) {

    }

    public boolean hasChanges() {
        return !_eventRecorder.isEmpty();
    }

    public Iterator<Object> getChanges() {
        return _eventRecorder.iterator();
    }

    public void clearChanges() {
        _eventRecorder.clear();
    }
}
