
import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gabriel
 */
public class ShoppingBasket {
    
    private Map<String, Purchase> purchases;
    
    public ShoppingBasket() {
        purchases = new HashMap<String, Purchase>();
    }
    
    public void add(String product, int price) {
        if (purchases.containsKey(product)) {
            purchases.get(product).increaseAmount();
        } else {            
            purchases.put(product, new Purchase(product, 1, price));
        }
    }
    
    public int price() {
        int total = 0;
        for (Purchase p : purchases.values()) {
            total += p.price();
        }
        return total;
    }
    
    public void print() {
        for (Purchase p : purchases.values()) {
            System.out.println(p);
        }
    }
}
