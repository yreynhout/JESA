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
        sut.applyEvent(expectedEvents);

        assertThat(sut.getEventCounter(), is(2));
        assertArrayEquals(expectedEvents.toArray(), sut.getRoutedEvents().toArray());
    }
}
