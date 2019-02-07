package com.example.BookStore;

import java.awt.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.BookStore.domain.Book;
import com.example.BookStore.domain.BookRepository;

@SpringBootApplication
public class BookStoreApplication {
	@Autowired
	private BookRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			ArrayList<Book> books = new ArrayList<Book>();
			Book book = new Book();
			book.setAuthor("George Orwell");
			book.setTitle("Animal Farm");
			book.setIsbn("2212343-5");
			book.setYear(1945);
			book.setPrice(29);
			repository.save(book);
		};
	}
}

