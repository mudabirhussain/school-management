package javabrain.pma.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Challan 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private long challanId;
	private int challanNumber;
	private String challanDate;
	private long amount;
	private String purpose;
	private String issueDate;
	
	@OneToOne
	@JoinColumn(name="participant_id")
	private Participant participant;

	public long getChallanId() {
		return challanId;
	}

	public void setChallanId(long challanId) {
		this.challanId = challanId;
	}

	public int getChallanNumber() {
		return challanNumber;
	}

	public void setChallanNumber(int challanNumber) {
		this.challanNumber = challanNumber;
	}

	public String getChallanDate() {
		return challanDate;
	}

	public void setChallanDate(String challanDate) {
		this.challanDate = challanDate;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public Participant getParticipant() {
		return participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

	@Override
	public String toString() {
		return "Challan [challanId=" + challanId + ", challanNumber=" + challanNumber + ", challanDate=" + challanDate
				+ ", amount=" + amount + ", purpose=" + purpose + ", issueDate=" + issueDate + "]";
	}

	
}
