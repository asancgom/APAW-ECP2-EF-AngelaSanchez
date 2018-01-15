package API.controllers;

import java.util.List;
import java.util.Optional;

import API.daos.DaoFactory;
import API.dtos.AuthorDTO;
import API.entities.Author;
import API.entities.Publisher;

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
	public void DeleteAsociatedPublisher(int id) {
		List<Publisher> publisherList = DaoFactory.getFactory().getPublisherDao().findAll();
		for (Publisher publisher : publisherList) {
			Author author = publisher.getAuthor();
			if(author.getId() == id) {
				publisher.setAuthor(null);
				DaoFactory.getFactory().getPublisherDao().update(publisher);
			}
		}
		
	}
	public Optional<AuthorDTO> deleteAuthor(int id) {
		if (existAuthor(id)) {
			DeleteAsociatedPublisher(id);
			AuthorDTO result = new AuthorDTO(DaoFactory.getFactory().getAuthorDao().read(id));
			DaoFactory.getFactory().getAuthorDao().deleteById(id);
			return Optional.of(result);
		} else {
			return Optional.empty();
		}
	}
	
	
}



