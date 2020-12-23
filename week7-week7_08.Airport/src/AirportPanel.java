
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
public class AirportPanel {
    
    private Scanner reader;
    private HashMap<String, Flight> flights;
    private HashMap<String, Airplane> planes;
    
    public AirportPanel(Scanner reader, 
            HashMap<String, Flight> flights,
            HashMap<String, Airplane> planes) {
        this.reader = reader;
        this.flights = flights;
        this.planes = planes;
    }
    
    public void start() {
        System.out.println("Airport panel");
        System.out.println("--------------------");
        System.out.println("");
        
        String command = "";
        while(!command.equals("x")) {
            displayMenu();
            command = reader.nextLine();
            if (command.equals("1")) {
                addPlane();
            } else if (command.equals("2")) {
                addFlight();
            }
        }

    }
    
    private void displayMenu() {
        System.out.println("Choose operation:");
        System.out.println("[1] Add airplane");
        System.out.println("[2] Add flight");
        System.out.println("[x] Exit");        
    }
    
    private void addPlane() {      
        System.out.print("Give plane ID: ");
        String id = reader.nextLine();
        
        System.out.print("Give plane capacity: ");
        int capacity = Integer.parseInt(reader.nextLine());
        
        Airplane plane = new Airplane(id, capacity);
        
        planes.put(id, plane);
    }
    
    private void addFlight() {
        System.out.print("Give plane ID: ");
        String id = reader.nextLine();
        
        System.out.print("Give departure airport code: ");
        String departure = reader.nextLine();
        
        System.out.print("Give destination airport code: ");
        String destination = reader.nextLine();
        
        Airplane plane = planes.get(id);
        
        
        Flight flight = new Flight(plane, departure, destination);
        
        flights.put(flight.toString(), flight);
    }
    
}
