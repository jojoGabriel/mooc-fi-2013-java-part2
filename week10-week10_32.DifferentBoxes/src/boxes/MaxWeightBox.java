/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabriel
 */
public class MaxWeightBox extends Box {
    
    private int maxWeight;
    private List<Thing> things;
    
    public MaxWeightBox(int maxWeight) {
        this.maxWeight = maxWeight;
        this.things = new ArrayList<Thing>();
    }
    
    @Override
    public void add(Thing thing) {
        if (totalWeight() + thing.getWeight() > maxWeight) {
            return;
        }
        things.add(thing);
    }
    
    @Override
    public boolean isInTheBox(Thing thing) {
        for (Thing thingy : things) {
            if(thingy.equals(thing)) {
                return true;
            }
        }
        return false;
    }
    
    public int totalWeight() {
        int sum = 0;
        for (Thing thing : things) {
            sum = sum + thing.getWeight();
        }
        return sum;
    }

    
}
