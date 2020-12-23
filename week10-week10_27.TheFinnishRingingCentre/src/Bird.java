
import java.util.Objects;


public class Bird {

    private String name;
    private String latinName;
    private int ringingYear;

    public Bird(String name, String latinName, int ringingYear) {
        this.name = name;
        this.latinName = latinName;
        this.ringingYear = ringingYear;
    }


    @Override
    public String toString() {
        return this.latinName + " (" + this.ringingYear + ")";
    }
    
    @Override
    public boolean equals(Object otherObject) {

        if (this == otherObject) return true;
        
        if (otherObject == null) return false;
        
        if (getClass() != otherObject.getClass()) return false;
        
        Bird other = (Bird) otherObject;
        
        return Objects.equals(latinName, other.latinName)  && 
                ringingYear == other.ringingYear;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(latinName, ringingYear);
    }
    
    
}


