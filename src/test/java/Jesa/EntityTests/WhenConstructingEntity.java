package Jesa.EntityTests;


import Jesa.Entity;
import Jesa.EventRouter;
import org.junit.Test;

public class WhenConstructingEntity {

    @Test(expected = IllegalArgumentException.class)
    public void applierCannotBeNull() {
        new NullApplierEntity();
    }

    @Test(expected = IllegalArgumentException.class)
    public void routerCannotBeNull() {
        new NullRouterEntity();
    }

    class NullApplierEntity extends Entity {
        NullApplierEntity() {
            super(null, new EventRouter());
        }
    }

    class NullRouterEntity extends Entity {
        NullRouterEntity() {
            super(o -> {}, null);
        }
    }
}




