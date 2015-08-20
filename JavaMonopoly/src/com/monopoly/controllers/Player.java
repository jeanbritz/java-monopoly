package com.monopoly.controllers;

import java.util.Vector;

import com.monopoly.models.Property;


public class Player {
	
	private int id;
	private String name;
	private Vector<Property> ownedProperties;
	private boolean isInJail = false;
	private int bankBalance = 0;
	
	Player(Referee ref) {
		
	}
	
	public Vector<Property> getOwnedProperties() {
		return ownedProperties;
	}

	public void setOwnedProperties(Vector<Property> ownedProperties) {
		this.ownedProperties = ownedProperties;
	}
	
	public void addProperty(Property property) {
		ownedProperties.add(property);
	}
	
	public void removeProperty(Property property) {
		ownedProperties.remove(property);
	}
	
	public boolean isInJail() {
		return isInJail;
	}

	public void setInJail(boolean isInJail) {
		this.isInJail = isInJail;
	}

	public int getBankBalance() {
		return bankBalance;
	}

	public void setBankBalance(int bankBalance) {
		this.bankBalance = bankBalance;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
		
}
