package Jesa.testing;

import Jesa.core.AggregateRootEntity;

import java.util.function.Consumer;

/// <summary>
/// The given state within the test specification building process.
/// </summary>
public interface AggregateCommandGivenStateBuilder<TAggregateRoot extends AggregateRootEntity> {
    /// <summary>
    /// Given the following events occured.
    /// </summary>
    /// <param name="events">The events that occurred.</param>
    /// <returns>A builder continuation.</returns>
    AggregateCommandGivenStateBuilder<TAggregateRoot> given(Object... events);

    /// <summary>
    /// when a command occurs.
    /// </summary>
    /// <param name="command">The command method invocation on the sut.</param>
    /// <returns>A builder continuation.</returns>
    AggregateCommandWhenStateBuilder when(Consumer<TAggregateRoot> command);
}
