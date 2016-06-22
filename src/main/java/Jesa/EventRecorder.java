package Jesa;

import java.util.ArrayList;

/**
 * Created by Yves on 30/04/2016.
 */
public class EventRecorder
{
    private final ArrayList records;

    public EventRecorder()
    {
        this.records = new ArrayList();
    }

    public void record(Object event) throws IllegalArgumentException
    {
        if(event == null)
            throw new IllegalArgumentException("The event can not be null.");

        this.records.add(event);
    }

    public Object[] toArray()
    {
        return this.records.toArray();
    }

    public void clear()
    {
        this.records.clear();
    }

    public boolean hasEvents() {
        return !records.isEmpty();
    }
}
