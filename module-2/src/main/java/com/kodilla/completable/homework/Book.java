package com.kodilla.completable.homework;

public class Book {
    private String title;
    private String author;
    private int yearPublish;
    private String caption;

    public Book(String title, String author, int yearPublish, String caption) {
        this.title = title;
        this.author = author;
        this.yearPublish = yearPublish;
        this.caption = caption;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearPublish() {
        return yearPublish;
    }

    public String getCaption() {
        return caption;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYearPublish(int yearPublish) {
        this.yearPublish = yearPublish;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
}
