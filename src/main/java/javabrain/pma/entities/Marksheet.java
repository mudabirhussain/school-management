package javabrain.pma.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Marksheet 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long marksheetId;
	private int obtainedMarks;
	private int totalMarks;
	
	@OneToOne
	@JoinColumn(name="stage_id")
	private Stage stage;
	
	@OneToOne
	@JoinColumn(name="participant_id")
	private Participant participant;
	
	@OneToMany
	@JoinColumn
	private List<SubjectMarks> subjectMarks;
	

	public long getMarksheetId() {
		return marksheetId;
	}

	public void setMarksheetId(long marksheetId) {
		this.marksheetId = marksheetId;
	}

	public int getObtainedMarks() {
		return obtainedMarks;
	}

	public void setObtainedMarks(int obtainedMarks) {
		this.obtainedMarks = obtainedMarks;
	}

	public int getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public Participant getParticipant() {
		return participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

	public List<SubjectMarks> getSubjectMarks() {
		return subjectMarks;
	}

	public void setSubjectMarks(List<SubjectMarks> subjectMarks) {
		this.subjectMarks = subjectMarks;
	}

	
	
	
}
