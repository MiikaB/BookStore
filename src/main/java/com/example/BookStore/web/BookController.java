package com.example.BookStore.web;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import com.example.BookStore.domain.Book;
import com.example.BookStore.domain.BookRepository;


@Controller
public class BookController {
	@Autowired
	private BookRepository repository;
	private ArrayList<Book> book = new ArrayList<Book>();
	@RequestMapping(value="/booklist", method=RequestMethod.GET)
	public String BookStore(Model model) {
		model.addAttribute("book", repository.findAll());
		return ("booklist");
	}
}
