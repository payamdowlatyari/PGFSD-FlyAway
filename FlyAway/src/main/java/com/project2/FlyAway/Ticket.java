package com.project2.FlyAway;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Ticket")
public class Ticket implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "customer_id", unique = true)
	private int customer_id;
	
	@Id
	@Column(name = "flight_id", unique = true)
	private int flight_id;
	
	@Id
	@Column(name = "quantity", nullable = false)
	private int quantity;

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public int getFlight_id() {
		return flight_id;
	}

	public void setFlight_id(int flight_id) {
		this.flight_id = flight_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

}
