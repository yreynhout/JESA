package Jesa;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class WithInterceptorInstance {
    private final InterceptorAggregateRootEntity sut;

    public WithInterceptorInstance() {
        sut = new InterceptorAggregateRootEntity();
        sut.applyEvent(new Object());
    }

    @Test
    public void beforeApplyChangesWasCalled() {
        assertThat(sut.beforeChangesWasCalled(), is(true));
    }

    @Test
    public void afterApplyChangesWasCalled() {
        assertThat(sut.afterChangesWasCalled(), is(true));
    }
}
