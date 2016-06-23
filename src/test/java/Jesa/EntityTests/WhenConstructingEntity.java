package Jesa.EntityTests;


import Jesa.Entity;
import org.junit.Test;

public class WhenConstructingEntity {

    @Test(expected = IllegalArgumentException.class)
    public void applierCannotBeNull() {
        new NullApplierEntity();
    }

    class NullApplierEntity extends Entity {
        NullApplierEntity() {
            super(null);
        }
    }
}




