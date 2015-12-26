package com.monopoly.models.persistent;

import za.co.neilson.sqlite.orm.annotations.ForeignKey;
import za.co.neilson.sqlite.orm.annotations.Nullable;
import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

public class PropertyType {
	
	/** Database table fields **/
	@PrimaryKey(autoIncrement = true)
	//@ForeignKey(table = "Property", column = "PPtId", parentReference = "type")
	private long PtId;
	@Nullable(value = false)
	private String PtName;
	private long PtOwnable;
	
	public long getPtId() {
		return PtId;
	}
	public void setPtId(long ptId) {
		PtId = ptId;
	}
	public String getPtName() {
		return PtName;
	}
	public void setPtName(String ptName) {
		PtName = ptName;
	}
	public boolean getPtOwnable() {
		return PtOwnable == 0 ? false : true;
	}
	public void setPtOwnable(long ptOwnable) {
		PtOwnable = ptOwnable;
	}
	
	
	
}
