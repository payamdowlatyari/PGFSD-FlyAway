package com.project2.FlyAway;


import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "Customer")
public class Customer implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "customer_id", unique = true)
	private int id;
	
	@Column(name = "first_name", nullable = false)
	private String fName;
	
	@Column(name = "last_name", nullable = false)
	private String lName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

}

