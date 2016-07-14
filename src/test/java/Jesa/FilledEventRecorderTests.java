import Jesa.core.EventRecorder;
import org.junit.Assert;
import org.junit.Test;

public class FilledEventRecorderTests {
    private final Object event;
    private final EventRecorder sut;

    public FilledEventRecorderTests(){
        event = new Object();
        sut = new EventRecorder();
        sut.record(event);
    }

    @Test
    public void toArrayReturnsExpectedResult()
    {
        Object[] result = sut.toArray();

        Assert.assertArrayEquals(new Object[] { this.event }, result);
    }

    @Test
    public void clearHasExpectedResult()
    {
        sut.clear();

        Object[] result = sut.toArray();
        Assert.assertArrayEquals(new Object[0], result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void recordEventCanNotBeNull()
    {
        sut.record(null);
    }

    @Test
    public void recordHasExpectedResult()
    {
        Object event = new Object();
        sut.record(event);

        Object[] result = sut.toArray();
        Assert.assertArrayEquals(new Object[] { this.event, event }, result);
    }
}
