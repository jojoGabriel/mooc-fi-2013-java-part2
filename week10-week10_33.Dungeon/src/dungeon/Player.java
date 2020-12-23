/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

/**
 *
 * @author gabriel
 */
public class Player implements Actor {
    
    private int col;
    private int row;
    
    public Player(int col, int row) {
        this.col = col;
        this.row = row;
    }
    
    public void move(int col, int row) {
        this.col = col;
        this.row = row;
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
        return "@ " + getCol() + " " + getRow();
    }
    
    public void moveUp() {
        if (row == 0) {
            return;
        }
        row--;
    }
    
    public void moveDown(int max) {
        if (row == max) {
            return;
        }
        row++;
    }
    
    public void moveRight(int max) {
        if (col == max) {
            return;
        }
        col++;
    }
    
    public void moveLeft() {
        if (col == 0) {
            return;
        }
        col--;
    }
    
}
