package com.monopoly.models.persistent;

import za.co.neilson.sqlite.orm.annotations.ForeignKey;
import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

public class Tariff {
	
	/** Database table fields **/
	@PrimaryKey(autoIncrement = true)
	private long TId;
	
	@ForeignKey(table = "Property", column = "PId", parentReference = "tariffs")
	private long TPId;
	private long TCode;
	private long TCost;

	Tariff() {

	}

	/**
	 * 
	 * @return
	 */
	public long getTId() {
		return TId;
	}

	/**
	 * 
	 * @return
	 */
	public long getTPId() {
		return TPId;
	}

	/**
	 * 
	 * @return
	 */
	public long getTCode() {
		return TCode;
	}

	/**
	 * 
	 * @return
	 */
	public long getTCost() {
		return TCost;
	}

}
