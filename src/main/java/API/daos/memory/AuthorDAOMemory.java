package API.daos.memory;

import java.util.HashMap;

import API.daos.AuthorDAO;
import API.entities.Author;

public class AuthorDAOMemory extends GenericMemoryDao<Author, Integer> implements AuthorDAO {

	public AuthorDAOMemory() {
		this.setMap(new HashMap<Integer, Author>());
	}

	@Override
	protected Integer getId(Author entity) {
		return (int) entity.getId();
	}

	@Override
	protected void setId(Author entity, Integer id) {
		entity.setId(id);

	}

}
