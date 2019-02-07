package com.example.BookStore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.data.repository.CrudRepository;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long id;
	public String title;
	public String author;
	public int year;
	public String isbn;
	public double price;
	
	public Book() {
		
	}
	
	public Book(String author, String title, int year, String isbn, double price, long id) {
		this.id = id;
		this.author = author;
		this.title = title;
		this.isbn = isbn;
		this.year = year;
		this.price = price;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Title: " + title + "Author: " + author + "Year" + year + "Isbn: " + isbn + "Price: " + price;
	}	
}