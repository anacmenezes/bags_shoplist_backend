package com.shoplist.bags.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Integer id;
	private String zCode;
	private String place;
	private String number;
	private String complement;
	private String district;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name="ADDRESS_USER", joinColumns = @JoinColumn(name="address_id"), 
	inverseJoinColumns = @JoinColumn(name="users_id"))
	private List<User> users = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name="country_id")
	private Country country;
	
	public Address() {
	}

	public Address(Integer id, String zCode, String place, String number, String complement, String district, Country country) {
		super();
		this.id = id;
		this.zCode = zCode;
		this.place = place;
		this.number = number;
		this.complement = complement;
		this.district = district;
		this.country = country;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getzCode() {
		return zCode;
	}

	public void setzCode(String zCode) {
		this.zCode = zCode;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(id, other.id);
	}
}
