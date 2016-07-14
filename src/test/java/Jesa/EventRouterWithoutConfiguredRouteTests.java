import Jesa.core.EventRouter;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Yves on 30/04/2016.
 */
public class EventRouterWithoutConfiguredRouteTests
{
    private final EventRouter sut;

    public EventRouterWithoutConfiguredRouteTests()
    {
        sut = new EventRouter();
    }

    @Test(expected = IllegalArgumentException.class)
    public void configureRouteEventClassCanNotBeNull()
    {
        sut.configureRoute(null, (event) -> {});
    }

    @Test(expected = IllegalArgumentException.class)
    public void configureRouteEventHandlerCanNotBeNull()
    {
        sut.configureRoute(Object.class, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void routeEventCanNotBeNull()
    {
        sut.route(null);
    }

    @Test
    public void routeEventWithMatchingRouteHasExpectedResult()
    {
        Signal signal = new Signal();
        sut.configureRoute(Event1.class, (event) -> {
            signal.set();
        });

        sut.route(new Event1());

        Assert.assertEquals(true, signal.isSet());
    }

    @Test
    public void routeEventWithoutMatchingRouteHasExpectedResult()
    {
        Signal signal = new Signal();
        sut.configureRoute(Event1.class, (event) -> {
            signal.set();
        });

        sut.route(new Event2());

        Assert.assertEquals(false, signal.isSet());
    }

    private class Event1 {}
    private class Event2 {}
    private class Signal
    {
        private boolean signal;

        public Signal()
        {
            signal = false;
        }

        public void set()
        {
            signal = true;
        }

        public boolean isSet(){
            return signal;
        }
    }
}
