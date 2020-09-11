package no.hvl.dat250.jpa.assignmentA;

import java.sql.PreparedStatement;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UserDAO implements Dao<User> {
	
	private static final String PERSISTENCE_UNIT_NAME = "dat250";
    private static EntityManagerFactory factory;
    
	
	public UserDAO() {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	}
	
	@Override
	public User getById(Long id) {
		EntityManager em = factory.createEntityManager();
		User user = new User();
		try {
	        user = em.find(User.class, id);	
		}finally {
			em.close();
		}
		if(user == null) {
			throw new EntityNotFoundException("Found no user with id " + id);
		}
        return user;
	}

	@Override
	public List<User> getAll() {
		EntityManager em = factory.createEntityManager();
		List<User> userlist;
		try {
			Query q = em.createQuery("SELECT * FROM Usertable");
			userlist = q.getResultList();	
		}finally {
			em.close();
		}
		if(userlist ==null) {
			throw new EntityNotFoundException("No Users exsist in the database");
		}
		return userlist;
	}
	
	public User findUserByUsername(String s) {
        EntityManager em = factory.createEntityManager();
        User user = new User();
        try {
            Query q = em.createQuery("select u from Usertable u where u.username="+s);
            user = (User) q.getSingleResult();
        }finally {
            em.close();
        }
        if(user == null) {
            throw new EntityNotFoundException("No User with that username");
        }
        return user;
    }

	@Override
	public void save(User u) {
		EntityManager em = factory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(u);
			em.getTransaction().commit();	
		}finally {
			em.close();		
		}	
	}

	@Override
	public void update(User u) {
		EntityManager em = factory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(u);
			em.getTransaction().commit();
		}
		finally {
			em.close();
		}
	}

	@Override
	public void delete(User u) {
		EntityManager em = factory.createEntityManager();
		try {
			User toRemove = em.find(User.class, u.getId());
			em.getTransaction().begin();
			em.remove(toRemove);
			em.getTransaction().commit();
		}
		finally {
			em.close();
		}
	}

}
