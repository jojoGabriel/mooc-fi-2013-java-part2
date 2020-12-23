/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reader.criteria;

/**
 *
 * @author gabriel
 */
public class AtLeastOne implements Criterion {
    
    public Criterion[] criteria;
    public AtLeastOne(Criterion... criteria) {
        this.criteria = criteria;
    }
    
    @Override
    public boolean complies(String line) {
        boolean pass = false;
        for (int i = 0; i < criteria.length; i++) {
            if (criteria[i].complies(line)) {
                return true;
            }
        }
        return pass;
    }
}
