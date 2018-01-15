package API.daos.memory;

import java.util.HashMap;

import API.daos.PublisherDAO;
import API.daos.memory.GenericMemoryDao;
import API.entities.Publisher;

public class PublisherDAOMemory extends GenericMemoryDao<Publisher, Integer> implements PublisherDAO {

	public PublisherDAOMemory() {
		this.setMap(new HashMap<Integer, Publisher>());
	}

	@Override
	protected Integer getId(Publisher entity) {
		return entity.getId();
	}

	@Override
	protected void setId(Publisher entity, Integer id) {
		entity.setId(id);

	}
}