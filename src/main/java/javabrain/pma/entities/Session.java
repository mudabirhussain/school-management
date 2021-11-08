package javabrain.pma.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Session 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long sessionId;
	private String sessionYear;

	@OneToOne
	@JoinColumn(name="stage_id")
	private Stage stage;
	
	
	public Stage getStage() {
		return stage;
	}


	public void setStage(Stage stage) {
		this.stage = stage;
	}


	public long getSessionId() {
		return sessionId;
	}


	public void setSessionId(long sessionId) {
		this.sessionId = sessionId;
	}


	public String getSessionYear() {
		return sessionYear;
	}


	public void setSessionYear(String sessionYear) {
		this.sessionYear = sessionYear;
	}

	@Override
	public String toString() {
		return "Session [sessionId=" + sessionId + ", sessionYear=" + sessionYear + "]";
	}
	
	
	
}
