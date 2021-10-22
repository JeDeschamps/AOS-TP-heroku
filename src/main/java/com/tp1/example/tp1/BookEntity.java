package com.tp1.example.tp1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    String name;

    String author;

    String isbn;

    public BookEntity() {
    }

    public BookEntity(String name, String author, String isbn) {
        this.name = name;
        this.author = author;
        this.isbn = isbn;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String esbn) {
        this.isbn = esbn;
    }

    public long getId() {
        return id;
    }
}
