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
public class Subject 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long subjectId;
	private String title;
	private String book;
	private String writer;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH}, 
				fetch = FetchType.LAZY)
	@JoinTable(name="participant_subject",
			   joinColumns = @JoinColumn(name="subject_id"),
			   inverseJoinColumns = @JoinColumn(name="participant_id"))
	private List<Participant> participants;
	
	@ManyToOne
	@JoinColumn(name="semester_id")
	private Semester semester;
	
	@ManyToOne
	@JoinColumn(name="stage_id")
	private Stage stage;
	
	
	
	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}

	public long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}

	public List<Participant> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Participant> participants) {
		this.participants = participants;
	}

	public void addParticipant(Participant participants)
	{
		this.participants.add(participants);
	}
	
	public String getBook() {
		return book;
	}
	public void setBook(String book) {
		this.book = book;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
