package no.hvl.dat250.jpa.assignmentA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class PollDAO implements Dao<Poll> {
	
	private static final String PERSISTENCE_UNIT_NAME = "dat250";
    private static EntityManagerFactory factory;
    
    public PollDAO() {
    	factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    @Override
	public Poll getById(Long id) {
		EntityManager em = factory.createEntityManager();
		Poll poll = null;
		try {
			poll = em.find(Poll.class, id);
		} finally {
			em.close();
		}
		if (poll == null) {
			throw new EntityNotFoundException("Can't find poll with id " + id);
		}
		return poll;
	}

	@Override
	public List<Poll> getAll() {
		EntityManager em = factory.createEntityManager();
		List<Poll> allPolls;
		try {
			Query q = em.createQuery("select p from Poll p");
			allPolls = q.getResultList();
		} finally {
			em.close();
		}
		return allPolls;
	}

	@Override
	public void save(Poll p) {
		EntityManager em = factory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(p);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}

	@Override
	public void update(Poll p) {
		EntityManager em = factory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(p);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}

	@Override
	public void delete(Poll p) {
		EntityManager em = factory.createEntityManager();
		try {
			Poll toRemove = em.find(Poll.class, p.getId());
			em.getTransaction().begin();
			em.remove(toRemove);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}
}
