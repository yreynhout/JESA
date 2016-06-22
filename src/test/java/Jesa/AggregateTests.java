package Jesa;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitQuickcheck.class)
public class AggregateTests {

    @Property
    public void initializeInstance(String identifier, int expectedVersion) {
        AggregateRootEntity root = new AggregateRootEntityStub();
        Aggregate sut = new Aggregate(identifier, expectedVersion, root);

        assertThat(sut.getIdentifier(), is(identifier));
        assertThat(sut.getExpectedVersion(), is(expectedVersion));
        assertThat(sut.getRootEntity(), is(root));
    }
}
