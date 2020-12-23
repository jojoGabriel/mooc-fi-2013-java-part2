/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author gabriel
 */
public class ContainerHistory {
    
    private List<Double> history;
            
    public ContainerHistory() {
        history = new ArrayList<Double>();
    }
    
    public void add(double situation) {
        history.add(situation);
    }
    
    public void reset() {
        history.clear();
    }
    
    public String toString() {
        return "" + history;
    }
    
    public double maxValue() {
        if (history.isEmpty()) {
            return 0;
        }
        return Collections.max(history);
    }
    
    public double minValue() {
        if (history.isEmpty()) {
            return 0;
        }
        return Collections.min(history);
    }
    
    public double average() {
        if (history.isEmpty()) {
            return 0;
        }
        Double sum = 0.0;
        for (Double d : history) {
            sum += d;
        }
        return sum / history.size();
    }
    
    public double greatestFluctuation() {
        
        double max = 0;
        double x, y, z;
        for (int i = 0; i < history.size() - 1; i++) {
            x = history.get(i);
            y = history.get(i+1);
            z = Math.abs(x-y);
            if (z > max) {
                max = z;
            }
        }
        return max;
       
    }
    
    public double variance() {
        if (history.isEmpty() || history.size() == 1) {
            return 0;
        }
        double mean = average();
        double sum = 0.0;
        for (Double d : history) {
            sum += Math.pow((d - mean),2);
        }
        return sum / (history.size() - 1);
    }
}
