package com.monopoly;

public class Player {
	
	private int id;
	private String name;
	
	Player(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
