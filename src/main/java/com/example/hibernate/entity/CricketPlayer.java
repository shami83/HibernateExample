package com.example.hibernate.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "PLAYER", uniqueConstraints = {@UniqueConstraint(columnNames = "ID")})
public class CricketPlayer {
	
	@Id
	private long id;
	@Column(name = "PLAYER_NAME", unique = true, nullable = false, length = 100)
	private String name;
	
	@Column(name = "SPORTS_NAME", unique = false, nullable = false, length = 100)
	private String sports;// Not separate  Sports in a different table for sake of simplicity
	
	@ManyToMany
	@JoinTable(name = "PLAYER_TEAM", joinColumns = {
			@JoinColumn(name = "PLAYER_ID", nullable = false, updatable = false) },
			inverseJoinColumns = { @JoinColumn(name = "TEAM_ID",
					nullable = false, updatable = false) })
	private Set<Team> teams = new HashSet<Team>();

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

	

	
	public void addTeam(Team team) {
		teams.add(team);
	}

	@Override
	public String toString() {
		return "CricketPlayer [id=" + id + ", name=" + name + ", sports=" + sports + ", team=" + teams + "]";
	}

	
	

}
