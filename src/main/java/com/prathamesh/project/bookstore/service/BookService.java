package com.prathamesh.project.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prathamesh.project.bookstore.entity.Book;
import com.prathamesh.project.bookstore.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository prep;

	public void save(Book b) {
		prep.save(b);
	}

	public List<Book> avabook() {
		return prep.findAll();
	}

	public Book getBookById(int id) {
		return prep.findById(id).get();
	}

	public void deleteById(int id) {

		prep.deleteById(id);

	}

}
