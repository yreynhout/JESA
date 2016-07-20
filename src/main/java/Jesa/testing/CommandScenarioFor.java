package Jesa.testing;

import Jesa.core.AggregateRootEntity;

import java.util.concurrent.Callable;
import java.util.function.Consumer;

/// <summary>
/// A given-when-then test specification bootstrapper for testing an aggregate command, i.e. a method on the aggregate that returns void.
/// </summary>
/// <typeparam name="TAggregateRoot">The type of aggregate root entity under test.</typeparam>
public class CommandScenarioFor<TAggregateRoot extends AggregateRootEntity> implements AggregateCommandInitialStateBuilder<TAggregateRoot> {
    private final Callable<AggregateRootEntity> sutFactory;

    /// <summary>
/// Initializes a new instance of the <see cref="CommandScenarioFor{TAggregateRoot}"/> class.
/// </summary>
/// <param name="sut">The sut.</param>
    public CommandScenarioFor(TAggregateRoot sut)
    {
        this(() -> sut);
    }

    /// <summary>
/// Initializes a new instance of the <see cref="CommandScenarioFor{TAggregateRoot}"/> class.
/// </summary>
/// <param name="sutFactory">The sut factory.</param>
/// <exception cref="ArgumentNullException">Thrown when the <paramref name="sutFactory"/> is <c>null</c>.</exception>
    public CommandScenarioFor(Callable<TAggregateRoot> sutFactory) {
        if (sutFactory == null) throw new IllegalArgumentException("sutFactory");
        this.sutFactory = sutFactory::call;
    }

    /// <summary>
/// Given the following events occured.
/// </summary>
/// <param name="events">The events that occurred.</param>
/// <returns>A builder continuation.</returns>
/// <exception cref="System.ArgumentNullException">Thrown when <paramref name="events"/> are <c>null</c>.</exception>
    public AggregateCommandGivenStateBuilder<TAggregateRoot> given(Object... events) {
        if (events == null) throw new IllegalArgumentException("events cannot be null");
        return new AggregateCommandGivenStateBuilderImpl<>(sutFactory, events);
    }

    /// <summary>
/// Given no events occured.
/// </summary>
/// <returns>A builder continuation.</returns>
    public AggregateCommandGivenNoneStateBuilder<TAggregateRoot> givenNone() {
        return new AggregateCommandGivenNoneStateBuilderImpl<TAggregateRoot>(sutFactory);
    }

    /// <summary>
/// When a command occurs.
/// </summary>
/// <param name="command">The command method invocation on the sut.</param>
/// <returns>A builder continuation.</returns>
/// <exception cref="System.ArgumentNullException">Thrown when <paramref name="command"/> is <c>null</c>.</exception>
    public AggregateCommandWhenStateBuilder when(Consumer<TAggregateRoot> command) {
        if (command == null) throw new IllegalArgumentException("command cannot be null");
        return new AggregateCommandWhenStateBuilderImpl(sutFactory, new Object[0],
                root -> command.accept((TAggregateRoot) root));
    }
}