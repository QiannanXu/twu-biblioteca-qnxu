package com.twu.biblioteca.user;

import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.Movie;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String userName;
    private String libraryNumber;
    private String password;
    private String emailAddress;
    private String phoneNumber;
    private List<Book> checkedOutBookList;
    private List<Movie> checkedOutMovieList;

    public User(String userName, String libraryNumber, String password, String emailAddress, String phoneNumber) {
        this.userName = userName;
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        checkedOutBookList = new ArrayList<>();
        checkedOutMovieList = new ArrayList<>();
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public void setLibraryNumber(String libraryNumber) {
        this.libraryNumber = libraryNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Book> getCheckedOutBookList() {
        return checkedOutBookList;
    }

    public void setCheckedOutBookList(List<Book> checkedOutBookList) {
        this.checkedOutBookList = checkedOutBookList;
    }

    public List<Movie> getCheckedOutMovieList() {
        return checkedOutMovieList;
    }

    public void setCheckedOutMovieList(List<Movie> checkedOutMovieList) {
        this.checkedOutMovieList = checkedOutMovieList;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
