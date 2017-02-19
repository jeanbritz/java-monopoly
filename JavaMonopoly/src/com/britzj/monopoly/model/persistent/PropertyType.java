package com.britzj.monopoly.model.persistent;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PropertyType")
public class PropertyType {
	
	public static final long CORNER = 1;
	public static final int TAX = 2;
	public static final int CARD = 3;
	public static final int BOARD = 4;
	public static final int STATION = 5;
	public static final int ROAD = 6;
	public static final int STREET = 7;
	public static final int AVENUE = 8;
	public static final int SQUARE = 9;
	public static final int PARADE = 10;

	/** Database table fields **/

	@Id
	@Column(name = "PtId")
	private short PtId;

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
