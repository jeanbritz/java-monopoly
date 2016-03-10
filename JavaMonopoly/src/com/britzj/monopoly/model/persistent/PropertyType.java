package com.britzj.monopoly.model.persistent;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PropertyType")
public class PropertyType {
	
	/** Database table fields **/

	@Id
	@Column(name = "PtId")
	private long PtId;

	@Column(name = "PtName")
	private String PtName;

	@Column(name = "PtOwnable")
	private long PtOwnable;
	
	public long getPtId() {
		return PtId;
	}

	public String getPtName() {
		return PtName;
	}

	public boolean getPtOwnable() {
		return PtOwnable == 0 ? false : true;
	}

}
