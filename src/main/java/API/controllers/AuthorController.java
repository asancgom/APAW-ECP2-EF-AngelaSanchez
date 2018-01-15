package API.controllers;

import java.util.Optional;

import API.daos.DaoFactory;
import API.dtos.AuthorDTO;

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
}


