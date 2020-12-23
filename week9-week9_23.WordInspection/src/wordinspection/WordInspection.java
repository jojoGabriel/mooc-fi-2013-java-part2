/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordinspection;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author gabriel
 */
public class WordInspection {
    
    private File file;
    private List<String> words;
    
    public WordInspection(File file) throws Exception {
        this.file = file;
        this.words = new ArrayList<String>();
        loadWords();
    }
    
    private void loadWords() throws Exception {
        Scanner s = new Scanner(file);
        while (s.hasNextLine()) {
            words.add(s.nextLine());
        }
    }
    
    public int wordCount() {       
        return this.words.size();        
    }
    
    public List<String> wordsContainingZ() {               
        List<String> withZ = new ArrayList<String>();
        for (String s : this.words) {
            if (s.contains("z")) {
                withZ.add(s);
            }
        }
        return withZ;        
    }
    
    public List<String> wordsEndingInL() {
        List<String> endInL = new ArrayList<String>();
        for (String s : words) {
            if (s.endsWith("l")) {
                endInL.add(s);
            }
        }
        return endInL;
    }
    
    public List<String> palindromes() {
        List<String> p = new ArrayList<String>();
        String y;
        
        for (String x : words) {
            y = "";
            for (int i = x.length() - 1; i >= 0; i--) {
                y = y + x.charAt(i);
            }
            if (x.equalsIgnoreCase(y)) {
                p.add(x);
            }

        }
       
        return p;
    }
    
    public List<String> wordsWhichContainAllVowels() {
        List<String> vowelWords = new ArrayList<String>();
        char[] vowels = "aeiouyäö".toCharArray();
        boolean found;
        
        for (String word : words) {
            found = true;
            
            for (char c : vowels) {
                if (!word.contains("" + c)) {         
                    found = false;
                    break;
                }
            }
            
            if (found) {
                vowelWords.add(word);
            }
            
        }
        
        return vowelWords;
    }
}
