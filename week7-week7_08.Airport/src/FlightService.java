
import java.util.HashMap;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gabriel
 */
public class FlightService {
    
    private Scanner reader;
    private HashMap<String, Airplane> airplanes;
    private HashMap<String, Flight> flights;
            
    public FlightService(Scanner reader, HashMap<String, Airplane> airplanes, 
            HashMap<String, Flight> flights) {
        this.reader = reader;
        this.airplanes = airplanes;
        this.flights = flights;
    }
    
    public void printPlanes() {      
       //  System.out.println(airplanes.keySet());
        for (String id : airplanes.keySet()) {
            // System.out.println(id);
            System.out.println(airplanes.get(id));
        }
    }
    
    public void printFlights() {
        for (String id : flights.keySet()) {
            System.out.println(flights.get(id));
        }
    }
    
    public void start() {
        System.out.println("Flight service");
        System.out.println("------------");
        System.out.println("");        
        
        String command = "";
        while (!command.equals("x")) {
            displayMenu();
            command = reader.nextLine();
            if (command.equals("1")) {
                printPlanes();
            } else if (command.equals("2")) {
                printFlights();
            } else if (command.equals("3")) {
                printPlaneInfo();
            }
        }
    }
    
    private void displayMenu() {
        System.out.println("Choose operation:");
        System.out.println("[1] Print planes");
        System.out.println("[2] Print flights");
        System.out.println("[3] Print plane info");
        System.out.println("[x] Quit");  
    }
    
    private void printPlaneInfo() {
        System.out.print("Give plane ID:");
        String id = reader.nextLine();
        Airplane airplane = airplanes.get(id);
        System.out.println(airplane);
    }
}
