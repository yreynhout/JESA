package Jesa.testing;

import java.util.Optional;

/// The result of an event centric aggregate command test specification run.
public class EventCentricAggregateCommandTestResult
{
    private final EventCentricAggregateCommandTestSpecification _specification;
    private final TestResultState _state;
    private final Optional<Object[]> _actualEvents;
    private final Optional<Exception> _actualException;

    /// <summary>
    /// Initializes a new instance of the <see cref="EventCentricTestResult"/> class.
    /// </summary>
    /// <param name="specification">The specification.</param>
    /// <param name="state">The state.</param>
    /// <param name="actualEvents">The actual events.</param>
    /// <param name="actualException">The actual exception.</param>
    protected EventCentricAggregateCommandTestResult(
            EventCentricAggregateCommandTestSpecification specification,
            TestResultState state,
            Optional<Object[]> actualEvents,
            Optional<Exception> actualException)
    {
        _specification = specification;
        _state = state;
        _actualEvents = actualEvents;
        _actualException = actualException;
    }

    /// <summary>
    /// Gets the test specification associated with this result.
    /// </summary>
    /// <value>
    /// The test specification.
    /// </value>
    public EventCentricAggregateCommandTestSpecification getSpecification()
    {
        return _specification;
    }

    /// <summary>
    /// Gets a value indicating whether this <see cref="EventCentricTestResult"/> has getPassed.
    /// </summary>
    /// <value>
    ///   <c>true</c> if getPassed; otherwise, <c>false</c>.
    /// </value>
    public boolean getPassed()
    {
        return _state == TestResultState.Passed;
    }

    /// <summary>
    /// Gets a value indicating whether this <see cref="EventCentricTestResult"/> has failed.
    /// </summary>
    /// <value>
    ///   <c>true</c> if failed; otherwise, <c>false</c>.
    /// </value>
    public boolean getFailed()
    {
        return _state == TestResultState.Failed;
    }

    /// <summary>
    /// Gets the events that happened instead of the expected ones, or empty if getPassed.
    /// </summary>
    /// <value>
    /// The events.
    /// </value>
    public Optional<Object[]> getButEvents()
    {
        return _actualEvents;
    }

    /// <summary>
    /// Gets the exception that happened instead of the expected events, or empty if passed.
    /// </summary>
    /// <value>
    /// The exception.
    /// </value>
    public Optional<Exception> butException()
    {
        return _actualException;
    }
}