package com.verinite.bookstore.serviceimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verinite.bookstore.entity.Book;
import com.verinite.bookstore.repository.BookRepository;
import com.verinite.bookstore.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookRepository bookRepo;

	@Override
	public List<Book> getbooks() {
		List<Book> booklist = new ArrayList<>();
		bookRepo.findAll().forEach(booklist::add);
		return booklist;
	}

	@Override
	public Object getById(int bookId) {
		try {
			bookRepo.findById(bookId).get();
			return bookRepo.getById(bookId);
		} catch (Exception e) {
			return "Id not Found";
		}
	}

	@Override
	public Book createBook(Book books) {
		books.setCreatedOn(new Date());
		books.setUpdatedOn(new Date());
		books.setDeleted(false);
		return bookRepo.save(books);
	}

	@Override
	public String deleteBookById(int bookId) {
		try {
			Book book = bookRepo.findById(bookId).get();
			if (!book.isDeleted()) {
				book.setDeleted(true);
				bookRepo.save(book);

				return "record Successfully deleted";
			} else {
				return "Given ID is already deleted";
			}
		} catch (Exception e) {
			return "Id not Found";
		}
	}

	@Override
	public Object updateBook(int bookId, Book books) {

		try {
			int id = bookId;

			Book book = bookRepo.findById(id).get();
			book.setBookTitle(books.getBookTitle());
			book.setBookPrice(books.getBookPrice());
			book.setDescription(books.getDescription());
			book.setPublisherId(books.getPublisherId());
			book.setUpdatedOn(new Date());

			return bookRepo.save(book);
		} catch (Exception e) {
			return "id is not present";

		}
	}

}
