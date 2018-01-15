package API.entities;

import java.util.Calendar;

public class Publisher {
	private int id;
	private String title;
	private String city;
	private Calendar date; 
	private Author author;
	
	private static final Publisher oPublisher = new Publisher();
	
	private Publisher() {
		this.setId(0);
		this.setTitle("");
		this.setCity("");
		this.setDate(Calendar.getInstance());
		this.setAuthor(new Author());
	}
	
	public Publisher(int id, String title, String city) {
		this.setId(id);
		this.setTitle(title);
		this.setCity(city);
		this.setDate(Calendar.getInstance());
		this.setAuthor(new Author());
	}
	
	public static Publisher getPublisher() {
		return oPublisher;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
	
}
