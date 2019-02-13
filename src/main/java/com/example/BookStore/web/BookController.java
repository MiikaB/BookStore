package com.example.BookStore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import com.example.BookStore.domain.Book;
import com.example.BookStore.domain.BookRepository;
import com.example.BookStore.domain.CategoryRepository;


@Controller
public class BookController {
	@Autowired
	private BookRepository repository;
	@Autowired
	private CategoryRepository crepository;
	
	@RequestMapping(value="/booklist", method=RequestMethod.GET)

	public String bookList(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}
	@RequestMapping(value = "/addbook")
	public String addBook(Model model){
	model.addAttribute("book", new Book());
	model.addAttribute("categories",crepository.findAll());
	return "addbook";
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Book book){
	repository.save(book);
	return "redirect:booklist";
	}
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deletebook(@PathVariable("id") Long BookId, Model model) {
	repository.deleteById(BookId);
	return "redirect:../booklist";
	}
	@RequestMapping(value = "/editbook/{id}")
	public String addbook(@PathVariable("id") Long BookId, Model model){
		model.addAttribute("book", repository.findById(BookId));
		model.addAttribute("categories", crepository.findAll());
		return "editbook";
	}
}
