package API.controllers;

import API.daos.DaoFactory;
import API.entities.Publisher;

public class PublisherController {
	
	public void createPublisher(int id, String title, String city) {
		Publisher entity = new Publisher(id,title, city);
		DaoFactory.getFactory().getPublisherDao().create(entity);
	}
	
}
