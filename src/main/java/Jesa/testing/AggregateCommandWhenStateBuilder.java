package Jesa.testing;

/**
* The when state within the test specification building process.
*/
public interface AggregateCommandWhenStateBuilder
{
    /// <summary>
    /// then no events should have occurred.
    /// </summary>
    /// <returns>A builder continuation.</returns>
    AggregateCommandThenNoneStateBuilder thenNone();

    /// <summary>
    /// then events should have occurred.
    /// </summary>
    /// <param name="events">The events that should have occurred.</param>
    /// <returns>A builder continuation.</returns>
    AggregateCommandThenStateBuilder then(Object... events);

    /// <summary>
    /// Throws an exception.
    /// </summary>
    /// <param name="exception">The exception thrown.</param>
    /// <returns>A builder continuation.</returns>
    AggregateCommandThrowStateBuilder throwsException(Exception exception);
}
