package no.hvl.dat250.jpa.experiment2;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Bank {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	private String name;
	
	@OneToMany(
			fetch = FetchType.LAZY, 
			mappedBy = "bank", 
			orphanRemoval = true, 
			cascade = CascadeType.ALL)
	private List<CreditCard> creditCards;
	
	public Bank() {};

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<CreditCard> getCreditCards() {
		return creditCards;
	}

	public void setCreditCards(List<CreditCard> creditCards) {
		this.creditCards = creditCards;
	}

	@Override
	public String toString() {
		return "Bank [id=" + id + ", name=" + name + ", creditCards=" + creditCards + "]";
	}

}
