package Jesa.testing;

import Jesa.core.AggregateRootEntity;

import java.util.concurrent.Callable;
import java.util.function.Consumer;

class AggregateCommandThrowStateBuilderImpl implements AggregateCommandThrowStateBuilder {
    private final Callable<AggregateRootEntity> sutFactory;
    private final Object[] givens;
    private final Consumer<AggregateRootEntity> when;
    private final Exception throwsException;

    public AggregateCommandThrowStateBuilderImpl(Callable<AggregateRootEntity> sutFactory, Object[] givens,
                                             Consumer<AggregateRootEntity> when, Exception throwsException) {
        this.sutFactory = sutFactory;
        this.givens = givens;
        this.when = when;
        this.throwsException = throwsException;
    }

    public ExceptionCentricAggregateCommandTestSpecification build() {
        return new ExceptionCentricAggregateCommandTestSpecification(sutFactory, givens, when, throwsException);
    }
}
