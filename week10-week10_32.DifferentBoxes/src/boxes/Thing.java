package boxes;

import java.util.Objects;

public class Thing {

    private String name;
    private int weight;

    public Thing(String name, int weight) {
        
        if (weight < 0) {
            throw new IllegalArgumentException("The weight must be positive.");
        }
        this.name = name;
        this.weight = weight;
    }

    public Thing(String name) {
        this(name, 0);
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }
    
    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        
        if (otherObject == null) return false;
        
        if (getClass() != otherObject.getClass()) {
            return false;
        }
        
        Thing other = (Thing) otherObject;
        
        return Objects.equals(name, other.name);

    }
    
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
