package com.verinite.bookstore.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.verinite.bookstore.entity.Author;
import com.verinite.bookstore.repository.AuthorRepository;
import com.verinite.bookstore.service.AuthorService;

@Service

public class AuthorImp implements AuthorService {
	@Autowired
	private AuthorRepository authorRepo;

	@Autowired
	AuthorService authorService;

	@Override
	// TO-Add-Author-Into-Repository
	public Author saveAuthor(Author author) {
//		author.setCreated_on(new Date());
//		author.setUpdated_on(new Date());
		author.setIs_deleted(false);
		return authorRepo.save(author);
	}

	@Override
	// To-Get-All-The-Authors-Present-In-Repo
	public List<Author> allAuthors() {
		return authorRepo.all();
	}

	@Override
	// To-Get-The-Author-By-Id
	public Object getById(int author_id) {

		try {
			authorRepo.findById(author_id).get();
			return authorRepo.getById(author_id);
		} catch (Exception e) {
			return "Id not Found";
		}

	}

	@Override
	// To-Delete-Author-By-Id
	public String deleteAuthorById(int author_id) {
		try {
			Author authorEntity = authorRepo.findById(author_id).get();
			if (authorEntity.isIs_deleted() == false) {
				authorEntity.setIs_deleted(true);
				authorEntity.setCreated_on(new Date());
				authorRepo.save(authorEntity);

				return "Author record Successfully deleted";
			} else {
				return "Given authorId is already deleted";
			}
		} catch (Exception e) {
			return "Id not Found";
		}

	}

	@Override
	// To-Update-Author-FirstNmae-And-LastName
	public Object updateAuthor(int author_id, Author author) {

		try {
			Author authorEntity = (Author) authorRepo.findById(author_id).get();
			boolean b = authorEntity.isIs_deleted();
			if (b == false) {
				authorEntity.setUpdated_on(new Date());
				authorEntity.setFirst_name(author.getFirst_name());
				authorEntity.setLast_name(author.getLast_name());

				final Author up = authorRepo.save(authorEntity);
				return ResponseEntity.ok(up);
			} else {
				String s = "The given authorId already deleted,So we cant update-it";
				return s;
			}

		} catch (Exception e) {
			return "Id not Found";
		}

	}

}
