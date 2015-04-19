package com.twu.biblioteca.entity;

public enum MovieRating {
    ONE("1"), TWO("2"), THREE("3"), FOUR("4"), FIVE("5"), SIX("6"), SEVEN("7"), EIGHT("8"), NINE("9"), TEN("10"), UN_RATED("unrated");

    private String movieRating;

    MovieRating(String movieRating) {
        this.movieRating = movieRating;
    }
}
