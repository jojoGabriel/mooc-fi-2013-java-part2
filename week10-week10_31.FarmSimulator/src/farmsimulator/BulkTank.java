/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

/**
 *
 * @author gabriel
 */
public class BulkTank {
    
    private double capacity;
    private double volume;
    
    public BulkTank() {
        this.capacity = 2000;
        this.volume = 0;
    }
    
    public BulkTank(double capacity) {
        this.capacity = capacity;
        this.volume = 0;
    }
    
    public double getCapacity() {
        return capacity;
    }
    
    public double getVolume() {
        return volume;
    }
    
    public double howMuchFreeSpace() {
        return capacity - volume;
    }
    
    public void addToTank(double amount) {
        if (amount < 0) {
            return;
        }
        
        if (amount <= this.howMuchFreeSpace()) {
            volume = volume + amount;
        } else {
            volume = capacity;
        }
    }
    
    public double getFromTank(double amount) {
        if (amount < 0) {
            return 0;
        }
        
        if (amount <= this.getVolume()) {
            volume = volume - amount;
            return amount;
        } else {
            double everything = volume;
            volume = 0.0;
            return everything;
        }        
    }
    
    @Override
    public String toString() {
        return Math.ceil(getVolume()) + "/" + Math.ceil(getCapacity());
    }
    
}
