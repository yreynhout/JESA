package Jesa.testing;

import Jesa.core.AggregateRootEntity;

import java.util.concurrent.Callable;
import java.util.function.Consumer;

class AggregateCommandGivenNoneStateBuilderImpl<TAggregateRoot extends AggregateRootEntity> implements AggregateCommandGivenNoneStateBuilder<TAggregateRoot> {
    private final Callable<AggregateRootEntity> _sutFactory;

    public AggregateCommandGivenNoneStateBuilderImpl(Callable<AggregateRootEntity> sutFactory) {
        _sutFactory = sutFactory;
    }

    public AggregateCommandWhenStateBuilder when(Consumer<TAggregateRoot> command) {
        if (command == null) throw new IllegalArgumentException("command cannot be null");
        return new AggregateCommandWhenStateBuilderImpl(_sutFactory, new Object[0], root -> command.accept((TAggregateRoot) root));
    }
}