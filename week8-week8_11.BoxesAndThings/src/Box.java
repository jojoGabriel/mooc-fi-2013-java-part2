
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
public class Box implements ToBeStored {
    private ArrayList<ToBeStored> storables;
    private double maxWeight;
    
    public Box(double maxWeight) {
        this.maxWeight = maxWeight;
        this.storables = new ArrayList<ToBeStored>();
    }
    
    public void add(ToBeStored thing) {
        
        if ((thing.weight() + this.weight()) <= maxWeight) {
            this.storables.add(thing);
        }
    }
    
    public double weight() {
        double totalWeight = 0;
        
        for (ToBeStored stored : this.storables) {
            totalWeight += stored.weight();
        }
        
        return totalWeight;
    }
    
    public String toString() {
        return String.format("Box: %d things, total weight %.1f kg", 
                this.storables.size(), this.weight());
    }
    
}
