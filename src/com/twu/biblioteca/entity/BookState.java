package com.twu.biblioteca.entity;

public enum BookState {
    CHECKED_OUT("CHECKED_OUT"), CHECKED_IN("CHECKED_IN");

    private String bookState;

    BookState(String bookState) {
        this.bookState = bookState;
    }
}
