package javabrain.pma.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class SubjectMarks 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long subjectMarksId;
	private int marks;
	
	@OneToOne
	@JoinColumn(name="subject_id")
	private Subject subject;
	
	@ManyToOne
	@JoinColumn(name="participant_id")
	private Participant participant;

	@ManyToOne
	@JoinColumn(name="semester_id")
	private Semester semester;
	
	@ManyToOne
	@JoinColumn(name="session_id")
	private Session session;
	
	
	public long getSubjectMarksId() {
		return subjectMarksId;
	}

	public void setSubjectMarksId(long subjectMarksId) {
		this.subjectMarksId = subjectMarksId;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public Participant getParticipant() {
		return participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}
	
	
	
}
