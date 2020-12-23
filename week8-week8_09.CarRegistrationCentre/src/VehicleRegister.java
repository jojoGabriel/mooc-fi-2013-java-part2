
import java.util.ArrayList;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gabriel
 */
public class VehicleRegister {
    
    private HashMap<RegistrationPlate, String> vehicleReg = 
            new HashMap<RegistrationPlate, String>();
      
    
    public boolean add(RegistrationPlate plate, String owner) {
        if (vehicleReg.get(plate) == null) {
            vehicleReg.put(plate, owner);
            return true;
        } else {
            return false;
        }
    }
    
    
    public String get(RegistrationPlate plate) {
        if(vehicleReg.containsKey(plate)) {
            return vehicleReg.get(plate);
        } else {
            return null;
        }
    }
    
    
    public boolean delete(RegistrationPlate plate) {
        if(vehicleReg.containsKey(plate)) {
            vehicleReg.remove(plate);
            return true;
        } else {
            return false;
        }
    }
    
    
    public void printRegistrationPlates() {
        for (RegistrationPlate plate : vehicleReg.keySet()) {
            System.out.println(plate);
        }
    }
    
    
    public void printOwners() {
        ArrayList<String> owners = new ArrayList<String>();
        String owner;
        
        for (RegistrationPlate plate : vehicleReg.keySet()) {
            owner = vehicleReg.get(plate);
            if (!owners.contains(owner)) {
                owners.add(owner);
            }
        }
        
        for (String o : owners) {
            System.out.println(o);
        }
    }
}
