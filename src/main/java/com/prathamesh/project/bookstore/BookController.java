package com.prathamesh.project.bookstore;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import com.prathamesh.project.bookstore.entity.Book;
import com.prathamesh.project.bookstore.entity.MyBookList;
import com.prathamesh.project.bookstore.service.BookService;
import com.prathamesh.project.bookstore.service.MyBookListService;

@Controller
public class BookController {

	@Autowired
	private BookService service;

	@Autowired
	private MyBookListService myBookListService;

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/book_reg")
	public String bookregister() {
		return "bookregister";
	}

	@GetMapping("/ava_book")
	public ModelAndView avabook() {
		List<Book> list = service.avabook();
		return new ModelAndView("avabook", "book", list);
	}

	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b) {
		service.save(b);
		return "redirect:/ava_book";
	}

	@GetMapping("/my_books")
	public String getMyBooks(Model model) {

		List<MyBookList> list = myBookListService.getAllMyList();
		model.addAttribute("book", list);

		return "myBooks";

	}

	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		Book b = service.getBookById(id);

		MyBookList myBookList = new MyBookList(b.getId(), b.getName(), b.getAuthor(), b.getPrice());

		myBookListService.saveMyBooks(myBookList);
		return "redirect:/my_books";

	}

	@RequestMapping("/editbook/{id}")
	public String editbook(@PathVariable("id") int id, Model model) {

		Book b = service.getBookById(id);

		model.addAttribute("book", b);

		return "bookEdit";

	}

	@RequestMapping("/deletebook/{id}")
	public String deletebook(@PathVariable("id") int id, Model model) {

		service.deleteById(id);
		return "redirect:/ava_book";
	}

}
