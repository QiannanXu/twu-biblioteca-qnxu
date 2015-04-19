package com.twu.biblioteca.entity;

public class Movie {
    private String name;
    private String year;
    private String director;
    private MovieRating rating;
    private State state;

    public Movie(String name, String year, String director, MovieRating rating, State state) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public MovieRating getRating() {
        return rating;
    }

    public void setRating(MovieRating rating) {
        this.rating = rating;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", year='" + year + '\'' +
                ", director='" + director + '\'' +
                ", rating='" + rating + '\'' +
                '}';
    }
}
