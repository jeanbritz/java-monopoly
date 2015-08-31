package com.monopoly.models;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;



public class ChanceCard {
	
	public static String CC_ID = "CardId";
	public static String CC_GROUP = "Group";
	public static String CC_TYPE = "Type";
	public static String CC_MESSAGE = "Message";
	public static String CC_CONSEQUENCE = "Consequence";
		
	private int id;
	private String group;
	private String type;
	private String consequence;
	private String message;
	private boolean inUse = false;
		
	public ChanceCard() {
		
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
