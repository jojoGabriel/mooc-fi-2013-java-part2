
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author gabriel
 */
public class Person implements Comparable<Person> {
    
    private String name;
    private List<Address> addresses;
    private List<String> phones;
    
    public Person(String name, String phone) {
        this.name = name;
        this.phones = new ArrayList<String>();
        this.addresses = new ArrayList<Address>();
        this.addPhone(phone);
    }

    public Person(String name, Address address) {
        this.name = name;
        this.phones = new ArrayList<String>();
        this.addresses = new ArrayList<Address>();
        this.addAddress(address);
    }
    
    public void addAddress(Address address) {
        addresses.add(address);
    }
    
    public List<String> getAddressesInString() {
        
        List<String> addressesInString = new ArrayList<String>();
        
        for (Address address : addresses) {
            addressesInString.add(address.toString());
        }
        
        return addressesInString;
    }
    
    public void addPhone(String phone) {
        phones.add(phone);
    }
    
    public List<String> getPhones() {
        return phones;
    }
    
    public String getName() {
        return name;
    }
    
    @Override
    public int compareTo(Person other) {
        return this.getName().compareTo(other.getName());
    }
    
    @Override
    public String toString() {
        return name + " " + addresses + " " + phones;
    }
}
