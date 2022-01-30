package com.payamd.entities;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Flight")
public class Flight implements Serializable{
	

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "flight_id", unique = true)
	protected int id;
	
	@Column(name = "dep_airport", nullable = false)
	private String dep_airport;
	
	@Column(name = "arr_airport", nullable = false)
	private String arr_airport;
	
	@Column(name = "dep_time", nullable = false)
	private String dep_time;
	
	@Column(name = "arr_time", nullable = false)
	private String arr_time;
	
	@Column(name = "available_seats", nullable = false)
	private int available_seats;

	@Column(name = "price", nullable = false)
	private int price;
	
	public Flight() {
		
	}
	
	public Flight(String dep_airport, String arr_airport, String dep_time, String arr_time, int available_seats, int price) {
		this.dep_airport = dep_airport;
		this.arr_airport = arr_airport;
		this.dep_time = dep_time;
		this.arr_time = arr_time;
		this.available_seats = available_seats;
		this.price = price;
		
	}
	
	public Flight(int id, String dep_airport, String arr_airport, String dep_time, String arr_time, int available_seats, int price) {
		this.id = id;
		this.dep_airport = dep_airport;
		this.arr_airport = arr_airport;
		this.dep_time = dep_time;
		this.arr_time = arr_time;
		this.available_seats = available_seats;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDep_airport() {
		return dep_airport;
	}

	public void setDep_airport(String dep_airport) {
		this.dep_airport = dep_airport;
	}

	public String getArr_airport() {
		return arr_airport;
	}

	public void setArr_airport(String arr_airport) {
		this.arr_airport = arr_airport;
	}

	public String getDep_time() {
		return dep_time;
	}

	public void setDep_time(String dep_time) {
		this.dep_time = dep_time;
	}

	public String getArr_time() {
		return arr_time;
	}

	public void setArr_time(String arr_time) {
		this.arr_time = arr_time;
	}

	public int getAvailable_seats() {
		return available_seats;
	}

	public void setAvailable_seats(int available_seats) {
		this.available_seats = available_seats;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
