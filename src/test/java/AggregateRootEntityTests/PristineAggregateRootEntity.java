package AggregateRootEntityTests;

import core.AggregateRootEntity;

import java.util.Collections;
import java.util.Iterator;

/**
 * empty implementation; implementation not required for tests
 */
public class PristineAggregateRootEntity implements AggregateRootEntity {
    public Iterator<Object> getChanges() {
        return (Iterator<Object>) Collections.EMPTY_LIST;
    }
}
