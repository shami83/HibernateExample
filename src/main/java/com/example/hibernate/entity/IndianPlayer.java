package com.example.hibernate.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "INDIAN_PLAYER", uniqueConstraints = {@UniqueConstraint(columnNames = "ID")})
public class IndianPlayer {

	@Id
	private long id;
	@Column(name = "PLAYER_NAME", unique = true, nullable = false, length = 100)
	private String name;
	
	@Column(name = "SPORTS_NAME", unique = false, nullable = false, length = 100)
	private String sports;// Not separate  Sports in a different table for sake of simplicity
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="COUNTRY_ID",referencedColumnName="ID")
	private India india;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSports() {
		return sports;
	}

	public void setSports(String sports) {
		this.sports = sports;
	}

	public India getIndia() {
		return india;
	}

	public void setIndia(India india) {
		this.india = india;
	}

	@Override
	public String toString() {
		return "IndianPlayer [id=" + id + ", name=" + name + ", sports=" + sports + "]";
	}
	
	
	
}
