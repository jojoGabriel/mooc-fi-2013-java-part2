/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.Random;

/**
 *
 * @author gabriel
 */
public class Vampire implements Actor {
    
    private int col;
    private int row;
    
    public Vampire(int length, int height) {
        this.col = new Random().nextInt(length);
        this.row = new Random().nextInt(height);
    }
    
    public void move(int length, int height) {
        this.col = new Random().nextInt(length);
        this.row = new Random().nextInt(height);
    }
    
    @Override
    public int getCol() {
        return col;
    }
    
    @Override
    public int getRow() {
        return row;
    }
    
    @Override
    public String toString() {
        return "v " + getCol() + " " + getRow();
    }
}
