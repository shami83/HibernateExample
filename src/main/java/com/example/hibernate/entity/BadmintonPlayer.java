package com.example.hibernate.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "PLAYER", uniqueConstraints = {@UniqueConstraint(columnNames = "ID")})
public class BadmintonPlayer {
	
	@Id
	private long id;
	@Column(name = "PLAYER_NAME", unique = true, nullable = false, length = 100)
	private String name;
	
	@Column(name = "SPORTS_NAME", unique = false, nullable = false, length = 100)
	private String sports;// Not separate  Sports in a different table for sake of simplicity
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Country country;

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

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "BadmintonPlayer [id=" + id + ", name=" + name + ", sports=" + sports + ", country=" + country + "]";
	}
	

}
