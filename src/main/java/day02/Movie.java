package day02;

import java.util.List;
import java.util.Objects;

public class Movie {
    
    private String title;
    private int length;
    private List<String> actors;

    public Movie(String title, int length, List<String> actors) {
        this.title = title;
        this.length = length;
        this.actors = actors;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public List<String> getActors() {
        return actors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return getLength() == movie.getLength() && getTitle().equals(movie.getTitle()) && getActors().equals(movie.getActors());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getLength(), getActors());
    }

    @Override
    public String toString() {
        return title + ": " + length + ", " + actors;
    }

    public static String stSzoveg(Movie movie) {
        return "szovegStatic";
    }

    public String nsSzoveg() {
        return "NonStatic";
    }
}
