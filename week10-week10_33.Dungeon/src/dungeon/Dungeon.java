/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author gabriel
 */
public class Dungeon {

    private final int length;
    private final int height;
    private final int vampires;
    private int moves;
    private final boolean vampireMoves;
    private List<String> boardLines;
    private Player player;
    private List<Vampire> opponents;
    private Scanner reader;

    public Dungeon(int length, int height, int vampires, int moves, boolean vampireMoves) {
        this.length = length;
        this.height = height;
        this.vampires = vampires;
        this.moves = moves;
        this.vampireMoves = vampireMoves;
        this.boardLines = new ArrayList<String>();
        this.player = new Player(0, 0);
        this.reader = new Scanner(System.in);
    }

    public void run() {
        // initialize
        createVampires();
        createBoard();

        String commands = "";
        
        while (true) {
            // display board
            printLocations();
            placeActors();
            printBoard();
            
            if (moves > 0) {
                commands = reader.nextLine();
                processCommand(commands);
                if (victory()) {
                    break;
                }
            } 
            moves--;
            if (moves == 0) {
                System.out.println("YOU LOSE");
                break;
            }       
        }
    }

    private void createVampires() {
        opponents = new ArrayList<Vampire>();
        for (int i = 0; i < vampires; i++) {
            opponents.add(new Vampire(length, height));
        }
    }

    private void createBoard() {
        String line = "";
        for (int i = 0; i < length; i++) {
            line = line + ".";
        }

        for (int i = 0; i < height; i++) {
            boardLines.add(line);
        }
    }

    private void printLocations() {
        System.out.println(moves);
        System.out.println("");
        System.out.println(player);
        for (Vampire vampire : opponents) {
            System.out.println(vampire);
        }
        System.out.println("");
    }

    private void placeActors() {
        placeActor(player);
        for (Vampire vampire : opponents) {
            placeActor(vampire);
        }
    }

    private void placeActor(Actor actor) {
        int col = actor.getCol();
        int row = actor.getRow();
        String line = boardLines.get(row);
        String symbol = "";
        if (actor instanceof Player) {
            symbol = "@";
        } else {
            symbol = "v";
        }
        line = line.substring(0, col) + symbol + line.substring(col + 1);
        boardLines.set(row, line);
    }

    private void printBoard() {

        for (String line : boardLines) {
            System.out.println(line);
        }
        System.out.println("");
    }

    private void resetBoard() {
        for (int x = 0; x < height; x++) {
            String line = "";
            for (int y = 0; y < length; y++) {
                line = line + ".";
            }
            boardLines.set(x, line);
        }
    }
    
    private void processCommand(String commands) {
 
        String movement = "";
        for (int i = 0; i < commands.length(); i++) {
            movement = Character.toString(commands.charAt(i)); 
            if (movement.equals("w")) {
                player.moveUp();
            } else if (movement.equals("s")) {
                player.moveDown(height - 1);
            } else if (movement.equals("a")) {
                player.moveLeft(); 
            } else if (movement.equals("d")) {
                player.moveRight(length - 1); 
            }
            checkForHit();
        }

        if (vampireMoves) {
            for (Vampire vampire : opponents) {
                vampire.move(length, height);
            }
        } 
    }
    
    private void checkForHit() {
        int col = player.getCol();
        int row = player.getRow();
        
        List<Vampire> hit = new ArrayList<Vampire>();
        for (Vampire vampire : opponents) {
            if (vampire.getCol() == col && vampire.getRow() == row) {
                hit.add(vampire);
            }
        }
        
        for (Vampire vampire : hit) {
            if (opponents.contains(vampire)) {
                opponents.remove(vampire);
            }
        }
    }
    
    private boolean victory() {
        if (opponents.isEmpty()) {
            System.out.println("YOU WIN");
            return true;
        }
        return false;            
    }

}
