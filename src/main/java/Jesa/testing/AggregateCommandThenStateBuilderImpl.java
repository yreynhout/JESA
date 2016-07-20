package Jesa.testing;

import Jesa.core.AggregateRootEntity;

import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class AggregateCommandThenStateBuilderImpl implements AggregateCommandThenStateBuilder {
    private final Callable<AggregateRootEntity> sutFactory;
    private final Object[] givens;
    private final Consumer<AggregateRootEntity> when;
    private final Object[] thens;

    public AggregateCommandThenStateBuilderImpl(Callable<AggregateRootEntity> sutFactory, Object[] givens,
                                            Consumer<AggregateRootEntity> when, Object[] thens) {
        this.sutFactory = sutFactory;
        this.givens = givens;
        this.when = when;
        this.thens = thens;
    }

    public AggregateCommandThenStateBuilder then(Object... events) {
        if (events == null) throw new IllegalArgumentException("events cannot be null");

        Stream<Object> stream = Stream.concat(Stream.of(thens), Stream.of(events));
        return new AggregateCommandThenStateBuilderImpl(sutFactory, givens, when, stream.toArray());
    }

    public EventCentricAggregateCommandTestSpecification build() {
        return new EventCentricAggregateCommandTestSpecification(sutFactory, givens, when, thens);
    }
}
