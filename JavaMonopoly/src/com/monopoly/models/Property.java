package com.monopoly.models;

import java.awt.Point;
import java.util.List;

import com.monopoly.Player;

public class Property {
	
	public static String P_ID = "PropID";
	public static String P_NAME = "PropName";
	public static String P_COST = "CostForProp";
	public static String P_TYPE = "PropType";
	public static String P_HOUSE_COST = "CostOfHouse";
	public static String P_MORTAGE = "MortageValue";
	public static String P_RGB_COLOUR = "RGB";
	public static String P_BOARD_POS_X = "PosX";
	public static String P_BOARD_POS_Y = "PosY";
	
	private int id;
	private String name;
	private String type;
	private int cost;
	private int houseCost;
	private int houseCount;
	private String mortage;
	private String rgb;
	private Point boardLocation;
	private List<Tariff> tariffs;
		
	public Property() {
		
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return this.type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getCost() {
		return this.cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getHouseCost() {
		return houseCost;
	}
	public void setHouseCost(int cost) {
		this.houseCost = cost;
	}
	public int getHouseCount() {
		return this.houseCount;
	}
	public void setHouseCount(int houseCount) {
		this.houseCount = houseCount;
	}
	public String getMortage() {
		return this.mortage;
	}
	public void setMortage(String mortage) {
		this.mortage = mortage;
	}
	public String getRgb() {
		return this.rgb;
	}
	public void setRgb(String rgb) {
		this.rgb = rgb;
	}
	public Point getBoardLocation() {
		return boardLocation;
	}
	public void setBoardLocation(Point boardLocation) {
		this.boardLocation = boardLocation;
	}
	public List<Tariff> getTariffs() {
		return tariffs;
	}
	public void setTariffs(List<Tariff> tariffs) {
		this.tariffs = tariffs;
	}
	
	public class Tariff {
		
		private String code;
		private String cost;
		
		Tariff(String code, String cost) {
			this.code = code;
			this.cost = cost;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getCost() {
			return cost;
		}
		public void setCost(String cost) {
			this.cost = cost;
		}
		
		@Override
		public String toString() {
			return "Tariff [ code=" + code + ",cost="+ cost + " ]";
		}
		
		
	}

}
