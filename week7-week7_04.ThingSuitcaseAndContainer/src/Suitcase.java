
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gabriel
 */
public class Suitcase {
    
    private int maxWeight;
    private ArrayList<Thing> things;
            
    public Suitcase(int maxWeight) {
        this.maxWeight = maxWeight;
        this.things = new ArrayList<Thing>();
    }
    
    public void addThing(Thing thing) {
        if ((this.totalWeight() + thing.getWeight()) > this.maxWeight) {
           return; 
        }
        things.add(thing);
    }
    
    public String toString() {
        
        int size = this.things.size();        
        switch (size) {
            case 0:
                return "empty (0 kg)";
            case 1:
                return "1 thing (" + this.totalWeight() + " kg)";
            default:
                return String.format("%d things (%d kg)", this.things.size(), this.totalWeight());
        }
    }
    
    public void printThings() {
        for (Thing thing : this.things) {
            System.out.println(thing);
        }
    }
    
    public int totalWeight() {
        int total = 0;
        for (Thing thing : this.things) {
            total += thing.getWeight();
        }
        return total;
    }
    
    public Thing heaviestThing() {
        if (this.things.size() == 0) {
            return null;
        }
        
        int weight = 0;
        Thing thing = null;
        
        for (Thing t : this.things) {
            if (t.getWeight() > weight) {
                weight = t.getWeight();
                thing = t;
            }
        }
        return thing;
    }
}
