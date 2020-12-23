/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author gabriel
 */
public class Analysis {
    
    private File file;
    
    public Analysis(File file) {
        this.file = file;
    }
    
    public int lines() throws Exception {
        
        int lines = 0;
        String line;        
        Scanner s = new Scanner(file);
        
        while(s.hasNextLine()) {
            line = s.nextLine();
            lines = lines + 1;
        }
        
        return lines;
    }
    
    public int characters() throws Exception {
        int chars = 0;
        String line;
        
        Scanner s = new Scanner(file);
        
        while(s.hasNextLine()) {
            line = s.nextLine() + '\n';
            chars = chars + line.length();
        }
        
        return chars;
    }
    
}
