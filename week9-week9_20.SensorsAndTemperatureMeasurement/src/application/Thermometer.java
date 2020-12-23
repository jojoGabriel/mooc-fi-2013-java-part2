/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.Random;

/**
 *
 * @author gabriel
 */
public class Thermometer implements Sensor {
    
    private boolean on;
    
    public Thermometer() {
        this.on = false;
    }
    
    @Override
    public void on() {
        this.on = true;
    }
    
    @Override
    public void off() {
        this.on = false;
    }
    
    @Override
    public boolean isOn() {
        return this.on;
    }
    
    @Override
    public int measure() {
                 
        if (this.on) {
            Random r = new Random();
            return r.nextInt((30 - -30) + 1) + -30;
            
        } else {
            throw new IllegalStateException("Thermometer must be set to on before measuring");
        }
    }
    
}
