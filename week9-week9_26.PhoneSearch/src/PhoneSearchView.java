
import java.util.List;
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
public class PhoneSearchView {
    
    private Scanner reader;  
    
    public PhoneSearchView(Scanner reader) {
        this.reader = reader;
    }
    
    public void displayMenu() {
        System.out.println("phone search");
        System.out.println("available operations:");
        System.out.println(" 1 add a number");
        System.out.println(" 2 search for a number");
        System.out.println(" 3 search for a person by phone number");
        System.out.println(" 4 add an address");
        System.out.println(" 5 search for personal information");
        System.out.println(" 6 delete personal information");
        System.out.println(" 7 filtered listing");
        System.out.println(" x quit");
    }
       
    public String getCommand() {
        System.out.println("");
        System.out.print("command: ");
        return reader.nextLine();
    }    
    
    // for Command 1 and 2
    public String getWhoseNumber() { 
        System.out.print("whose number: ");
        return reader.nextLine();
    }
    
  
    // for Command 1
    public String getNumber() {
        System.out.print("number: ");
        return reader.nextLine();
    }
    
    // for Command 2
    public void displayNumbers(List<String> phones) {
        if (phones.isEmpty()) {
            System.out.println("  not found");
            return;
        }
        for (String phone : phones) {
            System.out.println(" " + phone);
        }
    }
    
    // for Command 3 and 7
    public void displayName(String name) {
        System.out.println(" " + name);
    }
    
    // for Command 3
    public void displayMessage(String message) {
        System.out.println(message);
    }
      
    // for Command 4
    public String getWhoseAddress() {
        System.out.print("whose address: ");
        return reader.nextLine();
    }
    
    // for Command 4
    public String getStreet() {
        System.out.print("street: ");
        return reader.nextLine();
    }
    
    // for Command 4
    public String getCity() {
        System.out.print("city: ");
        return reader.nextLine();
    }
    
    
    // for Command 5 and 6
    public String getWhoseInformation() {
        System.out.print("whose information: ");
        return reader.nextLine();
    }
    
    // for Command 5 and 7
    public void displayAddresses(List<String> addresses) {
        if (addresses.isEmpty()) {
            displayMessage("  address unknown");
        }
        for (String address : addresses){
            System.out.println("  address: " + address);
        }        
    }
    
    // for Command 5 and 7
    public void displayPhoneNumbers(List<String> phones) {
        System.out.println("  phone numbers: ");
        for (String phone : phones) {
            System.out.println("   " + phone);
        }
    }
    
    // for Command 5
    public void displayInfo(List<String> addresses, List<String> phones ) {
        if (addresses.isEmpty()) {
            System.out.println("  " + "address unknown");
        } else {
            this.displayAddresses(addresses);
        }

        if (phones.isEmpty()) {
            System.out.println("  " + "phone number not found");
        } else {
            this.displayPhoneNumbers(phones);
        }

    }
    
    // for Command 7
    public String getKeyWord() {
        System.out.print("keyword (if empty, all listed): ");
        return reader.nextLine();
    }
    
    // for Command 7
    public void displayDataFound(String name, List<String> addresses, List<String> phones) {
        System.out.println("");
        this.displayName(name);
        this.displayAddresses(addresses);
        this.displayPhoneNumbers(phones);
    }
}
