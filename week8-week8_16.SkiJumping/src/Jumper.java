
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
public class Jumper implements Comparable<Jumper> {
    
    private String name;
    private int points;
    private HashMap<Integer, Jump> jumps;

    public Jumper(String name) {
        this.name = name;
        this.points = 0;
        this.jumps = new HashMap<Integer, Jump>();
    }
    
    public String toString() {
        return String.format("%s (%d points)", this.name, this.points);
    }
    
    public void calcTotalPoints() {
        this.points = 0;
        for (Jump jump : jumps.values()) {
            this.points += jump.getPoint();
        }
    }
    
    public int getTotalPoints() {
        return this.points;
    }
        
    public int compareTo(Jumper other) {
        return this.getTotalPoints() - other.getTotalPoints();
    }
    
    public void addJump(int round, Jump jump) {
        jumps.put(round, jump);
        calcTotalPoints();
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getRoundLength(int round) {
        return jumps.get(round).getLength();
    }
    
    public String votesToString(int round) {
        int[] votes = jumps.get(round).getVotes();
        String string = "[";
        for (int i=0; i < 5; i++) {
            string += "" + votes[i];
            if (i < 4) {
                string += ", ";
            }
        }
        return string += "]";
    }
    
    public String lengthsToString() {
        String string = "jump lengths: ";        
        int i = 0;
        
        for (Jump jump : jumps.values()) {
            i++;
            string += jump.getLength() + " m";
            if (i < jumps.size()) {
                string += ", ";
            }            
        }
        
        return string;
    }
}
