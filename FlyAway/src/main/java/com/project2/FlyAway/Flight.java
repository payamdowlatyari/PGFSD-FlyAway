package com.project2.FlyAway;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "Flight")
public class Flight implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "flight_id", unique = true)
	private int id;
	
	@Id
	@Column(name = "dep_airport", nullable = false)
	private String dep_airport;
	
	@Id
	@Column(name = "arr_airport", nullable = false)
	private String arr_airport;
	
	@Id
	@Column(name = "dep_time", nullable = false)
	private Date dep_time;
	
	@Id
	@Column(name = "arr_time", nullable = false)
	private Date arr_time;
	
	@Id
	@Column(name = "available_seats", nullable = false)
	private int available_seats;
	
	@Id
	@Column(name = "price", nullable = false)
	private int price;

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

	public Date getDep_time() {
		return dep_time;
	}

	public void setDep_time(Date dep_time) {
		this.dep_time = dep_time;
	}

	public Date getArr_time() {
		return arr_time;
	}

	public void setArr_time(Date arr_time) {
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
