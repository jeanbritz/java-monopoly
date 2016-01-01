package com.monopoly.controllers;

import java.awt.Image;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;

import com.monopoly.AssetLoader;
import com.monopoly.models.persistent.Property;


public class Player {
	
	private int id;
	private String name;
	private Vector<Property> ownedProperties;
	private Property propertyAt;
	private boolean isInJail = false;
	private int bankBalance = 0;
	private Image token;
	private int round;
	
	Player(Banker ref) {
		List<Property> records = AssetLoader.getAllPropertyRecords();
		//propertyAt = AssetLoader.getAllPropertyRecords().get(0);
		bankBalance = ref.INITIAL_BANK_BALANCE;
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

	public Image getToken() {
		return token;
	}

	public void setToken(Image token) {
		this.token = token;
	}
	
	public Property getPropertyAt() {
		return propertyAt;
	}
	
	public void setPropertyAt(Property property) {
		this.propertyAt = property;
	}
	
	public void nextRound() {
		this.round++;
	}
	
	public int getRound() {
		return this.round;
	}

	/*@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", propertyAt=" + propertyAt.getPId()
				+ ", isInJail=" + isInJail + ", bankBalance=" + bankBalance
				+ ", round=" + round + "]";
	}*/
	
	
	
	
		
}
