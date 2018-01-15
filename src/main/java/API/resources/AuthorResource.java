package API.resources;

import java.util.Optional;

import API.controllers.AuthorController;
import API.dtos.AuthorDTO;
import API.resources.exceptions.AuthorFieldInvalidException;

public class AuthorResource {

	public static final String AUTHOR = "author";
	public static final String ID = "/{id}";

	public AuthorDTO readAuthor(int id) throws AuthorFieldInvalidException {
		Optional<AuthorDTO> optional = new AuthorController().readAuthor(id);
		return optional.orElseThrow(() -> new AuthorFieldInvalidException(Integer.toString(id)));
	}

	public void createAuthor(String name, String language) throws AuthorFieldInvalidException {
		this.validateFileds(name, language);
		new AuthorController().createAuthor(name, language);
	}

	public void validateFileds(String name, String language) throws AuthorFieldInvalidException {
		if (name == null || name.isEmpty()) {
			throw new AuthorFieldInvalidException("name");
		}
		if (language == null || language.isEmpty()) {
			throw new AuthorFieldInvalidException("language");
		}
	}

}
