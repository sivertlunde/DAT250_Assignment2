package no.hvl.dat250.jpa.experiment2;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Person {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "person_cards")
	private List<CreditCard> cards;
	
	@ManyToMany
	@JoinTable(
			name = "people_addresses", 
			joinColumns = @JoinColumn(name = "person_fk"),
			inverseJoinColumns = @JoinColumn(name = "address_fk"))
	private List<Address> addresses;

	public Person() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<CreditCard> getCards() {
		return cards;
	}

	public void setCards(List<CreditCard> cards) {
		this.cards = cards;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", cards=" + cards + ", addresses=" + addresses + "]";
	}

}
