package Jesa.AggregateRootEntityTests;

import Jesa.AggregateRootEntityBase;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertArrayEquals;

public class WithInitializedInstance extends AggregateRootEntityBase {
    private final AggregateRootEntityBase sut;

    public WithInitializedInstance() {
        sut = new InitializedRootEntity();
    }

    @Test
    public void hasChangesReturnsFalse() {
        assertThat(sut.hasChanges(), is(false));
    }

    @Test
    public void getChangesReturnsEmpty() {
        assertArrayEquals(new Object[]{}, sut.getChanges());
    }
}
