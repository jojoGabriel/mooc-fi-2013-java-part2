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
public class Both implements Criterion {
    
    private Criterion first;
    private Criterion second;
    
    public Both(Criterion first, Criterion second) {
        this.first = first;
        this.second = second;
    }
    
    @Override
    public boolean complies(String line) {
        return first.complies(line) && second.complies(line);
    }
    
}
