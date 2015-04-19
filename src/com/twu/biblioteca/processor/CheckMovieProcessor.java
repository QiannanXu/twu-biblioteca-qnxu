package com.twu.biblioteca.processor;

import com.twu.biblioteca.entity.Movie;
import com.twu.biblioteca.entity.State;

import java.util.List;

public class CheckMovieProcessor {
    private List<Movie> availableMovieList;
    private List<Movie> checkedOutMovieList;

    public CheckMovieProcessor(List<Movie> availableMovieList, List<Movie> checkedOutMovieList) {
        this.availableMovieList = availableMovieList;
        this.checkedOutMovieList = checkedOutMovieList;
    }

    public void showAvailableMovieList() {
        formatMovieListColumn();

        for (Movie movie : availableMovieList) {
            if (movie.getState().equals(State.CHECKED_IN)) {
                System.out.printf("%-5s", movie.getName());
                System.out.printf("%-20s", movie.getYear());
                System.out.printf("%-20s", movie.getDirector());
                System.out.printf("%-20s", movie.getRating());
                System.out.println();
            }
        }
        System.out.println("---------------------------------------------");
    }

    public void showCheckedOutMovieList() {
        formatMovieListColumn();

        for (Movie movie : checkedOutMovieList) {
            if (movie.getState().equals(State.CHECKED_OUT)) {
                System.out.printf("%-5s", movie.getName());
                System.out.printf("%-20s", movie.getYear());
                System.out.printf("%-20s", movie.getDirector());
                System.out.printf("%-20s", movie.getRating());
                System.out.println();
            }
        }
        System.out.println("---------------------------------------------");
    }

    private void formatMovieListColumn() {
        System.out.println("Here is the Movie list:");
        System.out.println("---------------------------------------------");
        System.out.printf("%-5s", "Name");
        System.out.printf("%-20s", "Year");
        System.out.printf("%-20s", "Director");
        System.out.printf("%-20s", "Rating");
        System.out.printf("\n");
        System.out.println("---------------------------------------------");
    }

    public List<Movie> getAvailableMovieList() {
        return availableMovieList;
    }

    public void setAvailableMovieList(List<Movie> availableMovieList) {
        this.availableMovieList = availableMovieList;
    }

    public List<Movie> getCheckedOutMovieList() {
        return checkedOutMovieList;
    }

    public void setCheckedOutMovieList(List<Movie> checkedOutMovieList) {
        this.checkedOutMovieList = checkedOutMovieList;
    }
}
