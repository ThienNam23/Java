package com.thiennam23.RESTdemo;

import java.util.ArrayList;
import java.util.List;

public class AlienRepository {
	
	private List<Alien> aliens;
	
	public AlienRepository() {
		aliens = new ArrayList<>();
		Alien a1 = new Alien("Thien Nam", 60);
		Alien a2 = new Alien("BloodEye", 99);
		Alien a3 = new Alien("No name", 0);
		
		aliens.add(a1);
		aliens.add(a2);
		aliens.add(a3);
	}
	
	public List<Alien> getAliens() {
		return aliens;
	}
	
	public Alien getAlien(int points) {
		for (Alien a : aliens) {
			if (a.getPoints() == points) {
				System.out.println(a);
				return a;
			}
		}
		return new Alien();
	}

	public void create(Alien a1) {
		// TODO Auto-generated method stub
		aliens.add(a1);
	}
}
