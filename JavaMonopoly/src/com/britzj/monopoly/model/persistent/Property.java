package com.britzj.monopoly.model.persistent;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

/**
 * Each instance of this class represents each of the 40 spaces on the Monopoly
 * board.
 * 
 * This class is also used when loading the database table 'Property' into
 * memory. Each column's value has a corresponding getter method.
 * 
 * @author Jean Britz
 * @version 1.0
 * @since 1.0
 */
public class Property {
	
	/** Database table fields **/

	private int PId;
	private String PName;
	private long PPtId;
	private long PCost;
	private long PHouseCost;
	private long PMortageVal;
	private String PRgbColor;
	private int PPosX;
	private int PPosY;
	
	/** Database foreign fields **/
	private ArrayList<PropertyType> type;
	private ArrayList<Tariff> tariffs;
	
	/** Auxiliary fields **/
	private Point location;
	private Color color;

	Property() {
		
	}

	/**
	 * Returns the property's unique id
	 * 
	 * @return PId
	 */
	public int getPId() {
		return PId;
	}

	/**
	 * Returns the Property's name
	 * 
	 * @return PName column's row value
	 */
	public String getPName() {
		return PName;
	}

	/**
	 * Returns the Property's type id
	 * 
	 * @return PPtId column's row value
	 * @see {@link Property#getType()}
	 */
	public long getPPtId() {
		return PPtId;
	}

	/**
	 * Returns the initial cost of the property
	 * 
	 * @return PCost column's row value
	 */
	public long getPCost() {
		return PCost;
	}

	/**
	 * Returns the cost of a house on this property
	 * 
	 * @return PHouseCost column's row value
	 */
	public long getPHouseCost() {
		return PHouseCost;
	}

	/**
	 * Returns the mortage value of this property, if it is not applicable it will
	 * be 0.
	 * 
	 * @return PMortageVal column's row value
	 */
	public long getPMortageVal() {
		return PMortageVal;
	}

	/**
	 * Returns the R,G,B text value.
	 * 
	 * @return PRgbColor column's row value
	 * @see {@link Property#getColour()}
	 */
	public String getPRgbColor() {
		return PRgbColor;
	}

	/**
	 * Returns the X-axis value of the property's location
	 * 
	 * @return PPosX column's row value
	 * @see {@link Property#getLocation()}
	 */
	public int getPPosX() {
		return PPosX;
	}

	/**
	 * Returns the Y-axis value of the property's location
	 * 
	 * @return PPosY column's row value
	 * @see {@link Property#getLocation()}
	 */
	public int getPPosY() {
		return PPosY;
	}

	/**
	 * Return info about the type of property. In other words, PPtId foreign key's
	 * corresponding row value in the PropertyType table.
	 * 
	 * @return {@link PropertyType}
	 */
	public PropertyType getType() {
		return type.get(0);
	}

	/**
	 * Returns all tariffs in terms of renting rates when houses or a hotel are on
	 * the property.
	 * 
	 * @return (if any) Array of {@link Tariff} objects, which are applicable to
	 *         this property.
	 */
	public ArrayList<Tariff> getTariffs() {
		return tariffs;
	}

	/**
	 * Returns the color of the property, if it doesn't have a color it returns
	 * white
	 * 
	 * @return {@link Color}
	 */
	public Color getColour() {
		if (PRgbColor != null && !PRgbColor.isEmpty()) {
			String comp[] = getPRgbColor().split("[,]");
			if(color == null) {
			color = new Color(Integer.valueOf(comp[0]), 
							 Integer.valueOf(comp[1]), 
							 Integer.valueOf(comp[2]));
			}
		} else {
			return Color.white;
		}
		return color;
	}
	
	/**
	 * Returns a {@link Point} object of the physical location of the property on
	 * the board.
	 * 
	 * @return {@link Point} object, which contains X-Y co-ordinates of the
	 *         property's location
	 */
	public Point getLocation() {
		if(location == null) {
		location = new Point(PPosX, PPosY);
		}
		return location;
	}
	
	/**
	 * Returns a boolean value which states if this property can be owned by a
	 * player
	 * 
	 * @return true - It can be owned/bought, false - it cannot be owned/bought
	 */
	public boolean isOwnable() {
		if (type != null) {
			return type.get(0).getPtOwnable();
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getPName() + ' ' + type.get(0).getPtName();
	}

}
