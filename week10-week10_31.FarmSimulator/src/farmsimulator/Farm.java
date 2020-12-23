/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabriel
 */
public class Farm implements Alive {
    
    private String owner;
    private Barn barn;
    private List<Cow> cows;
    
    public Farm(String owner, Barn barn) {
        this.owner = owner;
        this.barn = barn;
        this.cows = new ArrayList<Cow>();
    }    
    
    
    public String getOwner() {
        return owner;
    }
    
    
    public void addCow(Cow cow) {
        cows.add(cow);
    }
    
    
    @Override
    public String toString() {
        String farm = "Farm ownwer: " + getOwner() + "\n";
        farm = farm + "Barn bul tank: " + barn.toString() + "\n";
        String animals = "";
        if (cows.isEmpty()) {
            animals = "No cows.\n";
        } else {
            farm = farm + "Animals:\n";
            for (Cow cow : cows) {
                animals = "        " + cow.toString() + "\n";
            }
        }
        return farm + animals;        
    }
    
    
    @Override
    public void liveHour() {
        for (Cow cow : cows) {
            cow.liveHour();
        }
    }
    
    
    public void manageCows() {
        barn.takeCareOf(cows);
    }
    
    public void installMilkingRobot(MilkingRobot mr) {
        barn.installMilkingRobot(mr);
    }
    
}
