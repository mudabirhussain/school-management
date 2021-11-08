package javabrain.pma.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
@Entity
public class Participant 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long participantId;
	private String name;
	private String lastName;
	private String contact;
	private String username;
	private String password;
	
	@ManyToMany(cascade= {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH},
				fetch = FetchType.LAZY)
	@JoinTable(name="participant_subject",
	   joinColumns = @JoinColumn(name="participant_id"),
	   inverseJoinColumns = @JoinColumn(name="subject_id"))
	private List<Subject> subjects;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
			   fetch = FetchType.EAGER)
	@JoinColumn(name="role_id")
	private Role role;

	public long getParticipantId() {
		return participantId;
	}



	public void setParticipantId(long participantId) {
		this.participantId = participantId;
	}



	public void addSubject(Subject subjects)
	{
		this.subjects.add(subjects);
	}
	
	
	
	public List<Subject> getSubjects() {
		return subjects;
	}


	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}


	public Participant() {
		
	}

	
	//for user name and password verification
	public Participant(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}




	
	
	
}
