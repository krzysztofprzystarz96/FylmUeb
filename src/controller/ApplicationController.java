package controller;

import controller.exceptions.OptionNotExistsException;
import datebase.ApplicationDatabase;
import datebase.exceptions.DuplicateException;
import io.ApplicationInputOutput;
import model.Actor;
import model.Movie;
import model.TvSeries;

import java.util.Arrays;
import java.util.Objects;

public class ApplicationController {

    private final ApplicationDatabase database = new ApplicationDatabase();
    private final ApplicationInputOutput reader = new ApplicationInputOutput();

    public void mainLoop() {
        try {
            printLine("FilmUeb by K.P.");
            int userOption;
            do {
                printLine("> ---------------");
                printOptions();
                printLine("> Choose option:");
                userOption = reader.readIntFromScanner();
                chooseOption(userOption);
            } while (userOption != Option.EXIT.getNumber());
        } catch (OptionNotExistsException e) {
            System.err.println("Chosen option is not available.");
        }
    }

    private void chooseOption(int userOption) {
        Option option = Arrays.stream(Option.values())
                .filter(x -> userOption == x.getNumber())
                .findFirst()
                .orElse(null);
        if (option == null) {
            System.err.println("Option (" + userOption + ") does not exist.");
        } else {
            switch (Objects.requireNonNull(option)) {
                case ADD_MOVIE -> addMovie();
                case ADD_TV_SERIES -> addTvSeries();
                case ADD_ACTOR -> addActor();
                case PRINT_ALL -> printAll();
                case EXIT -> exit();
                default -> throw new OptionNotExistsException("Chosen option is not available.");
            }
        }
    }

    private void addActor() {
        try {
            Actor actor = reader.createActor();
            database.addActor(actor);
        } catch (DuplicateException e) {
            System.err.println("Such actor already exists in our database.");
        }
    }

    private void addTvSeries() {
        try {
            TvSeries tvSeries = reader.createTvSeries();
            database.addTvSeries(tvSeries);
        } catch (DuplicateException e) {
            System.err.println("Such TV series already exists in our database.");
        }
    }

    private void addMovie() {
        try {
            Movie movie = reader.createMovie();
            database.addMovie(movie);
        } catch (DuplicateException e) {
            System.err.println("Such movie already exists in our database.");
        }
    }

    private void exit() {
        printLine("Goodbye!");
    }

    private void printAll() {
        print("Movies", database.getMovies());
        print("TV series", database.getTvSeries());
        print("Actors", database.getActors());
    }

    private static void print(String categoryName, Object[] objects) {
        System.out.println(categoryName);
        for (Object object : objects) {
            System.out.println(object);
        }
    }

    private void printOptions() {
        Arrays.stream(Option.values())
                .forEach(option -> printLine(option.optionToChoose()));
    }

    private void printLine(String text) {
        System.out.println(text);
    }
}