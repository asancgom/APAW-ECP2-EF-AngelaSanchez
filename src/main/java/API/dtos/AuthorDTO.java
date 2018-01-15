package API.dtos;

import API.entities.Author;

public class AuthorDTO {

	private String name;
	private String language;
	 private long id;

	    public AuthorDTO() {
	    }

	    public AuthorDTO(Author author) {
	       id = author.getId();
	       name = author.getName();
	       language = author.getLanguage();
	    }

	    public long getId() {
	        return id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }
	    
	    public String getLanguage() {
	        return language;
	    }

	    public void setLanguage(String language) {
	        this.language = language;
	    }

	    @Override
	    public String toString() {
	        return "{\"id\":" + id + ",\"name\":\"" + name+  ",\"language\":\"" + language+ "\"}";
	    }
}
