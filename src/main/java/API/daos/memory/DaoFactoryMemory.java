package API.daos.memory;

import API.daos.DaoFactory;
import API.daos.AuthorDAO;
import API.daos.PublisherDAO;

public class DaoFactoryMemory extends DaoFactory {
    
    private PublisherDAO publisherDao;
    private AuthorDAO authorDao;


    @Override
    public PublisherDAO getPublisherDao() {
        if (publisherDao == null) {
        		publisherDao = new PublisherDAOMemory();
        }
        return publisherDao;
    }

    @Override
    public AuthorDAO getAuthorDao() {
        if (authorDao == null) {
        		authorDao = new AuthorDAOMemory();
        }
        return authorDao;
    }
}
