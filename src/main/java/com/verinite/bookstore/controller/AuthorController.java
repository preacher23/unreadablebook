package com.verinite.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verinite.bookstore.entity.Author;
import com.verinite.bookstore.service.AuthorService;

@RestController
@RequestMapping("/author")
public class AuthorController {
	@Autowired
	private AuthorService authorService;

	// Post-Mapping-To-Insert-Author
	@PostMapping("/saveAuthors")
	public Author saveAuthor(@RequestBody Author author) {
		System.out.println(author);
		return authorService.saveAuthor(author);
	}

	// Get-Mapping-To-Get-All-The-Authors
	@GetMapping("/authorList")
	public List<Author> allAuthors() {
		return authorService.allAuthors();
	}

	// Get-Mapping-To-Get-The-Author-By-Id
	@GetMapping("/getAuthor/{author_id}")
	public Object getById(@PathVariable int author_id) {
		return authorService.getById(author_id);
	}

	// Delete-Mapping-To-Delete-The-Author-By-Id
	@DeleteMapping("/deleteAuthor/{author_id}")
	public String deleteAuthorById(@PathVariable int author_id) {
		return authorService.deleteAuthorById(author_id);

	}

	// Put-Mapping-To-Update-the-Author-FirstName-And-LastName
	@PutMapping("/updateAuthor/{author_id}")
	public Object updateAuthor(@PathVariable int author_id, @RequestBody Author author) {
		return authorService.updateAuthor(author_id, author);

	}

}