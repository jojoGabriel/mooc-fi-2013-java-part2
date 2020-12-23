
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gabriel
 */
public class SortAgainstSuitAndValue implements Comparator<Card> {
    
    public int compare(Card c1, Card c2) {
        int x = c1.getSuit() - c2.getSuit();
        if (x == 0) {
            return c1.getValue() - c2.getValue();
        }
        return x;
    }
}
