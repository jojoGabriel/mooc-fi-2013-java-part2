/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import reference.domain.Film;
import reference.domain.Rating;

/**
 *
 * @author gabriel
 */
public class FilmComparator implements Comparator<Film> {

    private Map<Film, List<Rating>> ratings;

    public FilmComparator(Map<Film, List<Rating>> ratings) {
        this.ratings = ratings;
    }

    @Override
    public int compare(Film first, Film second) {
        List<Rating> filmRating = new ArrayList<Rating>();
        int firstAvg, secondAvg;

        filmRating = ratings.get(first);
        int sum = 0;
        for (Rating rating : filmRating) {
            sum = sum + rating.getValue();
        }
        firstAvg = (int) sum / filmRating.size();

        filmRating = ratings.get(second);
        sum = 0;
        for (Rating rating : filmRating) {
            sum = sum + rating.getValue();
        }
        secondAvg = (int) sum / filmRating.size();

        if (firstAvg == secondAvg) {
            return 0; 
        } else if (firstAvg > secondAvg) {
            return -1;
        } else {
            return 1;
        }

    }
}
