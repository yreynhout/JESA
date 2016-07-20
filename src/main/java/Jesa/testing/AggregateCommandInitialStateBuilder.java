package Jesa.testing;

import Jesa.core.AggregateRootEntity;

import java.util.function.Consumer;

/**
 * Created by rsmith on 7/15/16.
 */
public interface AggregateCommandInitialStateBuilder<TAggregateRoot extends AggregateRootEntity> {
    /**
     * given no events occured.
     *
     * @return A builder continuation.
     */
    AggregateCommandGivenNoneStateBuilder<TAggregateRoot> givenNone();

    /// <summary>
    /// given the following events occured.
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

