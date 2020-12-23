
import java.io.File;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gabriel
 */
public class Printer {
    
    private String fileName;
    
    public Printer(String fileName) throws Exception {
        this.fileName = fileName;
    }
    
    public void printLinesWhichContain(String word) throws Exception {
        
        File f = new File(fileName);
        Scanner reader = new Scanner(f, "UTF-8");
        
        while (reader.hasNextLine()) {
            
            String line = reader.nextLine();
            if (word.isEmpty()) {
                System.out.println(line);
            } else if (line.contains(word)) {
                System.out.println(line);
            }
        }
    }
}
