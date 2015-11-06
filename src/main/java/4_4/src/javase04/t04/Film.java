package javase04.t04;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;

/**
 * Created by akulakov on 04.11.2015.
 */
public class Film implements Serializable {

    private String filmTitle;
    private Set<Actor> actors;

    public Film(String filmTitle) {
        actors = new HashSet<Actor>();
        this.filmTitle = filmTitle;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void addActor(Actor actor) {
        actors.add(actor);
    }

    public String getFilmTitle() {
        return filmTitle;
    }

    @Override
    public String toString() {
        return filmTitle + " " + actors;
    }

 //   @Override
 //   public int oompareTo(Film anotherFilm) {
 //       return filmTitle.compareTo(anotherFilm.filmTitle);
 //   }

}
