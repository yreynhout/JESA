package core;

import com.google.common.base.Preconditions;
import com.google.common.base.Verify;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Created by rsmith on 5/10/16.
 */
public class EventRouter implements configurableInstanceEventRouter {

    private final Map<String, Consumer<Object>> eventHandlerMap = new HashMap<>();

    public void configureRoute(String eventClass, Consumer<Object> eventHandler) {
        Verify.verifyNotNull(eventClass);
        Verify.verifyNotNull(eventHandler);
        //do we want to throw in here, or atleast use a precondition?
        Preconditions.checkState(!eventHandlerMap.containsKey(eventClass));
        eventHandlerMap.put(eventClass, eventHandler);
    }

    public void route(Object event) {
        Verify.verifyNotNull(event);
        String eventClass = event.getClass().toString();

        if(eventHandlerMap.containsKey(eventClass)) {
            Consumer<Object> eventHandler = eventHandlerMap.get(eventClass);
            eventHandler.accept(event);
        }
    }
}
