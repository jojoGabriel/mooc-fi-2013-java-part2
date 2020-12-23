/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author gabriel
 */
public class PersonalDuplicateRemover implements DuplicateRemover {

    private List<String> strings;

    public PersonalDuplicateRemover() {
        strings = new ArrayList<String>();
    }

    public void add(String characterString) {
        strings.add(characterString);
    }

    public int getNumberOfDetectedDuplicates() {
        Set<String> uniq = new HashSet<String>();
        int i = 0;
        for (String s : strings) {
            if (uniq.contains(s)) {
                i++;
            } else {
                uniq.add(s);
            }
        }
        return i;
    }

    public Set<String> getUniqueCharacterStrings() {
        Set<String> uniq = new HashSet<String>();
        for (String s : strings) {
            uniq.add(s);
        }
        return uniq;
    }
    
    public void empty() {
        strings.clear();
    }

}
