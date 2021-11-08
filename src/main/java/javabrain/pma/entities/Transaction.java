package javabrain.pma.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Transaction 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long transactionId;
	private String date;
	private int amount;
	private int remaining;
	
	@OneToOne
	@JoinColumn(name="challan_id")
	private Challan challan;
	
	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getRemaining() {
		return remaining;
	}

	public void setRemaining(int remaining) {
		this.remaining = remaining;
	}

	public Challan getChallan() {
		return challan;
	}

	public void setChallan(Challan challan) {
		this.challan = challan;
	}

	
	
	
}
