/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.domain;

import java.util.Objects;

/**
 *
 * @author gabriel
 */
public class Person {
    
    private String name;
    
    public Person(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        return getName();
    }
    
    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        
        if (otherObject == null) return false;
        
        if (getClass() != otherObject.getClass()) return false;
        
        Person other = (Person) otherObject;
        return name.equals(other.getName());
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
