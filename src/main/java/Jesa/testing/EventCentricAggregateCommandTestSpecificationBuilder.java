package Jesa.testing;

/// <summary>
/// The act of building an event-centric aggregate command test specification.
/// </summary>
public interface EventCentricAggregateCommandTestSpecificationBuilder
{
    /// <summary>
    /// Builds the test specification thus far.
    /// </summary>
    /// <returns>The test specification.</returns>
    EventCentricAggregateCommandTestSpecification build();
}
