/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gabriel
 */
public class Flight {
    
    private Airplane airplane;
    private String departure;
    private String destination;
    
    public Flight(Airplane airplane, String departure, String destination) {
        this.airplane = airplane;        
        this.departure = departure;
        this.destination = destination;
    }
    
    public String toString() {
        return String.format("%s (%s-%s)", airplane, departure, destination);
    }
}
