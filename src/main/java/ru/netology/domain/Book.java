package ru.netology.domain;

public class Book extends Product {
    private String author;
    private int pages;

    public Book() {
    }

    public Book(int id, String name, int price, String author,int pages) {
        super(id, name, price);
        this.author = author;
        this.pages = pages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
       return pages;
    }

    public void setPages(){
        this.pages = pages;
    }
}
