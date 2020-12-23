
import java.util.HashMap;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        // Write your main program here. Implementing your own classes will be useful.
        Scanner reader = new Scanner(System.in);
        HashMap<String, Flight> flights = new HashMap<String, Flight>();
        HashMap<String, Airplane> planes = new HashMap<String, Airplane>();
        
        AirportPanel ap = new AirportPanel(reader, flights, planes);
        ap.start();
        
        FlightService fs = new FlightService(reader, planes, flights);
        fs.start();
    }
}
