package API.controllers;

import java.util.Optional;

import API.daos.DaoFactory;
import API.dtos.PublisherDTO;
import API.entities.Author;
import API.entities.Publisher;

public class PublisherController {
	
	public void createPublisher(int id, String title, String city) {
		Publisher entity = new Publisher(id,title, city);
		DaoFactory.getFactory().getPublisherDao().create(entity);
	}
	
	public Optional<PublisherDTO> readPublisher(int id) {
		if (existPublisher(id)) {
			return Optional.of(new PublisherDTO(DaoFactory.getFactory().getPublisherDao().read(id)));
		}
		return Optional.empty();
	}
	
	private boolean existPublisher(int id) {
		return DaoFactory.getFactory().getPublisherDao().read(id) != null;
	}
	
	public Optional<PublisherDTO> readCityPublisher(int id) {
		if (existPublisher(id)) {
			return Optional.of(new PublisherDTO(DaoFactory.getFactory().getPublisherDao().read(id)));
		}
		return Optional.empty();
	}
	
	public PublisherDTO deletePublisher(int id) {
		if (existPublisher(id)) {
			PublisherDTO result = new PublisherDTO(DaoFactory.getFactory().getPublisherDao().read(id));
			DaoFactory.getFactory().getPublisherDao().deleteById(id);
			return result;
		} else {
			return new PublisherDTO();
		}

	}
	
	public int asociateAuthor(int idPublisher, int idAuthor) {
		Author author = DaoFactory.getFactory().getAuthorDao().read(idAuthor);
		if (author != null) {
			Publisher publisher = DaoFactory.getFactory().getPublisherDao().read(idPublisher);
			if(publisher != null) {
				publisher.setAuthor(author);
				DaoFactory.getFactory().getPublisherDao().update(publisher);
				return 3;
			}else {
				return 2;
			}
		} else {
			return 1;
		}
	}
}
