package com.example.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "TEAM", uniqueConstraints = {@UniqueConstraint(columnNames = "ID")})
public class Team {
	
	@Id
	private Long id;
	
	@Column(name = "TEAM_NAME", unique = true, nullable = false, length = 100)
	private String name;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name +"]";
	}
	
	

}
