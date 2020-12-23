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
    private Reader reader;
    private int stat=0;
    
    public Calculator() {
        reader = new Reader();
    }
    
    
    private void sum() {
        System.out.print("value1: ");
        int x = reader.readInteger();
        
        System.out.print("value2: ");
        int y = reader.readInteger();
        
        System.out.println("sum of the values " + (x + y));
        
        stat++;
    }
    
    
    private void difference() {
        System.out.print("value1: ");
        int x = reader.readInteger();
        
        System.out.print("value2: ");
        int y = reader.readInteger();
        
        System.out.println("difference of the values " + (x - y));
        
        stat++;
    }
    
    
    private void product() {
        System.out.print("value1: ");
        int x = reader.readInteger();
        
        System.out.print("value2: ");
        int y = reader.readInteger();
        
        System.out.println("product of the values " + (x * y));
        
        stat++;
    }
    
    
    private void statistics() {
        System.out.println("Calculations done " + stat);
    }
    
    
    public void start() {
        while (true) {
            System.out.print("command: ");
            String command = reader.readString();
            if (command.equals("end")) {
                break;
            }

            if (command.equals("sum")) {
                sum();
            } else if (command.equals("difference")) {
                difference();
            } else if (command.equals("product")) {
                product();
            }
        }

        statistics();
    }
}
