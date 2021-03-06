package no.hvl.dat250.jpa.assignmentA;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Poll {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String description;
	private String green;
	private String red;
	private Boolean isPublic;
	private Date startDate;
	private Date endDate;
	
	@ManyToOne
	@JoinTable(
			name = "poll_creator",
			joinColumns = @JoinColumn(name = "poll_fk"),
			inverseJoinColumns = @JoinColumn(name = "user_fk"))
	private User createdBy;
	
	@OneToMany(mappedBy = "poll", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<Vote> votes;
	
	public Poll() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGreen() {
		return green;
	}

	public void setGreen(String green) {
		this.green = green;
	}

	public String getRed() {
		return red;
	}

	public void setRed(String red) {
		this.red = red;
	}

	public Boolean getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(Boolean isPublic) {
		this.isPublic = isPublic;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public List<Vote> getVotes() {
		return votes;
	}

	public void setVotes(List<Vote> votes) {
		this.votes = votes;
	}

	@Override
	public String toString() {
		return "Poll [id=" + id + ", title=" + title + ", description=" + description + ", green=" + green + ", red="
				+ red + ", isPublic=" + isPublic + ", startDate=" + startDate + ", endDate=" + endDate + ", createdBy="
				+ createdBy + ", votes=" + votes + "]";
	}
}
