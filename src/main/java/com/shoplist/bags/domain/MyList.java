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
public class MyList implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Integer id;
	private Integer name;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name="MYLIST_PRODUCT", joinColumns = @JoinColumn(name="myList_id"), 
	inverseJoinColumns = @JoinColumn(name="product_id"))
	private List<Product> product = new ArrayList<>();
	
	@JsonIgnore
	@ManyToMany(mappedBy="myList")
	private List<MyShopList> shopList = new ArrayList<>();
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="users_id")
	private Users users;
	
	public MyList() {
	}

	public MyList(Integer id, Integer name, Users users) {
		super();
		this.id = id;
		this.name = name;
		this.users = users;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getName() {
		return name;
	}

	public void setName(Integer name) {
		this.name = name;
	}
	
	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}
	
	public List<MyShopList> getShopList() {
		return shopList;
	}

	public void setShopList(List<MyShopList> shopList) {
		this.shopList = shopList;
	}
	
	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
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
		MyList other = (MyList) obj;
		return Objects.equals(id, other.id);
	}
}