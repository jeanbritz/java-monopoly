package com.monopoly.models.persistent;

import java.awt.Color;
import java.awt.Point;
import java.util.Collection;

import za.co.neilson.sqlite.orm.annotations.Nullable;
import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

public class Property {
	
	/** Database table fields **/
	@PrimaryKey(autoIncrement = true)
	private long PId;
	@Nullable(value = false)
	private String PName;
	private PropertyType type;
	private long PCost;
	private long PHouseCost;
	private long PMortageVal;
	private String PRgbColor;
	private int PPosX;
	private int PPosY;
	
	/** Database foreign fields **/
	private Collection<Tariff> tariffs;
	
	/** Auxilary fields **/
	private Point location;
	private Color color;
		

	public long getPId() {
		return PId;
	}

	public void setPId(long pId) {
		PId = pId;
	}

	public String getPName() {
		return PName;
	}

	public void setPName(String pName) {
		PName = pName;
	}

	public PropertyType getType() {
		return type;
	}

	public void setType(PropertyType type) {
		this.type = type;
	}

	public long getPCost() {
		return PCost;
	}

	public void setPCost(long pCost) {
		PCost = pCost;
	}

	public long getPHouseCost() {
		return PHouseCost;
	}

	public void setPHouseCost(long pHouseCost) {
		PHouseCost = pHouseCost;
	}

	public long getPMortageVal() {
		return PMortageVal;
	}

	public void setPMortageVal(long pMortageVal) {
		PMortageVal = pMortageVal;
	}

	public String getPRgbColor() {
		return PRgbColor;
	}

	public void setPRgbColor(String pRgbColor) {
		PRgbColor = pRgbColor;
	}

	public long getPPosX() {
		return PPosX;
	}

	public void setPPosX(int pPosX) {
		PPosX = pPosX;
	}

	public long getPPosY() {
		return PPosY;
	}

	public void setPPosY(int pPosY) {
		PPosY = pPosY;
	}

	public Collection<Tariff> getTariffs() {
		return tariffs;
	}

	public Color getColour() {
		if(PRgbColor != null) {
			String comp[] = PRgbColor.split("[,]");
			if(color == null) {
			color = new Color(Integer.valueOf(comp[0]), 
							 Integer.valueOf(comp[1]), 
							 Integer.valueOf(comp[2]));
			}
		}
		return color;
	}
	
	public Point getLocation() {
		if(location == null) {
		location = new Point(PPosX, PPosY);
		}
		return location;
	}
	public void setBoardLocation(Point location) {
		this.location = location;
	}
		
	
	
	
}
