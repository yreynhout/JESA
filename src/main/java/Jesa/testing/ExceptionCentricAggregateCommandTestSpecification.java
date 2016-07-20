package Jesa.testing;

import Jesa.core.AggregateRootEntity;

import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.function.Consumer;

/// <summary>
/// Represents an exception centric test specification, meaning that the outcome revolves around an exception as a result of executing a command method on an aggregate.
/// </summary>
public class ExceptionCentricAggregateCommandTestSpecification
{
    private final Callable<AggregateRootEntity> _sutFactory;
    private final Object[] _givens;
    private final Consumer<AggregateRootEntity> _when;
    private final Exception _throws;

    /// <summary>
    /// Initializes a new instance of the <see cref="ExceptionCentricAggregateCommandTestSpecification"/> class.
    /// </summary>
    /// <param name="sutFactory">The sut factory.</param>
    /// <param name="givens">The events to arrange.</param>
    /// <param name="when">The command method to act upon.</param>
    /// <param name="throws">The expected exception to assert.</param>
    public ExceptionCentricAggregateCommandTestSpecification(Callable<AggregateRootEntity> sutFactory, Object[] givens,
                                                             Consumer<AggregateRootEntity> when, Exception throwsException)
    {
        if (sutFactory == null) throw new IllegalArgumentException("sutFactory cannot be be null");
        if (givens == null) throw new IllegalArgumentException("givens cannot be be null");
        if (when == null) throw new IllegalArgumentException("when cannot be be null");
        if (throwsException == null) throw new IllegalArgumentException("throws cannot be be null");
        _sutFactory = sutFactory;
        _givens = givens;
        _when = when;
        _throws = throwsException;
    }

    /// <summary>
    /// Gets the sut factory.
    /// </summary>
    /// <value>
    /// The sut factory.
    /// </value>
    public Callable<AggregateRootEntity> getSutFactory()
    {
        return _sutFactory;
    }

    /// <summary>
    /// The events to arrange.
    /// </summary>
    public Object[] Givens()
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
    /// The expected exception to assert.
    /// </summary>
    public Exception throwsException()
    {
        return _throws;
    }


    /// <summary>
    /// Returns a test result that indicates this specification has getPassed.
    /// </summary>
    /// <returns>A new <see cref="ExceptionCentricAggregateCommandTestResult"/>.</returns>
    public ExceptionCentricAggregateCommandTestResult pass()
    {
        return new ExceptionCentricAggregateCommandTestResult(
                this,
                TestResultState.Passed,
                Optional.empty(),
                Optional.empty());
    }

    /// <summary>
    /// Returns a test result that indicates this specification has getFailed because nothing happened.
    /// </summary>
    /// <returns>A new <see cref="ExceptionCentricAggregateCommandTestResult"/>.</returns>
    public ExceptionCentricAggregateCommandTestResult fail()
    {
        return new ExceptionCentricAggregateCommandTestResult(
                this,
                TestResultState.Failed,
                Optional.empty(),
                Optional.empty());
    }

    /// <summary>
    /// Returns a test result that indicates this specification has getFailed because different things happened.
    /// </summary>
    /// <param name="actual">The actual events</param>
    /// <returns>A new <see cref="ExceptionCentricAggregateCommandTestResult"/>.</returns>
    public ExceptionCentricAggregateCommandTestResult fail(Object[] actual)
    {
        if (actual == null) throw new IllegalArgumentException("actual cannot be null");
        return new ExceptionCentricAggregateCommandTestResult(
                this,
                TestResultState.Failed,
                Optional.empty(),
                Optional.of(actual));
    }

    /// <summary>
    /// Returns a test result that indicates this specification has getFailed because an exception happened.
    /// </summary>
    /// <param name="actual">The actual exception</param>
    /// <returns>A new <see cref="ExceptionCentricAggregateCommandTestResult"/>.</returns>
    public ExceptionCentricAggregateCommandTestResult fail(Exception actual)
    {
        if (actual == null) throw new IllegalArgumentException("actual cannot be null");
        return new ExceptionCentricAggregateCommandTestResult(
                this,
                TestResultState.Failed,
                Optional.of(actual),
                Optional.empty());
    }
}
