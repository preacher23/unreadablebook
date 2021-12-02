package com.verinite.bookstore.service;

import java.util.List;

import com.verinite.bookstore.entity.Author;

public interface AuthorService {
	public Author saveAuthor(Author author);

	public List<Author> allAuthors();

	public Object getById(int author_id);

	public String deleteAuthorById(int author_id);

	public Object updateAuthor(int author_id, Author author);

}
