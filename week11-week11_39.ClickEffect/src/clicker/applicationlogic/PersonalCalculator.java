/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clicker.applicationlogic;

/**
 *
 * @author gabriel
 */
public class PersonalCalculator implements Calculator {
    
    private int counter;
    
    public PersonalCalculator() {
        counter = 0;
    }
    
    @Override
    public int giveValue() {
        return counter;
    }
    
    @Override
    public void increase() {
        counter++;
    }
    
}
