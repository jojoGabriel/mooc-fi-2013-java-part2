
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author gabriel
 */
public class DataMap {

    private ArrayList<Person> persons;
    private Map<String, Person> nameMap;
    private Map<String, Person> phoneMap;
    private Map<String, Person> addressMap;

    public DataMap() {
        persons = new ArrayList<Person>();
        nameMap = new HashMap<String, Person>();
        phoneMap = new HashMap<String, Person>();
        addressMap = new HashMap<String, Person>();
    }

    public void addPerson(Person person) {
        persons.add(person);
        nameMap.put(person.getName(), person);
    }

    public void addPhone(Person person) {
        for (String phone : person.getPhones()) {
            phoneMap.put(phone, person);
        }
    }

    public void addAddress(Person person) {
        for (String address : person.getAddressesInString()) {
            addressMap.put(address, person);
        }
    }

    public void delPerson(Person person) {
        if (nameMap.containsKey(person.getName())) {
            nameMap.remove(person.getName());
            for (String phone : person.getPhones()) {
                phoneMap.remove(phone);
            }
            for (String address : person.getAddressesInString()) {
                addressMap.remove(address);
            }
        }
    }
    

    public List<Person> searchKeyWord(String key) {
        List<Person> result = new ArrayList<Person>();
        searchInNameMap(key, result);
        searchInAddressMap(key, result);
        Collections.sort(result);
        return result;
    }

    private void searchInNameMap(String key, List<Person> result) {
        for (String name : nameMap.keySet()) {
            if (name.contains(key)) {
                result.add(nameMap.get(name));
            }
        }
    }

    private void searchInAddressMap(String key, List<Person> result) {
        for (String address : addressMap.keySet()) {
            if (address.contains(key)) {
                result.add(addressMap.get(address));
            }
        }
    }

    public boolean exist(String name) {
        if (nameMap.containsKey(name)) {
            return true;
        }
        return false;
    }

    public Person getPersonByName(String name) {       
        if (nameMap.containsKey(name)) {
            return nameMap.get(name);
        }
        return null;
    }

    public Person getPersonByNumber(String phone) {
        if (phoneMap.containsKey(phone)) {
            return phoneMap.get(phone);
        }
        return null;
    }

    public List<Person> getPersons() {
        return persons;
    }

}
