package com.twu.biblioteca.processor;

import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.BookState;

import java.util.List;

public class CheckBookProcessor {
    private List<Book> availableBookList;
    private List<Book> checkedOutBookList;

    public CheckBookProcessor(List<Book> availableBookList, List<Book> checkedOutBookList) {
        this.availableBookList = availableBookList;
        this.checkedOutBookList = checkedOutBookList;
    }

    public void showAvailableBookList(){
        formatBookListColumn();

        for(Book book : availableBookList){
            if(book.getBookState().equals(BookState.CHECKED_IN)){
                System.out.printf("%-5s", book.getBookId());
                System.out.printf("%-20s", book.getBookName());
                System.out.printf("%-20s", book.getBookAuthor());
                System.out.printf("%-20s", book.getPublishedYear());
                System.out.println();;
            }
        }
        System.out.println("---------------------------------------------");
    }

    public void showCheckedOutBookList() {
        formatBookListColumn();

        for(Book book : checkedOutBookList){
            if(book.getBookState().equals(BookState.CHECKED_OUT)){
                System.out.printf("%-5s", book.getBookId());
                System.out.printf("%-20s", book.getBookName());
                System.out.printf("%-20s", book.getBookAuthor());
                System.out.printf("%-20s", book.getPublishedYear());
                System.out.println();;
            }
        }
        System.out.println("---------------------------------------------");
    }

    private void formatBookListColumn() {
        System.out.println("Here is the book list:");
        System.out.println("---------------------------------------------");
        System.out.printf("%-5s", "Id");
        System.out.printf("%-20s", "Name");
        System.out.printf("%-20s", "Author");
        System.out.printf("%-20s", "Year");
        System.out.printf("\n");
        System.out.println("---------------------------------------------");
    }

    public boolean checkOutBook(String bookId) {
        for(Book book : availableBookList){
            if(book.getBookId().equals(bookId)){
                book.setBookState(BookState.CHECKED_OUT);
                checkedOutBookList.add(book);
                availableBookList.remove(book);
                return true;
            }
        }
        return false;
    }

    public boolean returnBook(String bookId) {
        for(Book book : checkedOutBookList){
            if(book.getBookId().equals(bookId)){
                book.setBookState(BookState.CHECKED_IN);
                checkedOutBookList.remove(book);
                availableBookList.add(book);
                return true;
            }
        }
        return false;
    }

    public List<Book> getAvailableBookList() {
        return availableBookList;
    }

    public void setAvailableBookList(List<Book> availableBookList) {
        this.availableBookList = availableBookList;
    }

    public List<Book> getCheckedOutBookList() {
        return checkedOutBookList;
    }

    public void setCheckedOutBookList(List<Book> checkedOutBookList) {
        this.checkedOutBookList = checkedOutBookList;
    }
}
