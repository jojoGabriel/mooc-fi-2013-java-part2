/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moving.domain;

/**
 *
 * @author gabriel
 */
public class Item implements Thing, Comparable<Item> {
    
    private String name;
    private int volume;
    
    public Item (String name, int volume) {
        this.name = name;
        this.volume = volume;
    }
    
    @Override
    public int getVolume() {
        return volume;
    }
    
    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        return String.format("%s (%d dm^3)", name, volume);
    }
    
    @Override
    public int compareTo(Item another) {
        return this.getVolume() - another.getVolume();
    }
}
