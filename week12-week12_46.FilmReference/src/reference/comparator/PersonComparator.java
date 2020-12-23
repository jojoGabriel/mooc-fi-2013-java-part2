/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.comparator;

import java.util.Comparator;
import java.util.Map;
import reference.domain.Person;

/**
 *
 * @author gabriel
 */
public class PersonComparator implements Comparator<Person>{
    
    private Map<Person, Integer> peopleIdentities;
    
    public PersonComparator(Map<Person, Integer> peopleIdentities) {
        this.peopleIdentities = peopleIdentities;
    }
    
    @Override
    public int compare(Person first, Person second) {       
       if (peopleIdentities.get(first) == peopleIdentities.get(second)) {
           return 0;
       } else if (peopleIdentities.get(first) > peopleIdentities.get(second)) {
           return -1;
       } else {
           return 1;
       }
       
    } 
}
