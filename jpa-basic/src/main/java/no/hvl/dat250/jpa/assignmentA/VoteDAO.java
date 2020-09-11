package no.hvl.dat250.jpa.assignmentA;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class VoteDAO implements Dao<Vote> {
	
	private static final String PERSISTENCE_UNIT_NAME = "dat250";
    private static EntityManagerFactory factory;
    
    public VoteDAO() {
    	factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }
   
	@Override
	public Vote getById(Long id) {
		EntityManager em = factory.createEntityManager();
		Vote vote = null;
		try {
			vote = em.find(Vote.class, id);
		} finally {
			em.close();
		}
		if (vote == null) {
			throw new EntityNotFoundException("Can't find vote with id " + id);
		}
		return vote;
	}

	@Override
	public List<Vote> getAll() {
		EntityManager em = factory.createEntityManager();
		List<Vote> allVotes;
		try {
			Query q = em.createQuery("select v from Vote v");
			allVotes = q.getResultList();
		} finally {
			em.close();
		}
		return allVotes;
	}

	@Override
	public void save(Vote v) {
		EntityManager em = factory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(v);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}

	@Override
	public void update(Vote v) {
		EntityManager em = factory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(v);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}

	@Override
	public void delete(Vote v) {
		EntityManager em = factory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(v);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}
}
