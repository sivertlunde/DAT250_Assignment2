package no.hvl.dat250.jpa.assignmentA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class VoteDAO implements Dao<Vote> {
	
	private static final String PERSISTENCE_UNIT_NAME = "dat250";
    private static EntityManagerFactory factory;
    
    public VoteDAO() {
    	factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }
   
	@Override
	public Vote getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vote> getAll() {
		EntityManager em = factory.createEntityManager();
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Vote t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Vote t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vote delete(Vote t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
