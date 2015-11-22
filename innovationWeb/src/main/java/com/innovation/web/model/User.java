package com.innovation.web.model;

import java.io.Serializable;
import java.util.Comparator;

import javax.persistence.*;

/**
 * The persistent class for the User database table.
 * 
 */
@Entity
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String company;

	private String iban;

	private String name;

	private String phone;

	public User() {
	}

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getIban() {
		return this.iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	static final Comparator<User> SENIORITY_ORDER = new Comparator<User>() {
		public int compare(User e1, User e2) {
			return e2.getId().compareTo(e1.getId());
		}
	};

}