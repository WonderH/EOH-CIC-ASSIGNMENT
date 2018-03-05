package za.co.eoh.andile.cic.communication;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import za.co.eoh.andile.cic.customer.Customer;

@Entity
public class Communication {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private long id;
	private String type;
	private String subject;
	private String body;
	private String sourceSystem;
	private Date timeStamp;
	
	@ManyToOne
	private Customer customer;

	
	public Communication() {
		
	}
	
	public Communication(long id, String type, String subject, String body, String sourceSystem, Date timeStamp, long customerId) {
		super();
		this.id = id;
		this.type = type;
		this.subject = subject;
		this.body = body;
		this.sourceSystem = sourceSystem;
		this.timeStamp = timeStamp;
		this.customer = new Customer(customerId, "", "");
	}

	public long getId() {
		return id;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getSourceSystem() {
		return sourceSystem;
	}
	public void setSourceSystem(String sourceSystem) {
		this.sourceSystem = sourceSystem;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
