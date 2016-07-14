package Jesa.AggregateRootEntityTests;

import Jesa.core.AggregateRootEntityBase;

/**
 * Created by rsmith on 6/17/16.
 */
public class ChangedRootEntity extends AggregateRootEntityBase {

    public static final Object[] changes = new Object[] {new Object(), new Object()};

    public ChangedRootEntity() {

        for(Object event : changes) {
            applyChange(event);
        }
    }
}
