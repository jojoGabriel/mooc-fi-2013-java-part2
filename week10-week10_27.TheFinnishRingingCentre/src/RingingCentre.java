
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
public class RingingCentre {
    
    private Map<Bird, List<String>> birds;
    
    public RingingCentre() {
        birds = new HashMap<Bird, List<String>>();
    }
    
    public void observe(Bird bird, String place) {
        if (birds.containsKey(bird)) {
            List<String> places = birds.get(bird);
            places.add(place);
            birds.replace(bird, places);
        } else {
            List<String> places = new ArrayList<String>();
            places.add(place);
            birds.put(bird, places);
        }
    }
    
    public void observations(Bird bird) {
        if (birds.containsKey(bird)) {
            List<String> locations = birds.get(bird);
            System.out.println(bird + " observations: " + locations.size());
            for (String loc : locations) {
                System.out.println(loc);
            }
        } else {
            System.out.println(bird + " observations: 0");
        }
    }
    
}
