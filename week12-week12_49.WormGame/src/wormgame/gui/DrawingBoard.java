/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import wormgame.domain.Apple;
import wormgame.domain.Piece;
import wormgame.game.WormGame;

/**
 *
 * @author gabriel
 */
public class DrawingBoard extends JPanel implements Updatable {
    
    private WormGame wormGame;
    private int pieceLength;
    
    public DrawingBoard(WormGame wormGame, int pieceLength) {
        this.wormGame = wormGame;
        this.pieceLength = pieceLength;
    }
    
    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        
        for (Piece piece : wormGame.getWorm().getPieces()) {
            graphics.setColor(Color.BLACK);
            graphics.fill3DRect(piece.getX() * pieceLength, piece.getY() * pieceLength, pieceLength, pieceLength, true); 
        }
        
        Apple apple = wormGame.getApple();
        graphics.setColor(Color.RED);
        graphics.fillOval(apple.getX() * pieceLength, apple.getY() * pieceLength, pieceLength, pieceLength);

    }
    
    @Override
    public void update() {
        repaint();
    }
    
}
