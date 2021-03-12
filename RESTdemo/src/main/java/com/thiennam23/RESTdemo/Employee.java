package com.thiennam23.RESTdemo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee {
	private int eid;
	private String ename;
	private String deg;
	private int salary;
	public Employee() {
		super();
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
