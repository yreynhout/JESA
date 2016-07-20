package Jesa.testing;

import Jesa.core.AggregateRootEntity;

import java.util.concurrent.Callable;
import java.util.function.Consumer;

class AggregateCommandThenNoneStateBuilderImpl implements AggregateCommandThenNoneStateBuilder {
    private final Callable<AggregateRootEntity> sutFactory;
    private final Object[] givens;
    private final Consumer<AggregateRootEntity> when;

    public AggregateCommandThenNoneStateBuilderImpl(Callable<AggregateRootEntity> sutFactory, Object[] givens, Consumer<AggregateRootEntity> when) {
        this.sutFactory = sutFactory;
        this.givens = givens;
        this.when = when;
    }

    public EventCentricAggregateCommandTestSpecification build() {
        return new EventCentricAggregateCommandTestSpecification(sutFactory, givens, when, new Object[0]);
    }
}