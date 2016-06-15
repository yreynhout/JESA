package Jesa;

import java.util.HashMap;
import java.util.function.Consumer;

/**
 * Created by Yves on 30/04/2016.
 */
public class EventRouter
{
    private final HashMap<Class, Consumer<Object>> handlers;

    public EventRouter()
    {
        this.handlers = new HashMap<>();
    }

    public <T> void configureRoute(Class<T> eventClass, Consumer<T> eventHandler) throws IllegalArgumentException
    {
        if(eventClass == null)
            throw new IllegalArgumentException("The event class can not be null.");
        if(eventHandler == null)
            throw new IllegalArgumentException("The event handler can not be null.");

        this.handlers.put(eventClass, (event) -> eventHandler.accept((T)event));
    }

    public void route(Object event) throws IllegalArgumentException
    {
        if(event == null)
            throw new IllegalArgumentException("The event can not be null.");

        Consumer<Object> handler = this.handlers.getOrDefault(event.getClass(), null);
        if (handler != null)
        {
            handler.accept(event);
        }
    }
}
