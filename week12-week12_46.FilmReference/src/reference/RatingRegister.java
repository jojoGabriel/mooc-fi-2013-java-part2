/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

/**
 *
 * @author gabriel
 */
public class RatingRegister {
    
    private Map<Film, List<Rating>> films;
    private Map<Person, Map<Film, Rating>> persons;
    
    public RatingRegister() {
       films = new HashMap<Film, List<Rating>>(); 
       persons = new HashMap<Person, Map<Film, Rating>>();
    }
    
    public void addRating(Film film, Rating rating) {
        List<Rating> ratings = new ArrayList<Rating>();
        
        if(!films.containsKey(film)) {
            ratings.add(rating);
            films.put(film, ratings);
        } else {
            ratings = films.get(film);
            ratings.add(rating);
            films.replace(film, ratings);
        }
    }
    
    public void addRating(Person person, Film film, Rating rating) {
        Map<Film, Rating> filmRating = new HashMap<Film, Rating>();
        
        if (persons.containsKey(person)) {
            filmRating = persons.get(person);
            if (!filmRating.containsKey(film)) {
                filmRating.put(film, rating);
                persons.replace(person, filmRating);
                addRating(film, rating);
            }
        } else {
            filmRating.put(film, rating);
            persons.put(person, filmRating);
            addRating(film, rating);
        }
                
    }

    public List<Rating> getRatings(Film film) {
        if(films.containsKey(film)) {
            return films.get(film);
        }
        return null;
    }
    
    public Rating getRating(Person person, Film film) {
        Map<Film, Rating> filmRating = new HashMap<Film, Rating>();
        Rating rating = Rating.NOT_WATCHED;
        
        if (persons.containsKey(person)) {
            filmRating = persons.get(person);
            if(filmRating.containsKey(film)) {
                rating = filmRating.get(film);
            }
        }
        return rating;
    }
    
    public Map<Film, Rating> getPersonalRatings(Person person) {
        Map<Film, Rating> filmRating = new HashMap<Film, Rating>();
        if (persons.containsKey(person)) {
            filmRating = persons.get(person);
        }

        return filmRating;
    }
    
    public Map<Film, List<Rating>> filmRatings() {
        return films;
    }
    
    public List<Person> reviewers() {
        List<Person> reviewers = new ArrayList<Person>();
        Iterator<Person> peoples = persons.keySet().iterator();
        while(peoples.hasNext()) {
            reviewers.add(peoples.next());
        }        
        return reviewers;
    }
}
