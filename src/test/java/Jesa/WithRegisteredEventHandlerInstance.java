package Jesa;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

public class WithRegisteredEventHandlerInstance {
    private final RegisteredHandlerRootEntity sut;

    public WithRegisteredEventHandlerInstance() {
        sut = new RegisteredHandlerRootEntity();
    }

    @Test
    public void initializeCallsEventHandler() {
        List<Object> expectedEvents = Arrays.asList(new Object(), new Object());
        sut.initialize(expectedEvents);

        assertThat(sut.hasChanges(), is(false)); //the initialize method does not treat these events as new events.
        assertThat(sut.getEventCounter(), is(2));
        assertArrayEquals(expectedEvents.toArray(), sut.getRoutedEvents().toArray());
    }

    @Test
    public void newEventsReflectedWhenNewEventsApplied() {
        List<Object> newEvents = Arrays.asList(new Object(), new Object());
        newEvents.forEach(sut::applyEvent);

        assertThat(sut.hasChanges(), is(true)); //these are new events
        assertThat(sut.getEventCounter(), is(2));
        assertArrayEquals(newEvents.toArray(), sut.getRoutedEvents().toArray());
    }

    @Test
    public void doesNotReflectEventsAfterClearChangesIsCalled() {
        List<Object> newEvents = Arrays.asList(new Object(), new Object());
        newEvents.forEach(sut::applyEvent);

        assertThat(sut.hasChanges(), is(true));
        assertThat(sut.getEventCounter(), is(2));

        sut.clearChanges();

        assertThat(sut.hasChanges(), is(false));
        assertThat(sut.getEventCounter(), is(0));
        assertThat(sut.getChanges().length, is(0));
    }

    @Test
    public void beforeApplyChangesGetCalledBeforeChangesApplied() {

    }
}
