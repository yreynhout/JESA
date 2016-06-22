package Jesa;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class EventRouterTests {

    private final EventRouter sut = new EventRouter();

    @Test
    public void IsInstanceEventRouter() {
        assertThat(sut, instanceOf(InstanceEventRouter.class));
    }

    @Test(expected = IllegalArgumentException.class)
    public void configureRouteHandlerCannotBeNull() {
        sut.configureRoute(null, null);
    }

    @Test
    public void configureRouteHandlesEventAsExpected() {
        final boolean[] called = {false};
        sut.configureRoute(Object.class, (event) -> called[0] = true);
        sut.route(new Object());
        assertThat(called[0], is(true));
    }

    @Test(expected = IllegalArgumentException.class)
    public void eventCannotBeNull() {
        sut.route(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotAddDuplicateRouteHandler() {
        sut.configureRoute(Object.class, (event) -> {});
        sut.configureRoute(Object.class, (event) -> {});
    }
}
