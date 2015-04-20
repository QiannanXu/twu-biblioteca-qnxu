package com.twu.biblioteca.user;

public class UserCredential {
    private String userName;
    private String libraryNumber;

    public UserCredential(String userName, String libraryNumber) {
        this.userName = userName;
        this.libraryNumber = libraryNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public void setLibraryNumber(String libraryNumber) {
        this.libraryNumber = libraryNumber;
    }

    @Override
    public String toString() {
        return "UserCredential{" +
                "userName='" + userName + '\'' +
                ", libraryNumber='" + libraryNumber + '\'' +
                '}';
    }
}
