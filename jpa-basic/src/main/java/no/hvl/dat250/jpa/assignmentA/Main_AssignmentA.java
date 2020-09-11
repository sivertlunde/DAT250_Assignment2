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
        
        //Create entities
        User user = new User();
        Poll poll = new Poll();
        Vote vote = new Vote();
        
        //set Vote
        vote.setPoll(poll);
        vote.setResult(0);
        vote.setVoter(user);
        
        //set Poll
        poll.setTitle("Test Poll");
        poll.setDescription("Does this poll work?");
        poll.setGreen("Yes");
        poll.setRed("No");
        poll.setIsPublic(true);
        poll.setCreatedBy(user);
        List<Vote> poll_votes = new ArrayList<>();
        poll_votes.add(vote);
        poll.setVotes(poll_votes);
        
        //set User
        user.setUsername("newUser");
        user.setPassword("password");
        user.setIsAdmin(false);
        List<Poll> polls = new ArrayList<>();
        polls.add(poll);
        user.setPolls(polls);
        List<Vote> user_votes = new ArrayList<>();
        user_votes.add(vote);
        user.setVotes(user_votes);
        
        em.persist(user);
        em.persist(poll);
        em.persist(vote);
        em.getTransaction().commit();

        em.close();
    }
}
