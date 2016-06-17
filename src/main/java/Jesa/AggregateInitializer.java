package Jesa;

/**
 * Initializes an aggregate
 */
public interface AggregateInitializer {
    void initialize(Iterable<Object> events);
}
