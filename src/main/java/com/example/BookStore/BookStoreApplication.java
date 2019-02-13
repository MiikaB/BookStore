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
import com.example.BookStore.domain.Category;
import com.example.BookStore.domain.CategoryRepository;

@SpringBootApplication
public class BookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {
			Category category = new Category("Literature & Fiction");
			crepository.save(category);
			category = new Category("Health & Fitness");
			crepository.save(category);
			category = new Category("Parenting");
			crepository.save(category);
			category = new Category("Sci-fi & Fantasy");
			crepository.save(category);
			category = new Category("Computers & Tech");
			crepository.save(category);
			
			Book book = new Book("Ernest Hemingway", "A Farewell to Arms",1945,"2212343-5",29,crepository.findByName("Literature & Fiction").get(0));
			repository.save(book);
			book = new Book("George Orwell", "Animal Farm",1945,"2212343-5",29,crepository.findByName("Literature & Fiction").get(0));
			repository.save(book);
		};
	}
}

