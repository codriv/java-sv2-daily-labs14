package day02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MovieService {

    private List<Movie> movieList = new ArrayList<>();

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void addMovie(Movie movie) {
        movieList.add(movie);
    }

    public List<Movie> moviesByActor(String actor) {
        return movieList.stream()
                .filter(movie -> movie.getActors().contains(actor))
                .collect(Collectors.toList());
    }

    public int getMaxMin() {
        return movieList.stream()
                .mapToInt(Movie::getLength)
                .max()
                .orElseThrow(()->new IllegalArgumentException("Nothing or more!"));
    }
}
