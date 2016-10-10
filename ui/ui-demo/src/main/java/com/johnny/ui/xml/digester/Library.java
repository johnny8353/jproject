package com.johnny.ui.xml.digester;

import java.util.ArrayList;
import java.util.List;


public class Library {
    private String name;
    private List<Book> bookList = new ArrayList<Book>();
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public List<Book> getBookList() {
        return bookList;
    }
    
    public void addBook(Book book) {
        bookList.add(book);
    }
}