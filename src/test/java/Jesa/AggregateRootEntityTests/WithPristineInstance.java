package Jesa.AggregateRootEntityTests;

import Jesa.core.AggregateRootEntity;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests a new, pristine instance, with no events
 */
public class WithPristineInstance {

    private final AggregateRootEntity sut;

    public WithPristineInstance() {
        sut = new PristineAggregateRootEntity();
    }

    @Test
    public void hasChangesReturnsFalse() {
        assertFalse(sut.hasChanges());
    }

    @Test
    public void getChangesReturnsNothing() {
        assertArrayEquals(sut.getChanges(), new Object[0]);
    }
}
