package API.resources;

import API.resources.exceptions.PublisherFieldInvalidException;

import java.util.Optional;

import API.controllers.PublisherController;
import API.dtos.PublisherDTO; 

public class PublisherResource {
	
	public static final String PUBLISHER = "publisher";
	public static final String ID = "/{id}";
	
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
    
}
