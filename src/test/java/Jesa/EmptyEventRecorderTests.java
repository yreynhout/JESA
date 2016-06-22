package Jesa;

import Jesa.EventRecorder;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Yves on 30/04/2016.
 */
public class EmptyEventRecorderTests {
    private final EventRecorder sut;

    public EmptyEventRecorderTests(){
        sut = new EventRecorder();
    }

    @Test
    public void toArrayReturnsExpectedResult()
    {
        Object[] result = sut.toArray();

        Assert.assertArrayEquals(new Object[0], result);
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
        Assert.assertArrayEquals(new Object[] { event }, result);
    }
}


