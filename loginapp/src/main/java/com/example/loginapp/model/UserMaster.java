package com.example.loginapp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.transaction.Transactional;


@Entity
public class UserMaster implements Serializable{
	
	@Id
	int phoneno;
	String role;

	boolean loggedinstatus;
	String username;
	String password;
	String email;
//	@OneToMany(mappedBy="user", cascade = CascadeType.ALL)
//	List<Timings> timings=new ArrayList<>();
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	//@JsonManagedReference
	List<Timings> timings = new ArrayList<>();

	
	public void setTimings(List<Timings> timings) {
		this.timings = timings;
	}
	@Transactional
	public List<Timings> getTimings() {
		return timings;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(int phoneno) {
		this.phoneno = phoneno;
	}
	public boolean isLoggedinstatus() {
		return loggedinstatus;
	}
	public void setLoggedinstatus(boolean loggedinstatus) {
		this.loggedinstatus = loggedinstatus;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "UserMaster [loggedinstatus=" + loggedinstatus + ", username=" + username + ", password=" + password
				+ ", email=" + email + ", phoneno=" + phoneno + ", timings=" + timings + "]";
	}
	
	

}
