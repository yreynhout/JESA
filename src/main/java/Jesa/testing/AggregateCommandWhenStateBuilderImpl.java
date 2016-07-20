package Jesa.testing;

import Jesa.core.AggregateRootEntity;

import java.util.concurrent.Callable;
import java.util.function.Consumer;

public class AggregateCommandWhenStateBuilderImpl implements AggregateCommandWhenStateBuilder {
    private final Callable<AggregateRootEntity> sutFactory;
    private final Object[] givens;
    private final Consumer<AggregateRootEntity> when;

    public AggregateCommandWhenStateBuilderImpl(Callable<AggregateRootEntity> sutFactory, Object[] givens,
                                                Consumer<AggregateRootEntity> when) {
        this.sutFactory = sutFactory;
        this.givens = givens;
        this.when = when;
    }

    public AggregateCommandThenNoneStateBuilder thenNone() {
        return new AggregateCommandThenNoneStateBuilderImpl(sutFactory, givens, when);
    }

    public AggregateCommandThenStateBuilder then(Object... events) {
        if (events == null) throw new IllegalArgumentException("events cannot be null");
        return new AggregateCommandThenStateBuilderImpl(sutFactory, givens, when, events);
    }

    public AggregateCommandThrowStateBuilder throwsException(Exception exception) {
        if (exception == null) throw new IllegalArgumentException("exception can not be null");
        return new AggregateCommandThrowStateBuilderImpl(sutFactory, givens, when, exception);
    }
}
