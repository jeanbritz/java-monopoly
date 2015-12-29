package com.monopoly.models.persistent;

import za.co.neilson.sqlite.orm.annotations.ForeignKey;
import za.co.neilson.sqlite.orm.annotations.Nullable;
import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

public class PropertyType {
	
	/** Database table fields **/
	@PrimaryKey(autoIncrement = true)
	@ForeignKey(table = "Property", column = "PPtId", parentReference = "type")
	private long PtId;
	@Nullable(value = false)
	private String PtName;
	private long PtOwnable;
	
	/**
	 * 
	 * @return
	 */
	public long getPtId() {
		return PtId;
	}

	/**
	 * 
	 * @return
	 */
	public String getPtName() {
		return PtName;
	}

	/**
	 * 
	 * @return
	 */
	public boolean getPtOwnable() {
		return PtOwnable == 0 ? false : true;
	}
	
	

}
