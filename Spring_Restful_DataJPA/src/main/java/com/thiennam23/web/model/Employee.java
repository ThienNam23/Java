package com.thiennam23.web.model;

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

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int eid, String ename, String deg, int salary) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.deg = deg;
		this.salary = salary;
	}

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

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", deg=" + deg + ", salary=" + salary + "]";
	}
	
}
