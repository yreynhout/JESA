package Jesa;


import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

public class WithChangedInstance {
    private final AggregateRootEntity sut;

    public WithChangedInstance() {
        sut = new ChangedRootEntity();
    }

    @Test
    public void hasChangesReturnsTrue() {
        assertThat(sut.hasChanges(), is(true));
    }

    @Test
    public void getChangesReturnsChanges() {
        assertArrayEquals(sut.getChanges(), ChangedRootEntity.changes);
    }

    @Test
    public void clearChangesRemovesAnyPendingChanges() {
        AggregateRootEntity rootEntity = new ChangedRootEntity();
        rootEntity.clearChanges();

        assertThat(rootEntity.hasChanges(), is(false));
        assertThat(rootEntity.getChanges().length, is(0));
    }
}
