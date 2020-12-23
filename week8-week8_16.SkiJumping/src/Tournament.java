
import java.util.ArrayList;
import java.util.Collections;
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
public class Tournament {
    
    private ArrayList<Jumper> jumpers;
    private Scanner reader;
    private int round=0;
    
    public Tournament() {
        this.jumpers = new ArrayList<Jumper>();
        this.reader = new Scanner(System.in);
    }
    
    public void start() {
        register();
        beginTournament();
        endTournament();
    }
    
    private void register() {
        String name;
        
        System.out.println("Kumpula ski jumping week");
        System.out.println("");
        System.out.println("Write the names of the participants one at a time; an empty string brings you to the jumping phase.");
        
        while (true) {
            System.out.print("  Participant name: ");
            name = reader.nextLine();
            if (name.isEmpty()) {
                break;
            }
            jumpers.add(new Jumper(name));
        }
    }
    
    private void beginTournament() {
        String command;
        
        System.out.println("");
        System.out.println("The tournament begins!");
        
        while (true) {
            System.out.println("");
            System.out.print("Write \"jump\" to jump; otherwise you quit: ");
            command = reader.nextLine();
            if (command.equals("jump")) {
               jump();
            } else {
                break;
            }
        }
    }
    
    private void jump() {
        round++;
        Collections.sort(jumpers);
        
        System.out.println("");
        System.out.println("Round " + round);
        System.out.println("");
        System.out.println("Jumping order:");
        
        int i = 0;
        for (Jumper jumper : jumpers) {
            i++;
            System.out.println("  " + i + ". " + jumper);
            jumper.addJump(round, new Jump());
        }  
        
        System.out.println("");
        System.out.println("Results of round " + round);
        
        for (Jumper jumper : jumpers) {
            System.out.println("  " + jumper.getName());
            System.out.println("    length: " + jumper.getRoundLength(round));
            System.out.println("    judge votes: " + jumper.votesToString(round));
            // check the output of votes
        }
        
    }
    
    private void endTournament() {
        System.out.println("");
        System.out.println("Thanks!");
        System.out.println("");
        System.out.println("Tournament results:");
        
        Collections.sort(jumpers);
        Collections.reverse(jumpers);
        
        System.out.println("Position    Name");
        
        int pos = 0;
        for (Jumper jumper : jumpers) {
            pos++;
            System.out.println(pos + "           " + jumper);
            System.out.println("            " + jumper.lengthsToString());
        }
        
    }
}
