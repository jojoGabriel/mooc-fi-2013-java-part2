
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
public class PromissoryNote {
    
    private HashMap<String, Double> pn;
            
    public PromissoryNote() {
        pn = new HashMap<String, Double>();
    }
    
    public void setLoan(String toWhom, double value) {
        pn.put(stringCleaner(toWhom), value);
    }
    
    public double howMuchIsTheDebt(String whose) {
        if (pn.containsKey(stringCleaner(whose))) {
            return pn.get(stringCleaner(whose));
        }
        return 0.0;
    }
    
    public String stringCleaner(String string) {
        return string.toLowerCase().trim();
    }
    
}
