package Jesa.testing;

import Jesa.core.AggregateRootEntity;

import java.util.function.Consumer;

public interface AggregateCommandGivenNoneStateBuilder<TAggregateRoot extends AggregateRootEntity> {
    /**
     * When a command occurs.
     * @param command The command method invocation on the sut.
     * @return A builder continuation.
     */
    AggregateCommandWhenStateBuilder when(Consumer<TAggregateRoot> command);
}
