package Jesa.EntityTests;

import Jesa.Entity;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class WhenRoutingEvents {

    @Test(expected = IllegalArgumentException.class)
    public void cannotConfigureWithNullHandler() {
        new ConfigureWithNullHandlerEntity();
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotConfigureWithNullEventClass() {
        new ConfigureWithNullEventTypeEntity();
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotConfigureSameEventTwice() {
        new ConfigureWithEventTypeTwiceEntity();
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotRouteNullEvent() {
        ConfiguredWithRouterEntity sut = new ConfiguredWithRouterEntity();
        sut.route(null);
    }

    @Test
    public void routesEvents() {
        Object event = new Object();
        ConfiguredWithRouterEntity sut = new ConfiguredWithRouterEntity();
        sut.route(event);

        assertThat(sut.wasEventRouted(), is(true));
        assertThat(sut.getRoutedEvents().size(), is(1));
        assertThat(sut.getRoutedEvents().contains(event), is(true));
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotApplyNullEvents() {
        ConfiguredWithRouterEntity sut = new ConfiguredWithRouterEntity();
        sut.applyEvent(null);
    }

    @Test
    public void applyAppliesEvents() {
        Object event = new Object();
        List<Object> appliedEvents = new ArrayList<>();
        ConfiguredWithEventApplierEntity sut = new ConfiguredWithEventApplierEntity(e -> appliedEvents.add(e));
        sut.applyEvent(event);

        assertThat(appliedEvents.size(), is(1));
        assertThat(appliedEvents.contains(event), is(true));
    }

    class ConfigureWithNullHandlerEntity extends Entity {
        ConfigureWithNullHandlerEntity() {
            super(o -> {});
            super.configureRoute(Object.class, null);
        }
    }

    class ConfigureWithNullEventTypeEntity extends Entity {
        ConfigureWithNullEventTypeEntity() {
            super(o -> {});
            super.configureRoute(null, o -> {});
        }
    }

    class ConfigureWithEventTypeTwiceEntity extends Entity {
        ConfigureWithEventTypeTwiceEntity() {
            super(o -> {});
            super.configureRoute(Object.class, o -> {});
            super.configureRoute(Object.class, o -> {});
        }
    }

    class ConfiguredWithRouterEntity extends Entity {
        private boolean eventWasRouted = false;
        private List<Object> routedEvents = new ArrayList<>();

        ConfiguredWithRouterEntity() {
            super(event -> {});
            super.configureRoute(Object.class, event -> {
                eventWasRouted = true;
                routedEvents.add(event);
            });
        }

        public boolean wasEventRouted() {
            return eventWasRouted;
        }

        public List<Object> getRoutedEvents() {
            return routedEvents;
        }

        public void applyEvent(Object event) {
            super.apply(event);
        }
    }

    class ConfiguredWithEventApplierEntity extends Entity {
        ConfiguredWithEventApplierEntity(Consumer<Object> applier) {
            super(applier);
        }

        public void applyEvent(Object event) {
            super.apply(event);
        }
    }
}
