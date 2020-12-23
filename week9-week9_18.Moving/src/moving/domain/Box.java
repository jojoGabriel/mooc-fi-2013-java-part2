/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moving.domain;

import java.util.ArrayList;

/**
 *
 * @author gabriel
 */
public class Box implements Thing {
    
    private int maximumCapacity;
    private ArrayList<Thing> contents;
    
    public Box(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
        this.contents = new ArrayList<Thing>();
    }
    
    public boolean addThing(Thing thing) {
        if ((this.getVolume() + thing.getVolume()) <= this.maximumCapacity) {
            this.contents.add(thing);
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public int getVolume() {
        
        int volume = 0;
        for (Thing content : this.contents) {
            volume += content.getVolume();
        }
        return volume;
    }
    
}
