package com.alianza.alianza_prueba.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="shared_key")
	private String shared_key; 
	
	@Column(name="bussines_id")
	private String bussines_id;
	
	@Column(name="email")
	private String email;
	
	@Column(name="phone")
	private long phone;
	
	@Column(name="date_added")
	private Date date_added;

	public Cliente() {
		
	}
	
	public Cliente(String shared_key, String bussines_id, String email, long phone, Date date_added) {
		super();
		this.shared_key = shared_key;
		this.bussines_id = bussines_id;
		this.email = email;
		this.phone = phone;
		this.date_added = date_added;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		id = id;
	}

	public String getShared_key() {
		return shared_key;
	}

	public void setShared_key(String shared_key) {
		this.shared_key = shared_key;
	}

	public String getBussines_id() {
		return bussines_id;
	}

	public void setBussines_id(String bussines_id) {
		this.bussines_id = bussines_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public Date getDate_added() {
		return date_added;
	}

	public void setDate_added(Date date_added) {
		this.date_added = date_added;
	}
	
		
}
