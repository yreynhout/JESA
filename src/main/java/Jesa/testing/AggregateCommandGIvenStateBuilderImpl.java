package Jesa.testing;

import Jesa.core.AggregateRootEntity;

import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.stream.Stream;

import static java.util.stream.Stream.concat;

class AggregateCommandGivenStateBuilderImpl<TAggregateRoot extends AggregateRootEntity> implements AggregateCommandGivenStateBuilder<TAggregateRoot> {
    private final Callable<AggregateRootEntity> sutFactory;
    private final Object[] givens;

    public AggregateCommandGivenStateBuilderImpl(Callable<AggregateRootEntity> sutFactory, Object[] givens) {
        this.sutFactory = sutFactory;
        this.givens = givens;
    }

    public AggregateCommandGivenStateBuilder<TAggregateRoot> given(Object... events) {
        if (events == null) throw new IllegalArgumentException("events cannot be null");
        Stream<Object> stream = concat(Stream.of(givens), Stream.of(events));
        return new AggregateCommandGivenStateBuilderImpl<>(sutFactory, stream.toArray());
    }

    public AggregateCommandWhenStateBuilder when(Consumer<TAggregateRoot> command) {
        if (command == null) throw new IllegalArgumentException("command cannot be null");
        return new AggregateCommandWhenStateBuilderImpl(sutFactory, givens, root -> command.accept((TAggregateRoot) root));
    }
}