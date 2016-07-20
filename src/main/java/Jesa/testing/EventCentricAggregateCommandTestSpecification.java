package Jesa.testing;

import Jesa.core.AggregateRootEntity;

import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.function.Consumer;

/// <summary>
/// Represents an event centric test specification, meaning that the outcome revolves around events as the result of executing a command method on an aggregate.
/// </summary>
public class EventCentricAggregateCommandTestSpecification
{
    private final Callable<AggregateRootEntity> _sutFactory;
    private final Object[] _givens;
    private final Consumer<AggregateRootEntity> _when;
    private final Object[] _thens;

    /// <summary>
    /// Initializes a new instance of the <see cref="EventCentricAggregateCommandTestSpecification"/> class.
    /// </summary>
    /// <param name="sutFactory">The sut factory.</param>
    /// <param name="givens">The events to arrange.</param>
    /// <param name="when">The command method to act upon.</param>
    /// <param name="thens">The events to assert.</param>
    public EventCentricAggregateCommandTestSpecification(Callable<AggregateRootEntity> sutFactory, Object[] givens,
                                                         Consumer<AggregateRootEntity> when, Object[] thens)
    {
        if (sutFactory == null) throw new IllegalArgumentException("sutFactory cannot be null");
        if (givens == null) throw new IllegalArgumentException("givens cannot be null");
        if (when == null) throw new IllegalArgumentException("when cannot be null");
        if (thens == null) throw new IllegalArgumentException("thens cannot be null");
        _sutFactory = sutFactory;
        _givens = givens;
        _when = when;
        _thens = thens;
    }

    /// <summary>
    /// Gets the sut factory.
    /// </summary>
    /// <value>
    /// The sut factory.
    /// </value>
    public Callable<AggregateRootEntity> sutFactory()
    {
        return _sutFactory;
    }

    /// <summary>
    /// The events to arrange.
    /// </summary>
    public Object[] givens()
    {
        return _givens;
    }

    /// <summary>
    /// The command method to act upon.
    /// </summary>
    public Consumer<AggregateRootEntity> when()
    {
        return _when;
    }

    /// <summary>
    /// The expected events to assert.
    /// </summary>
    public Object[] thens()
    {
        return _thens;
    }

    /// <summary>
    /// Returns a test result that indicates this specification has getPassed.
    /// </summary>
    /// <returns>A new <see cref="EventCentricAggregateCommandTestResult"/>.</returns>
    public EventCentricAggregateCommandTestResult pass()
    {
        return new EventCentricAggregateCommandTestResult(
                this,
                TestResultState.Passed,
                Optional.empty(),
            Optional.empty());
    }

    /// <summary>
    /// Returns a test result that indicates this specification has getFailed because different things happened.
    /// </summary>
    /// <param name="actual">The actual events</param>
    /// <returns>A new <see cref="EventCentricAggregateCommandTestResult"/>.</returns>
    public EventCentricAggregateCommandTestResult fail(Object[] actual)
    {
        if (actual == null) throw new IllegalArgumentException("actual cannot be null");
        return new EventCentricAggregateCommandTestResult(
                this,
                TestResultState.Failed,
                Optional.of(actual),
                Optional.empty());
    }

    /// <summary>
    /// Returns a test result that indicates this specification has getFailed because an exception happened.
    /// </summary>
    /// <param name="actual">The actual exception</param>
    /// <returns>A new <see cref="EventCentricAggregateCommandTestResult"/>.</returns>
    public EventCentricAggregateCommandTestResult fail(Exception actual)
    {
        if (actual == null) throw new IllegalArgumentException("actual cannot be null");
        return new EventCentricAggregateCommandTestResult(
                this,
                TestResultState.Failed,
                Optional.empty(),
                Optional.of(actual));
    }
}
