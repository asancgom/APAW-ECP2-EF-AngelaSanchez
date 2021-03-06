package API.resources;

import API.resources.exceptions.AuthorIdNotFoundException;
import API.resources.exceptions.PublisherFieldInvalidException;
import API.resources.exceptions.PublisherIdNotFoundException;

import java.util.Optional;

import API.controllers.PublisherController;
import API.dtos.PublisherDTO; 

public class PublisherResource {
	
	public static final String PUBLISHER = "publisher";
	public static final String ID = "/{id}";
	public static final String ID_CITY = "/{id}/city";
	
    public void createPublisher(int id, String title, String city) throws PublisherFieldInvalidException {
		this.validateFileds(id, title,city);
		new PublisherController().createPublisher(id, title, city);
	}

	public void validateFileds(int id, String title, String city) throws PublisherFieldInvalidException {
		if (title == null || title.isEmpty()) {
			throw new PublisherFieldInvalidException("title");
		}
		if (city == null || city.isEmpty()) {
			throw new PublisherFieldInvalidException("city");
		}
		if (id == 0) {
			throw new PublisherFieldInvalidException("id");
		}
	}
	
	public PublisherDTO readPublisher(int id) throws PublisherFieldInvalidException {
    	Optional<PublisherDTO> optional =  new PublisherController().readPublisher(id);
    	return optional.orElseThrow(()->new PublisherFieldInvalidException(Integer.toString(id)));
    }
	
	public PublisherDTO readCityPublisher(int id) throws PublisherFieldInvalidException {
    	Optional<PublisherDTO> optional =  new PublisherController().readCityPublisher(id);
    	return optional.orElseThrow(()->new PublisherFieldInvalidException(Integer.toString(id)));
    }
	
	
	public PublisherDTO deletePublisher(int id) {
		return new PublisherController().deletePublisher(id);
	}
    
	public void asociateAuthor(int idPublisher, int idAuthor) throws PublisherIdNotFoundException , AuthorIdNotFoundException{
		if (new PublisherController().asociateAuthor(idPublisher, idAuthor)== 1) {
			throw new AuthorIdNotFoundException(Integer.toString(idAuthor));
		}else if(new PublisherController().asociateAuthor(idPublisher, idAuthor)== 2) {
			throw new PublisherIdNotFoundException(Integer.toString(idPublisher));
		}
	}
}
