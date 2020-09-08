package no.hvl.dat250.jpa.basicexample;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import no.hvl.dat250.jpa.experiment2.Address;
import no.hvl.dat250.jpa.experiment2.Bank;
import no.hvl.dat250.jpa.experiment2.CreditCard;
import no.hvl.dat250.jpa.experiment2.Person;
import no.hvl.dat250.jpa.experiment2.Pincode;

public class Main {
    private static final String PERSISTENCE_UNIT_NAME = "todos";
    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        
//        // read the existing entries and write to console
//        Query q = em.createQuery("select t from Todo t");
//        List<Todo> todoList = q.getResultList();
//        for (Todo todo : todoList) {
//            System.out.println(todo); 
//        }
//        System.out.println("Size: " + todoList.size());
//
//        // create new todo
        
        
        em.getTransaction().begin();
//        Todo todo = new Todo();
//        todo.setSummary("This is a test");
//        todo.setDescription("This is a test");
        
        //Create entities
        Person person = new Person();
        Address address = new Address();
        Pincode pincode = new Pincode();
        CreditCard creditCard = new CreditCard();
        Bank bank = new Bank();
        
        //Set pincode
        pincode.setPincode("1234");
        pincode.setCount(3);
        
        //set creditcard
        creditCard.setNumber(123456789);
        creditCard.setBalance(1000);
        creditCard.setLimit(500);
        creditCard.setPincode(pincode);
        
        //set bank
        bank.setName("The Bank");
        List<CreditCard> bankCards = new ArrayList<>();
        bankCards.add(creditCard);
        bank.setCreditCards(bankCards);
        
        //set address
        address.setStreet("5th Avenue");
        address.setNumber(105);
        List<Person> people = new ArrayList<>();
        people.add(person);
        address.setPeople(people);
        
        //set person
        person.setName("Donald");
        List<CreditCard> personCards = new ArrayList<>();
        personCards.add(creditCard);
        List<Address> addresses = new ArrayList<>();
        addresses.add(address);
        person.setAddresses(addresses);
        
//        em.persist(todo);
        em.persist(person);
        em.persist(address);
        em.persist(bank);
        em.getTransaction().commit();

        em.close();
    }
}
