/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import reference.comparator.FilmComparator;
import reference.comparator.PersonComparator;
import reference.comparator.ViewedFilmComparator;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

/**
 *
 * @author gabriel
 */
public class Reference {

    private RatingRegister register;

    public Reference(RatingRegister register) {
        this.register = register;
    }

    public Film recommendFilm(Person person) {
        Map<Film, List<Rating>> filmRatings = register.filmRatings();
        Map<Film, Rating> personalRatings = register.getPersonalRatings(person);

        if (personalRatings.isEmpty()) {
            return getBestFilm(filmRatings);

        } else {
            // Iterator<Film> ratedFilms = personalRatings.keySet().iterator();
            List<Film> ratedFilms = new ArrayList<Film>();
            ratedFilms.addAll(personalRatings.keySet());
            
            List<Person> reviewers = register.reviewers();
            Film film = null;
            Map<Person, Integer> similars = new HashMap<Person, Integer>();

            Rating disRating, otherRating;
            for (Film flix : ratedFilms) {
                for (Person viewer : reviewers) {
                    
                    // skip if same person
                    if (person.equals(viewer)) {
                        continue;
                    }

                    // get the film ratings
                    disRating = register.getRating(person, flix);
                    otherRating = register.getRating(viewer, flix);

                    // calculate and store scores
                    if (disRating != null && otherRating != null) {
                        int xScore = disRating.getValue() * otherRating.getValue();
                        if (similars.containsKey(viewer)) {
                            int yScore = similars.get(viewer);
                            similars.replace(viewer, xScore + yScore);
                        } else {
                            similars.put(viewer, xScore);
                        }
                    }
                }
            }
            
            // determine the most-similar viewer
            List<Person> viewers = new ArrayList<Person>();
            viewers.addAll(similars.keySet());
            Collections.sort(viewers, new PersonComparator(similars));
            
            // sort the films watched by the most-similar viewer
            Person similar = viewers.get(0);
            Map<Film, Rating> filmRated = register.getPersonalRatings(similar);           
            List<Film> viewedFilms = new ArrayList<Film>();
            viewedFilms.addAll(filmRated.keySet());
            Collections.sort(viewedFilms, new ViewedFilmComparator(filmRated));
            
            // 
            film = null;            
            for (Film flix : viewedFilms) {
                Rating pRate = register.getRating(person, flix);
                Rating sRate = register.getRating(similar, flix);
                if(pRate == Rating.NOT_WATCHED) {
                    if (sRate.getValue() == Rating.FINE.getValue() || 
                        sRate.getValue() == Rating.GOOD.getValue()) {
                        return flix;
                    }
                }
            }

            return film;
        }
    }

    private Film getBestFilm(Map<Film, List<Rating>> filmRatings) {
        List<Film> films = new ArrayList<Film>();
        films.addAll(filmRatings.keySet());
        Collections.sort(films, new FilmComparator(filmRatings));
        return films.get(0);
    }

}
