package com.verinite.bookstore.service;

import java.util.List;

import com.verinite.bookstore.entity.Book;

public interface BookService {
	public List<Book> getbooks();

	public Object getById(int book_id);

	public Book createBook(Book books);

	public String deleteBookById(int book_id);

	public Object updateBook(int book_id,Book books);



}
