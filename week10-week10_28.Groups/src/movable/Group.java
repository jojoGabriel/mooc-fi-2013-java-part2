/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movable;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabriel
 */
public class Group implements Movable {
    
    private List<Movable> objects = new ArrayList<Movable>();
    
    @Override
    public String toString() {
        String s = "";
        for (Movable m : objects) {
            s = s + m.toString() + "\n";
        }
        return s;
    }
    
    public void addToGroup(Movable movable) {
        objects.add(movable);
    }
    
    @Override
    public void move(int dx, int dy) {
        for (Movable m : objects) {
            m.move(dx, dy);
        }
    }
    
}
