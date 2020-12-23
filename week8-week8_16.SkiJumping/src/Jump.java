
import java.util.Arrays;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gabriel
 */
public class Jump {
    
    private int length = 0;
    private int[] votes  = {0, 0, 0, 0, 0};
    private int point = 0;
    
    private Random random = new Random();

    
    public Jump() {
        genLength();
        genVotes();
        calcScore();
    }
    
    private void genLength() {
        this.length = 60 + random.nextInt(61);
    }
    
    private void genVotes() {
        for (int i = 0; i < 5; i++) {
            this.votes[i] = 10 + random.nextInt(11);
        }

    }
    
    private void calcScore() {
        int[] sorted = this.votes;
        Arrays.sort(sorted);
        
        this.point = this.length;
        for (int i = 1; i < 4; i++) {
            this.point += sorted[i];
        }          
    }
    
    public int getLength() {
        return this.length;
    }
    
    public int getPoint() {
        return this.point;   
    }
    
    public int[] getVotes() {
        return this.votes;
    }
    
}
