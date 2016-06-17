package Jesa;

/**
 * Created by rsmith on 6/17/16.
 */
public class ChangedRootEntity extends AggregateRootEntityBase {

    public ChangedRootEntity() {
        Object[] changes = new Object[] {new Object(), new Object()};

        for(Object event : changes) {
            applyChange(event);
        }
    }
}
