
import java.util.Collections;
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
public class PhoneSearchApp {
    
    private Person person;
    private Scanner reader;
    private DataMap data;
    private PhoneSearchView view;
      
    public void start() {
        String command;
        reader = new Scanner(System.in);
        view = new PhoneSearchView(reader);
        data = new DataMap();
        
        view.displayMenu();
        while (true) {
            command = view.getCommand();
            if (command.equals("1")) {
                addANumber();
            } else if (command.equals("2")) {
                searchForANumber();
            } else if (command.equals("3")) {
                searchByNumber();
            } else if (command.equals("4")) {
                addAnAddress();
            } else if (command.equals("5")) {
                searchForInfo();
            } else if (command.equals("6")) {
                deleteInfo();
            } else if (command.equals("7")) {
                filterList();
            } else if (command.equals("x")) {
                break;
            }
        }
    }
    
    private void addANumber() {
        String name;
        String phone;
        
        name = view.getWhoseNumber();
        phone = view.getNumber();
        
        person = data.getPersonByName(name);
        if (person == null) {
            person = new Person(name, phone);
            data.addPerson(person);
            data.addPhone(person);
        } else {
            person.addPhone(phone);
            data.addPhone(person);
        }        
    }
    
    private void searchForANumber() {
        String name = view.getWhoseNumber();        
        person = data.getPersonByName(name);
        if (person == null) {
            view.displayMessage("  not found");
        } else {
            List<String> phones = person.getPhones();       
            view.displayNumbers(phones);
        }        
    }
    
    private void searchByNumber() {
        String number = view.getNumber();
        person = data.getPersonByNumber(number);
        if (person == null) {
            view.displayMessage(" not found");
        } else {
            view.displayName(person.getName());
        }
        
    }
    
    private void addAnAddress() {
        String name = view.getWhoseAddress();
        String street = view.getStreet();
        String city = view.getCity();
        person = data.getPersonByName(name);
        if (person == null) {
            person = new Person(name, new Address(street, city));
            data.addPerson(person);
            data.addAddress(person);
        } else {
            person.addAddress(new Address(street, city));
            data.addAddress(person);
        }

    }
    
    private void searchForInfo() {
        String name = view.getWhoseInformation();
        person = data.getPersonByName(name);
        if (person == null) {
            view.displayMessage("  not found");
        } else {
            List<String> addresses = person.getAddressesInString();
            List<String> phones = person.getPhones();
            view.displayInfo(addresses, phones);
        }


    }
    
    private void deleteInfo() {
        String name = view.getWhoseInformation();
        person = data.getPersonByName(name);
        if (person == null) {
            view.displayMessage(" not found");
        } else {
            data.delPerson(person);
        }
    }
    
    private void filterList() {
        List<Person> persons;
        String keyWord = view.getKeyWord();
        if (keyWord.isEmpty()) {
            persons = data.getPersons();
            Collections.sort(persons);
        } else {
            persons = data.searchKeyWord(keyWord);
        }

        if (persons.isEmpty()) {
            view.displayMessage(" keyword not found");
            return;
        }

        for (Person p : persons) {
            view.displayDataFound(p.getName(), p.getAddressesInString(), p.getPhones());
        }
    }   
    
}
