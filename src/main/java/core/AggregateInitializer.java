package core;

/**
 * Initializes an aggregate
 */
public interface AggregateInitializer {
    void initialize(Iterable<Object> events);
}
