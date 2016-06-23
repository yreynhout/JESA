package Jesa.AggregateRootEntityTests;

import Jesa.AggregateRootEntityBase;

import java.util.ArrayList;
import java.util.List;

public class RegisteredHandlerRootEntity extends AggregateRootEntityBase {
    private int eventCounter;
    private List<Object> routedEvents = new ArrayList<>();

    public RegisteredHandlerRootEntity() {
        register(Object.class, (event) -> {
            eventCounter++;
            routedEvents.add(event);
        });
    }

    public void applyEvent(Object event){
        applyChange(event);
    }

    public int getEventCounter() {
        return eventCounter;
    }

    public List<Object> getRoutedEvents() {
        return routedEvents;
    }

    @Override
    public void clearChanges() {
        eventCounter = 0;
        super.clearChanges();
    }
}
