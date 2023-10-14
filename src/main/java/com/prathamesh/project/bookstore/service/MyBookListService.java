package com.prathamesh.project.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prathamesh.project.bookstore.entity.MyBookList;
import com.prathamesh.project.bookstore.repository.MyBookRepository;

@Service
public class MyBookListService {

	@Autowired
	private MyBookRepository myBookRepository;

	public void saveMyBooks(MyBookList book) {

		myBookRepository.save(book);

	}

	public List<MyBookList> getAllMyList() {
		return myBookRepository.findAll();
	}

	public void deleteById(int id) {

		myBookRepository.deleteById(id);

	}

}
