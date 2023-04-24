package model;

import model.exceptions.GenreNotExistsException;

import java.util.Arrays;

public enum Genre {
    COMEDY("Comedy"),
    DRAMA("Drama"),
    SCI_FI("Science Fiction"),
    HORROR("Horror"),
    ADVENTURE("Adventure"),
    MUSICAL("Musical"),
    THRILLER("Thriller"),
    WAR("War"),
    WESTERN("Western");

    public final String description;

    Genre(String description) {
        this.description = description;
    }

    public static String convert(String genre) {
        Genre[] values = Genre.values();
        for (Genre value : values) {
            if (genre.equalsIgnoreCase(value.description)) {
                return value.description;
            }
        }
        throw new GenreNotExistsException("The provided genre does not exist.");
    }

    public static void printAllGenresToChoose() {
        Object[] objects = Arrays.stream(Genre.values()).map(genre -> genre.description).toArray();
        System.out.print(Arrays.toString(objects));
        System.out.println();
    }
}
