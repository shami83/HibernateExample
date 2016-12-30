package com.example.hibernate.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "COUNTRY", uniqueConstraints = {@UniqueConstraint(columnNames = "ID")})
public class Country {
	
	@Id
	private Long id;
	
	@Column(name = "COUNTRY_NAME", unique = true, nullable = false, length = 100)
	private String name;
	
	@OneToMany(mappedBy="country")
	private Set<Player> playerList;

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

	
	public Set<Player> getPlayerList() {
		return playerList;
	}

	public void setPlayerList(Set<Player> playerList) {
		this.playerList = playerList;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + ", playerList=" + playerList + "]";
	}
	
	

}
