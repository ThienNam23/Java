package com.thiennam23.JPA_Hibernate.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Company {
	@Id
	private int cid;
	private String cname;
	
	@OneToMany(mappedBy = "company", fetch = FetchType.EAGER)
	private List<Product> products;
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	@Override
	public String toString() {
		return "Company [cid=" + cid + ", cname=" + cname + ", Products=" + products + "]";
	}
	
	
}
