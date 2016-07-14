package Jesa.core;

public class Aggregate {
    private String identifier;
    private int expectedVersion;
    private AggregateRootEntity rootEntity;

    public Aggregate(String identifier, int expectedVersion, AggregateRootEntity rootEntity) {

        if(identifier == null)
            throw new IllegalArgumentException("identifier cannot be null");

        if(rootEntity == null)
            throw new IllegalArgumentException("rootEntity cannot be null");

        this.identifier = identifier;
        this.expectedVersion = expectedVersion;
        this.rootEntity = rootEntity;
    }

    public String getIdentifier() {
        return identifier;
    }

    public int getExpectedVersion() {
        return expectedVersion;
    }

    public AggregateRootEntity getRootEntity() {
        return rootEntity;
    }
}
