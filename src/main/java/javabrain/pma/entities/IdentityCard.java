package javabrain.pma.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class IdentityCard 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long identityCardId;
	private String idCard;
	
	private String issueDate;
	private String ExpiryDate;

	@ManyToOne
	@JoinColumn(name="participant_id")
	private Participant participant;

	public long getIdentityCardId() {
		return identityCardId;
	}

	public void setIdentityCardId(long identityCardId) {
		this.identityCardId = identityCardId;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public String getExpiryDate() {
		return ExpiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		ExpiryDate = expiryDate;
	}

	public Participant getParticipant() {
		return participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

	@Override
	public String toString() {
		return "IdentityCard [identityCardId=" + identityCardId + ", idCard=" + idCard + ", issueDate=" + issueDate
				+ ", ExpiryDate=" + ExpiryDate + ", participant=" + participant + "]";
	}
	
	
}
