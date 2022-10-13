package com.shoplist.bags.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class MyShopList implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Integer id;
	private String name;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name="MYSHOPLIST_MYLIST", joinColumns = @JoinColumn(name="shopList_id"), 
	inverseJoinColumns = @JoinColumn(name="myList_id"))
	private List<MyList> myList = new ArrayList<>();
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="shopList")
	private Historic historic;
	
	public MyShopList() {
	}

	public MyShopList(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	public List<MyList> getMyList() {
		return myList;
	}

	public void setMyList(List<MyList> myList) {
		this.myList = myList;
	}
	
	public Historic getHistoric() {
		return historic;
	}

	public void setHistoric(Historic historic) {
		this.historic = historic;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyShopList other = (MyShopList) obj;
		return Objects.equals(id, other.id);
	}
}