package com.monopoly.models;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

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
	private static TableModel tableModelTariff;
	
	public Property() {
		tariffs = new ArrayList<Tariff>();
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
	
	public Color getColour() {
		if(getRgb() != null) {
			String comp[] = getRgb().split("[,]");
			return new Color(Integer.valueOf(comp[0]), 
							 Integer.valueOf(comp[1]), 
							 Integer.valueOf(comp[2]));
		}
		return null;
	};
	public Point getBoardLocation() {
		return boardLocation;
	}
	public void setBoardLocation(Point boardLocation) {
		this.boardLocation = boardLocation;
	}
	public List<Tariff> getTariffs() {
		return tariffs;
	}
	public void addTariff(int code, int cost) {
		this.tariffs.add(new Tariff(code, cost));
	}
	
	public TableModel getTariffTableModel() {
					
			tableModelTariff = new AbstractTableModel() {
				 
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				@Override
				public int getRowCount() {
					return getTariffs().size();
				}

				@Override
				public int getColumnCount() {
					return Tariff.COLUMN_COUNT;
				}

				@Override
				public Object getValueAt(int rowIndex, int columnIndex) {
					Tariff t = getTariffs().get(rowIndex);
					String prefix = "";
					if(getType().equals("Street")) {
						prefix = "house";
					}
					if(columnIndex == Tariff.P_T_CODE_COL_IDX) {
						if(t.getCode() > 0) {
							return "Rent + " + t.getCode() + " " + prefix;
						} else {
							return "Rent";
						}
					} 
					else if (columnIndex == Tariff.P_T_COST_COL_IDX) {
						return t.getCost();
					}
					return null;
				}
				
			};
		
		return tableModelTariff;
	}
	
	
	public class Tariff {
		
		public final static String P_T_CODE_COL_NAME = "Code";
		public final static String P_T_COST_COL_NAME = "Cost";
		public final static int P_T_CODE_COL_IDX = 0;
		public final static int P_T_COST_COL_IDX = 1;
		public final static int COLUMN_COUNT = 2;
				
		private int code;
		private int cost;
		
		Tariff(int code, int cost) {
			this.code = code;
			this.cost = cost;
		}
		public int getCode() {
			return code;
		}
		public void setCode(int code) {
			this.code = code;
		}
		public int getCost() {
			return cost;
		}
		public void setCost(int cost) {
			this.cost = cost;
		}
		
		@Override
		public String toString() {
			return "Tariff [ code=" + code + ",cost="+ cost + " ]";
		}
				
	}

}
