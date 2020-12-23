/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

import java.nio.charset.Charset;
import java.util.Random;

/**
 *
 * @author gabriel
 */
public class Cow implements Milkable, Alive {

    private static final String[] NAMES = new String[]{
        "Anu", "Arpa", "Essi", "Heluna", "Hely",
        "Hento", "Hilke", "Hilsu", "Hymy", "Ihq", "Ilme", "Ilo",
        "Jaana", "Jami", "Jatta", "Laku", "Liekki",
        "Mainikki", "Mella", "Mimmi", "Naatti",
        "Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
        "Rima", "Soma", "Sylkki", "Valpu", "Virpi"};

    private String name;
    private double udderCapacity;
    private double milkVolume;

    public Cow() {

        this.name = NAMES[new Random().nextInt(NAMES.length-1)];
        this.udderCapacity = genUdder();
        this.milkVolume = 0.0;

    }

    public Cow(String name) {
        this.name = name;
        this.udderCapacity = genUdder();
        this.milkVolume = 0;
    }

    private double genUdder() {
        return 15 + new Random().nextInt(26);
    }

    public String getName() {
        return name;
    }

    public double getCapacity() {
        return udderCapacity;
    }

    public double getAmount() {
        return milkVolume;
    }

    @Override
    public String toString() {
        return getName() + " " + Math.ceil(getAmount()) + "/" + getCapacity();
    }

    @Override
    public double milk() {
        double m = milkVolume;
        milkVolume = 0;
        return m;
    }

    @Override
    public void liveHour() {
        double milk = 0.7 + new Random().nextDouble() * 1.3;
        
        if (milk + milkVolume >= udderCapacity) {
            milkVolume = udderCapacity;
        } else {
            milkVolume += milk;
        }
            
    }

}
