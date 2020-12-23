
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
public class TextUserInterface {
    
    private Scanner reader;
    private Dictionary dictionary;
    
    public TextUserInterface(Scanner reader, Dictionary dictionary) {
        this.reader = reader;
        this.dictionary = dictionary;
    }
    
    public void start() {
        
        System.out.println("Statement: ");
        System.out.println("  add - adds a word pair to the dictionary");
        System.out.println("  translate - asks a word and prints its translation");
        System.out.println("  quit - quit the text user interface");
        
        String command = "";
        while (!command.equals("quit")) {
            command = reader.nextLine();
            if (command.equals("add")) {
                add();
            } else if (command.equals("translate")) {
                translate();
            }
        }      
        System.out.println("Cheers!");        
    }
    
    
    public void add() {       
        System.out.print("In Finnish: ");
        String word = reader.nextLine();
        
        System.out.print("Translation");
        String translation = reader.nextLine();
        
        dictionary.add(word, translation);
    }
    
    
    public void translate() {        
        System.out.print("Give a word: ");
        String word = reader.nextLine();
        System.out.println("Translation: " + dictionary.translate(word));
    }   
    
}
