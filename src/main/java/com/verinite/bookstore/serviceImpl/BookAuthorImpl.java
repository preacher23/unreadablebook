package com.verinite.bookstore.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verinite.bookstore.entity.BookAuthor;
import com.verinite.bookstore.repository.BookAuthorRepository;
import com.verinite.bookstore.service.BookAuthorService;

@Service
public class BookAuthorImpl implements BookAuthorService {

	private BookAuthorRepository bookAuthorRepo;

	@Autowired
	BookAuthorImpl(BookAuthorRepository bookAuthorRepo) {
		this.bookAuthorRepo = bookAuthorRepo;
	}

	@Override
	public BookAuthor saveBookAuthor(BookAuthor bookauthor) {
//		bookauthor.setCreated_on(new Date());
//		bookauthor.setUpdated_on(new Date());

		// to save entity in db
		return bookAuthorRepo.save(bookauthor);

	}

	@Override
	public List<BookAuthor> allBookAuthor() {
		// find is a custom query which shows all fields sorted by id in ascending order

		return bookAuthorRepo.find();
	}

	@Override
	public Object displayById(int id) {

		Optional<BookAuthor> bookauthor = bookAuthorRepo.findById(id);
		if (bookauthor.isPresent()) {
			return bookauthor.get();
		} else {
			String s = "record is not present to show with the id of " + id;
			return (Object) s;
		}
	}

	@Override
	public Object updateBookAuthor(int id, BookAuthor bookauthor) {
		try {
			BookAuthor oldBookAuthorTable = (BookAuthor) bookAuthorRepo.findById(id).get();

			oldBookAuthorTable.setBook_id(bookauthor.getBook_id());
			oldBookAuthorTable.setAuthor_id(bookauthor.getAuthor_id());
			oldBookAuthorTable.setUpdated_on(new Date());

			return bookAuthorRepo.save(oldBookAuthorTable);
		} catch (Exception e) {
			String s = "record is not present to update with id of " + id;
			return (Object) s;
		}

	}
}
