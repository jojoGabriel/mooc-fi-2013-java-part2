
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
public class Container {
    
    private int maxWeight;
    private ArrayList<Suitcase> suitCases;
    
    public Container (int maxWeight) {
        this.maxWeight = maxWeight;
        this.suitCases = new ArrayList<Suitcase>();
    }
    
    public void addSuitcase(Suitcase suitcase) {
        if ((this.totalWeight() + suitcase.totalWeight()) > this.maxWeight) {
            return;
        }
        this.suitCases.add(suitcase);
    }
    
    public String toString() {
        return String.format("%d suitcases (%d kg)", 
                this.suitCases.size(),
                this.totalWeight());
    }
    
    public int totalWeight() {
        int totalWeight = 0;
        for (Suitcase suitCase : this.suitCases) {
            totalWeight += suitCase.totalWeight();
        }
        return totalWeight;
    }
    
    public void printThings() {
        for (Suitcase suitcase : this.suitCases) {
            suitcase.printThings();
        }
    }
}
