package Jesa;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.function.Consumer;

/**
 * Routes an event to a configured state handler.
 */
public class EventRouter implements InstanceEventRouter {
    private final Map<Class, Consumer<Object>> handlers;

    public EventRouter()
    {
        this.handlers = Maps.newHashMap();
    }

    @Override
    public <T> void configureRoute(Class<T> eventClass, Consumer<T> eventHandler) throws IllegalArgumentException
    {
        if(eventClass == null)
            throw new IllegalArgumentException("The event class can not be null.");
        if(eventHandler == null)
            throw new IllegalArgumentException("The event handler can not be null.");
        if(handlers.containsKey(eventClass))
            throw new IllegalArgumentException(String.format("The event handler [%s] already exists.", eventClass));

        this.handlers.put(eventClass, (event) -> eventHandler.accept((T)event));
    }

    @Override
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
