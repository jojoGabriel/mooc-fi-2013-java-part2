/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author gabriel
 */
public class MindfulDictionary {
    
    private Map<String, String> dictionary;
    private Scanner fileReader;
    private File file;
    
    public MindfulDictionary() {
        dictionary = new HashMap<String, String>();        
    }
    
    public MindfulDictionary(String file) {
        dictionary = new HashMap<String, String>();
        this.file = new File(file);
    }
    
    public boolean load() {
        try {
            fileReader = new Scanner(file);
        } catch (Exception e){
            return false;
        }
        while (fileReader.hasNextLine()) {
            String line = fileReader.nextLine();
            String[] parts = line.split(":");
            add(parts[0], parts[1]);
        }
        return true;
    }
    
    public void add(String word, String translation) {
        if (dictionary.containsValue(word)) {
            return;
        }
        dictionary.put(word, translation);
        dictionary.put(translation, word);
    }
    
    public String translate(String word) {
        return dictionary.get(word);
    }
    
    public void remove(String word) {
        String translation = translate(word);
        dictionary.remove(word);
        dictionary.remove(translation);
    }
    
    public boolean save() {
        Map<String, String> unique = new HashMap<String, String>();
        
        try {
            FileWriter writer = new FileWriter(file);
            for (Map.Entry entry : dictionary.entrySet()) {
                String key = (String) entry.getKey();
                String val = (String) entry.getValue();
                if (unique.containsKey(key) || unique.containsKey(val)) {
                    // do nothing
                } else {
                    unique.put(key, val);
                }
            } 
            
            for (Map.Entry entry : unique.entrySet()) {
                String key = (String) entry.getKey();
                String val = (String) entry.getValue();
                writer.write(key + ":" + val + "\n");
            }
            writer.close();
                
        } catch (Exception e) {
            return false;
        }
        return true;        
    }    
    
}
