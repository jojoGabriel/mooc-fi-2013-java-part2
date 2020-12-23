/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personnel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author gabriel
 */
public class Employees {
    
    private List<Person> employees;
    
    
    public Employees() {
        employees = new ArrayList<Person>();
    }
    
    
    public void add(Person person) {
        employees.add(person);
    }
    
    
    public void add(List<Person> persons) {
        for (Person person : persons) {
            employees.add(person);
        }         
    }
    
    public void print() {
        Iterator<Person> emp = employees.iterator();
        while (emp.hasNext()) {
            System.out.println(emp.next());
        }
    }
    
    public void print(Education education) {
        Iterator<Person> emp = employees.iterator();
        Person per;
        while (emp.hasNext()) {
            per = emp.next();
            if (education == per.getEducation()) {
                System.out.println(per);
            }
        }
    }
    
    public void fire(Education education) {
        Iterator<Person> emp = employees.iterator();
        while(emp.hasNext()) {
            if (emp.next().getEducation() == education) {
                emp.remove();
            }
        }
    }
}
