/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author gabriel
 */
public class PersonalMultipleEntryDictionary implements MultipleEntryDictionary {
    
    private Map<String, Set<String>> dict;
    
    public PersonalMultipleEntryDictionary() {
        this.dict = new HashMap<String, Set<String>>();        
    }
    
    public void add(String word, String entry) {
        if (!dict.containsKey(word)) {
            dict.put(word, new HashSet<String>());
        }
        
        dict.get(word).add(entry);
    }
    
    public Set<String> translate(String word) {
        Set<String> translations = new HashSet<String>();
        return dict.get(word);
    }
    
    public void remove(String word) {
        dict.remove(word);
    }
    
}
