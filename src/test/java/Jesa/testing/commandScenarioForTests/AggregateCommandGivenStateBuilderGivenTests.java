package Jesa.testing.commandScenarioForTests;

import Jesa.AggregateRootEntityStub;
import Jesa.testing.AggregateCommandGivenStateBuilder;
import Jesa.testing.CommandScenarioFor;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

public class AggregateCommandGivenStateBuilderGivenTests {

    private AggregateCommandGivenStateBuilder<AggregateRootEntityStub> given(Object... events) {
        return new CommandScenarioFor<AggregateRootEntityStub>(() -> new AggregateRootEntityStub())
                .given(new Object[0])
                .given(events);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenThrowsWhenEventsAreNull() {
        given(null);
    }

    @Test
    public void givenDoesNotReturnNull() {
        assertNotNull(given(new Object[0]));
    }

    @Test
    public void giveReturnsGivenBuilderContinuation() {
        assertThat(given(new Object[0]), instanceOf(AggregateCommandGivenStateBuilder.class));
    }

    @Test
    public void givenReturnsNewInstanceOnEachCall() {
        assertNotSame(given(new Object[0]), given(new Object[0]));
    }

    @Test
    public void givenEventsAreEquivalentOnResultingSpecification() {
        Object[] events = {new Object(), new Object()};
        Object[] result =
                given(events)
                .when((c) -> {})
                .then(new Object[0])
                .build()
                .givens();

        assertArrayEquals(events, result);
    }
}
