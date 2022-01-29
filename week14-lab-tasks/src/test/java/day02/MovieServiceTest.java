package day02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovieServiceTest {


    MovieService movieService = new MovieService();
    Movie movie1 = new Movie("p1", 100, List.of("a1", "b2", "c3"));
    Movie movie2 = new Movie("p2", 200, List.of("e1", "f2", "g3"));
    Movie movie3 = new Movie("p1", 100, List.of("a1", "b2", "c3"));

    Movie mp1 = new Movie("cim1", 150, List.of("Nagy Sándor", "Kis Péter", "Zöld Piroska"));
    Movie mp2 = new Movie("cim2", 100, List.of("Fehér Péter", "Nagy Sándor", "Piros Alma"));

    @BeforeEach
        public void init() {
        movieService.addMovie(new Movie("cim1", 150, List.of("Nagy Sándor", "Kis Péter", "Zöld Piroska")));
        movieService.addMovie(new Movie("cim4", 120, List.of("Fekete Péter", "Kis Gábor", "Zöld Anna")));
        movieService.addMovie(new Movie("cim3", 180, List.of("Piros Alma", "Nagy Péter", "Zöld Alma")));
        movieService.addMovie(new Movie("cim2", 100, List.of("Fehér Péter", "Nagy Sándor", "Piros Alma")));
    }

    @Test
    void moviesByActor() {
        System.out.println(movieService.getMovieList());
        assertEquals(List.of(new Movie("cim1", 150, List.of("Nagy Sándor", "Kis Péter", "Zöld Piroska")),
                new Movie("cim2", 100, List.of("Fehér Péter", "Nagy Sándor", "Piros Alma"))), movieService.moviesByActor("Nagy Sándor"));
    }

    @Test
    void getLongest() {
        assertEquals(180, movieService.getMaxMin());
    }

    @Test
    void mr() {
        System.out.println(movieService.getMovieList().stream().map(Movie::getTitle).toList());
        System.out.println(movieService.getMovieList().stream().map(Movie::stSzoveg).toList());
        System.out.println(movieService.getMovieList().stream().map(Movie::nsSzoveg).toList());
        System.out.println(movieService.getMovieList().stream().map(this::other).toList());
        System.out.println(movieService.getMovieList().stream().map(MovieServiceTest::stOther).toList());
    }

    public String other(Movie movie) {
        return "other";
    }

    public static String stOther(Movie movie) {
        return "stOther";
    }
}