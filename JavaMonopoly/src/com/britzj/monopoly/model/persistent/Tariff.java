package com.britzj.monopoly.model.persistent;

public class Tariff {
	

	private long TId;
	

	private Property property;


	private long TCode;


	private long TCost;

	Tariff() {

	}

	public long getTId() {
		return TId;
	}

	public void setTId(long tId) {
		TId = tId;
	}

	public Property getProperty() {
		return this.property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public long getTCode() {
		return TCode;
	}

	public void setTCode(long tCode) {
		TCode = tCode;
	}

	public long getTCost() {
		return TCost;
	}

	public void setTCost(long tCost) {
		TCost = tCost;
	}
	
	
}
