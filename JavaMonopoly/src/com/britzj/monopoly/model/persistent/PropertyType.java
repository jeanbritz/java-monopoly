package com.britzj.monopoly.model.persistent;

public class PropertyType {
	
	/** Database table fields **/

	private long PtId;
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
