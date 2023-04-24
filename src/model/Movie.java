package model;

import java.util.Objects;

public class Movie extends Item {
    private int yearOfProduction;
    private String director;

    public Movie(String name, String director, int yearOfProduction, String genre, String description, int rating) {
        super(name, genre, description, rating);
        this.director = director;
        this.yearOfProduction = yearOfProduction;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Movie movie = (Movie) o;
        return yearOfProduction == movie.yearOfProduction && Objects.equals(director, movie.director);
    }

    @Override
    public int hashCode() {
        return Objects.hash(yearOfProduction, director);
    }

    @Override
    public String toString() {
        return getName() + ", year: " +
                yearOfProduction + ", director: " +
                director + ", genre: " +
                getGenre() + ", description: " +
                getDescription() + ", rating: " +
                getRating();
    }
}