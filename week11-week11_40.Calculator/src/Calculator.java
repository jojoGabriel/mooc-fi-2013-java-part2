/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gabriel
 */
public class Calculator {
    
    private int output;

    
    public Calculator() {
        output = 0;
    }
    
    public void add(int input) {
        output = output + input;
    }
    
    public void subtract(int input) {
        output = output - input;
    }
    
    public int getOutput() {
        return output;
    }
    
    public void zeroOut() {
        output = 0;
    }
    
    
}
