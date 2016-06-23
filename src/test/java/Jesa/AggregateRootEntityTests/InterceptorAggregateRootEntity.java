package Jesa.AggregateRootEntityTests;

import Jesa.AggregateRootEntityBase;

public class InterceptorAggregateRootEntity extends AggregateRootEntityBase {
    private boolean beforeChangesWasCalled = false;
    private boolean afterChangesWasCalled = false;

    @Override
    protected void beforeApplyChanges(Object event) {
        beforeChangesWasCalled = true;
    }

    @Override
    protected void afterApplyChanges(Object event) {
        afterChangesWasCalled = true;
    }

    public void applyEvent(Object event){
        applyChange(event);
    }

    public boolean beforeChangesWasCalled() {
        return beforeChangesWasCalled;
    }

    public boolean afterChangesWasCalled() {
        return afterChangesWasCalled;
    }
}
