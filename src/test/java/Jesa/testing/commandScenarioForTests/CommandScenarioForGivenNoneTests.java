package Jesa.testing.commandScenarioForTests;

import Jesa.AggregateRootEntityStub;
import Jesa.testing.AggregateCommandGivenNoneStateBuilder;
import Jesa.testing.CommandScenarioFor;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;

public class CommandScenarioForGivenNoneTests {
    private AggregateCommandGivenNoneStateBuilder<AggregateRootEntityStub> givenNone() {
        return new CommandScenarioFor<AggregateRootEntityStub>(() -> new AggregateRootEntityStub())
                .givenNone();
    }

    @Test
    public void givenNoneDoesNotReturnNull() {
        assertNotNull(givenNone());
    }

    @Test
    public void givenNoneReturnsGivenNoneBuilderContinuation() {
        assertThat(givenNone(), instanceOf(AggregateCommandGivenNoneStateBuilder.class));
    }

    @Test
    public void givenNoneEventsAreEmpty() {
        Object[] results =
                givenNone()
                .when((c) -> {})
                .then(new Object[0])
                .build()
                .givens();

        assertArrayEquals(new Object[0], results);
    }
}
