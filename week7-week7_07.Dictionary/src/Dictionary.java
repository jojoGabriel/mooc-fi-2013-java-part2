
import java.util.ArrayList;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gabriel
 */
public class Dictionary {
    
    private HashMap<String, String> dict;
    
    public Dictionary() {
        dict = new HashMap<String, String>();
    }
    
    public String translate(String word) {
        if (word.isEmpty()) {
            return null;
        }
        if (dict.containsKey(clean(word))) {
            return dict.get(word);
        } else {
            return null;
        }
    }
    
    public void add(String word, String translation) {
        dict.put(word, translation);
    }
    
    public String clean(String string) {
        if (string.isEmpty()) {
            return "";
        }
        return string.toLowerCase().trim();
    }
    
    public int amountOfWords() {
        return dict.size();
    }
    
    public ArrayList<String> translationList() {
        
        ArrayList<String> kv = new ArrayList<String>();
        String value;
                
        for (String key : dict.keySet()) {
            kv.add(key + " = " + dict.get(key));
        }
        
        return kv;
    }
    
}
