package com.monopoly.controllers;


public class Player {
	
	private int id;
	private String name;
	
	
	
	Player(Referee ref) {
		
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
