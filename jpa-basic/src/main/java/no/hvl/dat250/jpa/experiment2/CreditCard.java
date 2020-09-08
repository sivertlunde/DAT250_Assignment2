package no.hvl.dat250.jpa.experiment2;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class CreditCard {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	private Integer number;
	private Integer limit;
	private Integer balance;
	
	@OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
	@JoinColumn(name = "pincode_fk")
	private Pincode pincode;
	
	@ManyToOne
	@JoinColumn(name = "bank_fk")
	private Bank bank;

	public CreditCard() {}
	
	@Override
	public String toString() {
		return "CreditCard [id=" + id + ", number=" + number + ", limit=" + limit + ", balance=" + balance
				+ ", pincode=" + pincode + ", bank=" + bank + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public Pincode getPincode() {
		return pincode;
	}

	public void setPincode(Pincode pincode) {
		this.pincode = pincode;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}
}
