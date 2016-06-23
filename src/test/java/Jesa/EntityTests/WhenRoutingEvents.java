package Jesa.EntityTests;

import Jesa.Entity;
import Jesa.EventRouter;
import org.junit.Test;

public class WhenRoutingEvents {

    @Test(expected = IllegalArgumentException.class)
    public void cannotRegisterNullHandler() {
        new ConfigureWithNullHandlerEntity();
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotConfigureWithNullEventClass() {
        new ConfigureWithNullEventTypeEntity();
    }

    class ConfigureWithNullHandlerEntity extends Entity {
        ConfigureWithNullHandlerEntity() {
            super(o -> {}, new EventRouter());
            super.configureRoute(Object.class, null);
        }
    }

    class ConfigureWithNullEventTypeEntity extends Entity {
        ConfigureWithNullEventTypeEntity() {
            super(o -> {}, new EventRouter());
            super.configureRoute(null, o -> {});
        }
    }
}
