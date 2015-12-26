package com.monopoly.models.persistent;

import za.co.neilson.sqlite.orm.annotations.ForeignKey;
import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

public class Tariff {
	
	@PrimaryKey(autoIncrement = true)
	private long TId;
	
	//@ForeignKey(table = "Property", column = "P_ID", childReference = "TPId", parentReference = "tariffs")
	private long TPId;
	private long TCode;
	private long TCost;

	public long getTId() {
		return TId;
	}

	public void setTId(long tId) {
		TId = tId;
	}

	public long getTPId() {
		return TPId;
	}

	public void setTPId(long tPId) {
		TPId = tPId;
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
