package no.hvl.dat250.jpa.assignmentA;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	private String username;

}
