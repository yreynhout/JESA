package core;

/**
 * Keeps track of changes to an aggregate. ie, records the events
 * that represent state changes.
 */
public interface AggregateTrackChanges {

    /**
     * Does this aggregate instance have state changes.
     * @return true if this aggregate instance has changes, else false.
     */
    boolean hasChanges();

    /**
     * Get the changes applied to this instance
     * @return an iterable sequence of events that have been applied.
     */
    Object[] getChanges();

    /**
     * Clears the events.
     */
    void clearChanges();
}
