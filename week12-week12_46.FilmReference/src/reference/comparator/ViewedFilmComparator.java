/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reference.comparator;

import java.util.Comparator;
import java.util.Map;
import reference.domain.Film;
import reference.domain.Rating;

/**
 *
 * @author gabriel
 */
public class ViewedFilmComparator implements Comparator<Film>{
    
    private Map<Film, Rating> viewedFilms;
    
    public ViewedFilmComparator(Map<Film, Rating> viewedFilms) {
        this.viewedFilms = viewedFilms;
    }
    
    @Override
    public int compare(Film first, Film second) { 
        int x = viewedFilms.get(first).getValue();
        int y = viewedFilms.get(second).getValue();
        if (x == y) {
            return 0;
        } else if (x > y) {
            return -1;
        } else {
            return 1;
        }
    } 
}
