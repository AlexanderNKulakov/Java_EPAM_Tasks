package javase04.t04;

import java.util.Comparator;

/**
 * Created by akulakov on 05.11.2015.
 */
public class FilmComparator implements Comparator<Film> {
    public int compare(Film film1, Film film2) {
        return film1.getFilmTitle().compareTo(film2.getFilmTitle());
    }
}
