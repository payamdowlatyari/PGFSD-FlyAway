package com.payamd.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Ticket")
public class Ticket implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ticket_id", unique = true, nullable = false)
	protected int id;
	
	@Column(name = "first_name", nullable = false)
	private String first_name;
	
	@Column(name = "last_name", nullable = false)
	private String last_name;
	
	@Column(name = "flight_id", unique = true)
	private int flight_id;

	@Column(name = "quantity", nullable = false)
	private int quantity;
	
	@Column(name = "price", nullable = false)
	private int price;
	
	@Column(name = "status", nullable = true)
	private String status;
	
	public Ticket(String first_name, String last_name, int flight_id, int quantity, int price) {
		
		this.first_name = first_name;
		this.last_name = last_name;
		this.flight_id = flight_id;
		this.quantity = quantity;
		this.price = price;
	}
	
	public Ticket(int id, String first_name, String last_name, int flight_id, int quantity, int price) {
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.flight_id = flight_id;
		this.quantity = quantity;
		this.price = price;
	}
	
	public Ticket(int id, String first_name, String last_name, int flight_id, int quantity, int price, String status) {
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.flight_id = flight_id;
		this.quantity = quantity;
		this.price = price;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int ticket_id) {
		this.id = ticket_id;
	}
	
	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	
	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
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
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

}

