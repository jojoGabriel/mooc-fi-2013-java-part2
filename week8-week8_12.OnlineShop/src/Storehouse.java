
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gabriel
 */
public class Storehouse {
    
    private Map<String, Integer> price;
    private Map<String, Integer> stock;
    
    public Storehouse() {
        price = new HashMap<String, Integer>();
        stock = new HashMap<String, Integer>();
    }
    
    public void addProduct(String product, int price, int stock) {
        this.price.put(product, price);
        this.stock.put(product, stock);
    }
    
    public int price(String product) {
        if (price.containsKey(product)) {
            return price.get(product);
        } else {
            return -99;
        }
    }
    
    public int stock(String product) {
        if(stock.containsKey(product)) {
            return stock.get(product);
        }
        return 0;
    }
    
    public boolean take(String product) {
        if (stock.containsKey(product)) {
            int count = stock.get(product); 
            if (count > 0) {
                stock.put(product, --count);
                return true;
            }
        } 
        return false;
    }
    
    public Set<String> products() {
        Set<String> products = new HashSet<String>();
        for(String product : price.keySet()) {
            products.add(product);
        }
        return products;
    }
    
    
    
}
