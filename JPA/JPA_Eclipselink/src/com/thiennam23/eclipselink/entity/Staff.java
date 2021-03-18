package com.thiennam23.eclipselink.entity;


import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table
/**
 * @author thiennam23 
 * Option 1: 
 * @Inheritance( strategy = InheritanceType.SINGLE_TABLE ) 
 * @DiscriminatorColumn( name = "type" )
 * 
 * Option 2:
 * @Inheritance( strategy = InheritanceType.TABLE_PER_CLASS )
 */

@Inheritance(strategy = InheritanceType.JOINED)

public class Staff {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int sid;
	private String sname;

	public Staff(int sid, String sname) {
		super();
		this.sid = sid;
		this.sname = sname;
	}

	public Staff() {
		super();
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}
}