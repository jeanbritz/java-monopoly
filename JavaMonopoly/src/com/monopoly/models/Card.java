package com.monopoly.models;

public class Card {
	private int id;
	private String group;
	private String type;
	private String consequence;
	private String message;
	private boolean inUse = false;
	
	
	
	Card(int id, String group, String type, String cons, String msg) {
		super();
		this.id = id;
		this.group = group;
		this.type = type;
		this.consequence = cons;
		this.message = msg;
		this.inUse = false;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getGroup() {
		return this.group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getType() {
		return this.type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getConsequence() {
		return consequence;
	}
	public void setConsequence(String cons) {
		this.consequence = cons;
	}
	public String getMessage() {
		return this.message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isInUse() {
		return inUse;
	}
	public void setInUse(boolean inUse) {
		this.inUse = inUse;
	}
	
}
