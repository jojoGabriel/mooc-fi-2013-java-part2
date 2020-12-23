/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import gameoflife.GameOfLifeBoard;
import java.util.Random;

/**
 *
 * @author gabriel
 */
public class PersonalBoard extends GameOfLifeBoard {

    public PersonalBoard(int width, int height) {
        super(width, height);
    }

    @Override
    public void turnToLiving(int x, int y) {
        if (outsideBoard(x, y)) {
            return;
        }
        super.getBoard()[x][y] = true;

    }

    private boolean outsideBoard(int x, int y) {
        if (x < 0 || x >= super.getWidth()) {
            return true;
        }
        if (y < 0 || y >= super.getHeight()) {
            return true;
        }
        return false;
    }

    @Override
    public void turnToDead(int x, int y) {
        if (outsideBoard(x, y)) {
            return;
        }
        super.getBoard()[x][y] = false;

    }

    @Override
    public boolean isAlive(int x, int y) {
        if (outsideBoard(x, y)) {
            return false;
        }
        return super.getBoard()[x][y];
    }

    @Override
    public void manageCell(int x, int y, int livingNeighbours) {
        switch (livingNeighbours) {
            case 0:
            case 1:
                turnToDead(x, y);
                break;
            case 2:
                break;
            case 3:
                turnToLiving(x, y);
                break;
            default:
                turnToDead(x, y);
        }

    }

    @Override
    public int getNumberOfLivingNeighbours(int x, int y) {
        
        if (outsideBoard(x, y)) {
            return 0;
        }
        
        int alive = 0;  
        
        for (int c = x-1; c <= x + 1; c++) {
            for (int r = y - 1; r <= y + 1; r++) {
                if (isAlive(c, r)) {
                    alive = alive + 1;
                }
            }
        }
        
        if (isAlive(x, y)) {
            alive--;
        }
        
        return alive;
    }

    @Override
    public void initiateRandomCells(double probabilityForEachCell) {

        if (probabilityForEachCell == 0.0) {
            for (int x = 0; x < super.getWidth(); x++) {
                for (int y = 0; y < super.getHeight(); y++) {
                    super.getBoard()[x][y] = false;
                }
            }
            return;
        }
        
        if (probabilityForEachCell == 1.0) {
            for (int x = 0; x < super.getWidth(); x++) {
                for (int y = 0; y < super.getHeight(); y++) {
                    super.getBoard()[x][y] = true;
                }
            }
            return;
        }                
        
        for (int x = 0; x < super.getWidth(); x++) {
            for (int y = 0; y < super.getHeight(); y++) {
                if (new Random().nextDouble() <= probabilityForEachCell) {
                   super.getBoard()[x][y] = true;
                }                
            }
        }
    }

}
