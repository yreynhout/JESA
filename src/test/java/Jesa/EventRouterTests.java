package Jesa;

import com.google.common.base.VerifyException;
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

    @Test(expected = VerifyException.class)
    public void configureRouteHandlerCannotBeNull() {
        sut.configureRoute(null, null);
        //sut.configureRoute(Object.class, null);
    }

    @Test
    public void configureRouteHandlesEventAsExpected() {
        final boolean[] called = {false};
        sut.configureRoute(Object.class, (event) -> called[0] = true);
        sut.route(new Object());
        assertThat(called[0], is(true));
    }
}
