package com.twu.biblioteca.user;

import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.Movie;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String userName;
    private String libraryNumber;
    private String emailAddress;
    private String phoneNumber;
    private List<String> checkedOutBookList;
    private List<String> checkedOutMovieList;

    public User(String userName, String libraryNumber, String emailAddress, String phoneNumber) {
        this.userName = userName;
        this.libraryNumber = libraryNumber;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        checkedOutBookList = new ArrayList<>();
        checkedOutMovieList = new ArrayList<>();
    }

    public void checkOutBook(String bookId){
        checkedOutBookList.add(bookId);
    }

    public void returnBook(String bookId){
        checkedOutBookList.remove(bookId);
    }

    public void checkOutMovie(String movieId){
        checkedOutMovieList.add(movieId);
    }

    public void returnMovie(String movieId){
        checkedOutMovieList.remove(movieId);
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public void setLibraryNumber(String libraryNumber) {
        this.libraryNumber = libraryNumber;
    }

    public List<String> getCheckedOutBookList() {
        return checkedOutBookList;
    }

    public void setCheckedOutBookList(List<String> checkedOutBookList) {
        this.checkedOutBookList = checkedOutBookList;
    }

    public List<String> getCheckedOutMovieList() {
        return checkedOutMovieList;
    }

    public void setCheckedOutMovieList(List<String> checkedOutMovieList) {
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

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", libraryNumber='" + libraryNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", checkedOutBookList=" + checkedOutBookList +
                ", checkedOutMovieList=" + checkedOutMovieList +
                '}';
    }
}
