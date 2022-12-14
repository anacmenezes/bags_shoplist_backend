package com.shoplist.bags.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Historic implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Integer id;
	private String item;
	private Date date;
	private String supermarket;
	private String amount;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="shopList_id")
	@MapsId
	private MyShopList shopList;
	
	public Historic() {
	}

	public Historic(Integer id, String item, Date date, String supermarket, String amount, MyShopList shopList) {
		super();
		this.id = id;
		this.item = item;
		this.date = date;
		this.supermarket = supermarket;
		this.amount = amount;
		this.shopList = shopList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getSupermarket() {
		return supermarket;
	}

	public void setSupermarket(String supermarket) {
		this.supermarket = supermarket;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	public MyShopList getShopList() {
		return shopList;
	}

	public void setShopList(MyShopList shopList) {
		this.shopList = shopList;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Historic other = (Historic) obj;
		return Objects.equals(id, other.id);
	}
}