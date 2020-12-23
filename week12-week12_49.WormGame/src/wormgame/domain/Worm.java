/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.domain;

import java.util.List;
import java.util.ArrayList;
import wormgame.Direction;

/**
 *
 * @author gabriel
 */
public class Worm {
    
    private int x;
    private int y;
    private Direction dir;
    private List<Piece> worm;
    private boolean grow;
    
    
    public Worm(int originalX, int originalY, Direction originalDirection) {
        x = originalX;
        y = originalY;
        dir = originalDirection;
        worm = new ArrayList<Piece>();
        worm.add(new Piece(x, y));
        grow = false;
    }
    
    
    public Direction getDirection() {
        return dir;
    }
    
    
    public void setDirection(Direction newDir) {
        dir = newDir;
    }
    
    
    public int getLength() {
        return worm.size();
    }
    
    
    public List<Piece> getPieces() {
        return worm;
    }
    
    
    public void move() {
        x = worm.get(getLength() - 1).getX();
        y = worm.get(getLength() - 1).getY();
        
        
        if (dir == Direction.UP) {
            y--;
        } 
        
        if (dir == Direction.DOWN) {
            y++;
        }
        
        if (dir == Direction.RIGHT) {
            x++;
        }
        
        if (dir == Direction.LEFT) {
            x--;
        }
        
        if (getLength() < 3) {
            worm.add(new Piece(x,y));
        } else {
            if (grow == false) {
                worm.remove(0);
            } else {
                grow = false;
            }
            worm.add(new Piece(x, y));
        }
    }
    
    public void grow() {
        if (getLength() >= 3) {
           grow = true;
        }
    }
    
    public boolean runsInto(Piece piece) {
        for (Piece wormPiece : worm) {
            if (wormPiece.getX() == piece.getX() &&
                wormPiece.getY() == piece.getY()) {
                return true;
            }
        }
        return false;
    }
    
    public boolean runsIntoItself() {
        for (int i = 0; i < getLength() - 1; i++) {
            for (int j = i+ 1; j < getLength(); j++) {
                if (worm.get(i).getX() == worm.get(j).getX() &&
                    worm.get(i).getY() == worm.get(j).getY()) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public Piece getHead() {
        return worm.get(getLength() - 1);
    }
}
