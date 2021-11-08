package javabrain.pma.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Semester 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long semesterId;
	private String semester;
	private String semesterDate;
	
	@ManyToOne
	@JoinColumn(name="session_id")
	private Session session;

	public long getSemesterId() {
		return semesterId;
	}

	public void setSemesterId(long semesterId) {
		this.semesterId = semesterId;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getSemesterDate() {
		return semesterDate;
	}

	public void setSemesterDate(String semesterDate) {
		this.semesterDate = semesterDate;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}
	
	
}
