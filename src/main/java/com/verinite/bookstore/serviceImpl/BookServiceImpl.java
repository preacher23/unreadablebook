package com.verinite.bookstore.serviceImpl;

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
		bookRepo.findAll().forEach(books -> booklist.add(books));
		return booklist;
	}

	@Override
	public Object getById(int book_id) {
		try {
			bookRepo.findById(book_id).get();
			return bookRepo.getById(book_id);
		} catch (Exception e) {
			return "Id not Found";
		}
	}

	@Override
	public Book createBook(Book books) {
//        books.setDeleted(true);
		return bookRepo.save(books);
	}

	@Override
	public String deleteBookById(int book_id) {
		bookRepo.deleteById(book_id);

		return "delete succes";
	}

	@Override
	public Object updateBook(int book_id, Book books) {

		try {
			int bookid = books.getBook_id();

			Book book = bookRepo.findById(bookid).get();
			book.setBook_title(books.getBook_title());
			book.setBook_price(books.getBook_price());
			book.setDescription(books.getDescription());
			book.setPublisher_id(books.getPublisher_id());
			book.setUpdated_on(new Date());

			return bookRepo.save(book);
		} catch (Exception e) {
			String msg = "id is not present";
			return (Object) msg;

		}
	}

}
