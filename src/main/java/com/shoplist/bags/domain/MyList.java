package com.shoplist.bags.domain;

import java.io.Serializable;
import java.util.Objects;

public class MyList implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer name;
	
	public MyList() {
	}

	public MyList(Integer id, Integer name) {
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

	public Integer getName() {
		return name;
	}

	public void setName(Integer name) {
		this.name = name;
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
