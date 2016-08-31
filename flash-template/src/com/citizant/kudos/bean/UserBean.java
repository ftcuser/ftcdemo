package com.citizant.kudos.bean;

import java.io.Serializable;

public class UserBean implements Serializable {
	
	private static final long serialVersionUID = 6581560918017219305L;
	
	public static final String SUPER_USER = "super";
	public static final String ADMIN_USER = "admin";
	
	private String email;
	private String lastName;
	private String firstName;
	private String password;
	private String role;
	private boolean active = true;
	private boolean deleted = false;
	private boolean kudoReceived = false;
	
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public boolean isAdmin() {
		return role != null && role.equals(ADMIN_USER);
	}
	public boolean isSuperUser() {
		return role != null && role.equals(SUPER_USER);
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isKudoReceived() {
		return kudoReceived;
	}
	public void setKudoReceived(boolean kudoReceived) {
		this.kudoReceived = kudoReceived;
	}
}
