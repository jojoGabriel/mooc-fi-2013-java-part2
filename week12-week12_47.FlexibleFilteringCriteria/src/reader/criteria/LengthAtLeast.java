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
public class LengthAtLeast implements Criterion {
    
    private int len;
    public LengthAtLeast(int len) {
        this.len = len;
    }
    
    @Override
    public boolean complies(String line) {
        return line.length() >= len;
    }
}
