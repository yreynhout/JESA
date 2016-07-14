package Jesa.AggregateRootEntityTests;

import Jesa.core.AggregateRootEntityBase;

import java.util.Arrays;

/**
 * For unit testing aggregate root entities that have been initialized.
 */
public class InitializedRootEntity extends AggregateRootEntityBase {

    public InitializedRootEntity() {
        initialize(Arrays.asList(new Object(), new Object()));
    }
}
