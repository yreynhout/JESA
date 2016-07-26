package Jesa.testing.commandScenarioForTests;

import Jesa.AggregateRootEntityStub;
import Jesa.core.AggregateRootEntity;
import Jesa.testing.CommandScenarioFor;
import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.Callable;

import static org.hamcrest.core.Is.is;

public class SutFactoryTests {

    @Test(expected = IllegalArgumentException.class)
    public void factoryCannotBeNull() {
        CommandScenarioFor<AggregateRootEntity> scenarioFor = new CommandScenarioFor((Callable<AggregateRootEntity>) null);
    }

    @Test
    public void factoryIsPartOfBuiltSpecification() throws Exception {
        AggregateRootEntityStub entity = new AggregateRootEntityStub();

        Callable<AggregateRootEntity> result =
                new CommandScenarioFor<AggregateRootEntityStub>(() -> entity)
                        .when(command -> {})
                        .then(new Object[0])
                        .build()
                        .sutFactory();

        Assert.assertThat(result.call(), is(entity));
    }
}
