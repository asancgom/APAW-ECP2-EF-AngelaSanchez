package API.controllers;

import java.util.Optional;

import API.daos.DaoFactory;
import API.dtos.AuthorDTO;
import API.entities.Author;

public class AuthorController {

	public Optional<AuthorDTO> readAuthor(int id) {
		if (existAuthor(id)) {
			return Optional.of(new AuthorDTO(DaoFactory.getFactory().getAuthorDao().read(id)));
		}
		return Optional.empty();
	}
	
	private boolean existAuthor(int id) {
		return DaoFactory.getFactory().getAuthorDao().read(id) != null;
	}
	
	public void createAuthor(String name, String language) {
		Author entity = new Author(name, language);
		DaoFactory.getFactory().getAuthorDao().create(entity);
	}
}


