package API.entities;

public class Author {
	private long id;
	private String name;
	private String language;

	public Author() {
		this.setId(0);
		this.setName("");
		this.setLanguage("");
	}
	
	public Author(long id, String name, String language) {
		this.setId(id);
		this.setName(name);
		this.setLanguage(language);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
}
