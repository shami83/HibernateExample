package com.example.hibernate.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.IndexColumn;


@Entity
@Table(name = "INDIA", uniqueConstraints = {@UniqueConstraint(columnNames = "ID")})
public class India {
	@Id
	private Long id;
	
	@Column(name = "COUNTRY_NAME", unique = true, nullable = false, length = 100)
	private String name;
	
	
	@OneToMany(mappedBy="india",cascade={CascadeType.ALL})
	@IndexColumn(name="list_idx")// For List Mapping
	
	private List<IndianPlayer> playerList = new ArrayList<IndianPlayer>();
	
	
	@OneToMany(mappedBy="india",cascade={CascadeType.ALL})
	@MapKey(name="name")	
	private Map<String,IndianPlayer> playerMap = new HashMap<String,IndianPlayer>();
	

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

	
	public List<IndianPlayer> getPlayerList() {
		return playerList;
	}

	public void setPlayerList(List<IndianPlayer> playerList) {
		this.playerList = playerList;
	}
	
	public void add(IndianPlayer player)
	{
		this.playerList.add(player);
	}

	public Map<String, IndianPlayer> getPlayerMap() {
		return playerMap;
	}

	public void setPlayerMap(Map<String, IndianPlayer> playerMap) {
		this.playerMap = playerMap;
	}

	@Override
	public String toString() {
		return "India [id=" + id + ", name=" + name + ", playerList=" + playerList + ", playerMap=" + playerMap + "]";
	}

	

}
