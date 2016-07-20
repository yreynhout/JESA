package Jesa.testing;

/// <summary>
/// The then state within the test specification building process.
/// </summary>
public interface AggregateCommandThenStateBuilder extends EventCentricAggregateCommandTestSpecificationBuilder {
    /// <summary>
    /// Then events should have occurred.
    /// </summary>
    /// <param name="events">The events that should have occurred.</param>
    /// <returns>A builder continuation.</returns>
    AggregateCommandThenStateBuilder then(Object... events);
}
