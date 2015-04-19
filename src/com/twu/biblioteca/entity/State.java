package com.twu.biblioteca.entity;

public enum State {
    CHECKED_OUT("CHECKED_OUT"), CHECKED_IN("CHECKED_IN");

    private String bookState;

    State(String bookState) {
        this.bookState = bookState;
    }
}
