package API.dtos;

import API.entities.Publisher;

public class PublisherDTO {
	 private String title;
	 private String city;
	 private int id;

	    public PublisherDTO() {
	    }

	    public PublisherDTO(Publisher publisher) {
	       id = publisher.getId();
	       title = publisher.getTitle();
	       city = publisher.getCity();
	    }

	    public int getId() {
	        return id;
	    }

	    public String getTitle() {
	        return title;
	    }

	    public void setTitle(String title) {
	        this.title = title;
	    }
	    
	    public String getCity() {
	        return city;
	    }

	    public void setCity(String city) {
	        this.city = city;
	    }

	    @Override
	    public String toString() {
	        return "{\"id\":" + id + ",\"title\":\"" + title+  ",\"city\":\"" + city+ "\"}";
	    }
}
