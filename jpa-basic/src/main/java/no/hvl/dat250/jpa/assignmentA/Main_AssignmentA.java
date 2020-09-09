package no.hvl.dat250.jpa.assignmentA;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main_AssignmentA {
    private static final String PERSISTENCE_UNIT_NAME = "dat250";
    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        
//        //Create entities
//        User user = new User();
//        user.setUsername("newUser");
//        user.setPassword("password");
//        user.setIsAdmin(false);
//        user.setPolls(null);
//        user.setVotes(null);
//        
//        em.persist(user);
//        em.getTransaction().commit();

        em.close();
    }
}
