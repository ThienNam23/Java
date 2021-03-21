package com.thiennam23.JPA_Hibernate.model;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

// @Entity(name = "entity_name"): chi ro ten entity, mac dinh la ten Model
// @Table(name = "table_name): chi ro ten bang, mawc dinh la ten Model
/**
 * @author thiennam23
 *         https://stackoverflow.com/questions/18732646/name-attribute-in-entity-and-table
 *         Difference between @Entity(name) and @Table(name)
 */
@Entity
@Table(name = "employee")
public class Employee {

	@Id
	private int eid;
	private String ename;

	// @Transient : chi dinh khong tao (no store) cot nay tren db
	private String deg;

	// @Column(name = "column_name"): chi dinh ten cot
	private int salary;
	private Address address;
	
	@OneToOne
	private Laptop laptop;
	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getDeg() {
		return deg;
	}

	public void setDeg(String deg) {
		this.deg = deg;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Laptop getLaptop() {
		return laptop;
	}

	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", deg=" + deg + ", salary=" + salary + ", address="
				+ address + ", laptop=" + laptop + "]";
	}

	


}
