package com.thiennam23.RESTdemo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement // co the khong co (name = "Alien"). Cai nay chi de chi dinh ten hien thi
public class Alien {
	private String name;
	private int points;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	// Neu muon co constructor nay thi bat buoc phai co constructor ben duoi
	public Alien(String name, int points) {
		super();
		this.name = name;
		this.points = points;
	}
	public Alien() {
		super();
	}
	@Override
	public String toString() {
		return "Alien [name=" + name + ", points=" + points + "]";
	}
	
}
