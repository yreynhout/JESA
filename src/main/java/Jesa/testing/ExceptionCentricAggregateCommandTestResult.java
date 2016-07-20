package Jesa.testing;

import java.util.Optional;

/// <summary>
/// The result of an exception centric aggregate command test specification.
/// </summary>
public class ExceptionCentricAggregateCommandTestResult
{
    private final ExceptionCentricAggregateCommandTestSpecification _specification;
    private final TestResultState _state;
    private final Optional<Exception> _actualException;
    private final Optional<Object[]> _actualEvents;

    /// <summary>
    /// Initializes a new instance of the <see cref="ExceptionCentricTestResult"/> class.
    /// </summary>
    /// <param name="specification">The specification.</param>
    /// <param name="state">The state.</param>
    /// <param name="actualException">The actual exception.</param>
    /// <param name="actualEvents">The actual events.</param>
    protected ExceptionCentricAggregateCommandTestResult(
            ExceptionCentricAggregateCommandTestSpecification specification, TestResultState state,
            Optional<Exception> actualException,
            Optional<Object[]> actualEvents)
    {
        _specification = specification;
        _state = state;
        _actualException = actualException;
        _actualEvents = actualEvents;
    }

    /// <summary>
    /// Gets the test specification associated with this result.
    /// </summary>
    /// <value>
    /// The test specification.
    /// </value>
    public ExceptionCentricAggregateCommandTestSpecification getSpecification()
    {
        return _specification;
    }

    /// <summary>
    /// Gets a value indicating whether this <see cref="ExceptionCentricAggregateCommandTestResult"/> has getPassed.
    /// </summary>
    /// <value>
    ///   <c>true</c> if getPassed; otherwise, <c>false</c>.
    /// </value>
    public boolean passed()
    {
        return _state == TestResultState.Passed;
    }

    /// <summary>
    /// Gets a value indicating whether this <see cref="ExceptionCentricAggregateCommandTestResult"/> has getFailed.
    /// </summary>
    /// <value>
    ///   <c>true</c> if getFailed; otherwise, <c>false</c>.
    /// </value>
    public boolean failed()
    {
        return _state == TestResultState.Failed;
    }

    /// <summary>
    /// Gets the exception that happened instead of the expected one, or empty if getPassed.
    /// </summary>
    /// <value>
    /// The exception.
    /// </value>
    public Optional<Exception> butException()
    {
        return _actualException;
    }

    /// <summary>
    /// Gets the events that happened instead of the expected exception, or empty if getPassed.
    /// </summary>
    /// <value>
    /// The events.
    /// </value>
    public Optional<Object[]> butEvents()
    {
        return _actualEvents;
    }
}