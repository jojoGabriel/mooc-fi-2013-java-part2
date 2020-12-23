
import java.util.ArrayList;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gabriel
 */
public class Hand implements Comparable<Hand> {
    private ArrayList<Card> hand = new ArrayList<Card>();
    
    public void add(Card card) {
        hand.add(card);
    }
    
    public void print() {
        for (Card card : hand) {
            System.out.println(card);
        }
    }
    
    public void sort() {
        Collections.sort(hand);
    }
    
    @Override 
    public int compareTo(Hand other) {
        int x = 0;
        for (Card card : this.hand) {
            x += card.getValue();
        }
        
        int y = 0;
        for (Card card : other.hand) {
            y += card.getValue();
        }
        
        if (x == y) {
            return 0;
        } else if (x > y) {
            return 1;
        } else {
            return -1;
        }
    }
    
    public void sortAgainstSuit() {
        Collections.sort(hand, new SortAgainstSuitAndValue());
    }
}
