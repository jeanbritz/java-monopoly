package com.britzj.monopoly.model.persistent;

import java.awt.Color;
import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

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
@Entity
@Table(name = "Property")
public class Property implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Database table fields **/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PId")
	private int PId;

	@Column(name = "PName")
	private String PName;

	@Column(name = "PCost")
	private long PCost;

	@Column(name = "PHouseCost")
	private long PHouseCost;

	@Column(name = "PMortageVal")
	private long PMortageVal;

	@Column(name = "PRgbColor")
	private String PRgbColor;

	@Column(name = "PPosX")
	private int PPosX;

	@Column(name = "PPosY")
	private int PPosY;

	@ManyToOne
	@JoinColumn(name = "PPtId")
	private PropertyType type;

	@OneToMany(mappedBy = "property")
	private Set<Tariff> tariffs;

	/** Auxiliary fields **/
	@Transient
	private Point location;
	@Transient
	private Color color;

	Property() {
		
	}

	/**
	 * Returns the property's unique id
	 * 
	 * @return PId
	 */
	public long getPId() {
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
	 * 
	 * @return
	 */
	public String getPtName() {
		return type.getPtName();
	}

	public long getPtId() {
		return type.getPtId();
	}

	/**
	 * 
	 * @return
	 */
	public boolean getPtOwnable() {
		return type.getPtOwnable();
	}

	/**
	 * Return info about the type of property. In other words, PPtId foreign key's
	 * corresponding row value in the PropertyType table.
	 * 
	 * @return {@link PropertyType}
	 */
	// public PropertyType getType() {
	// return type.get(0);
	// }

	/**
	 * Returns all tariffs in terms of renting rates when houses or a hotel are on
	 * the property.
	 * 
	 * @return (if any) Array of {@link Tariff} objects, which are applicable to
	 *         this property.
	 */
	public ArrayList<Tariff> getTariffs() {
		return new ArrayList<Tariff>(tariffs);
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
			if (color == null) {
				int r = Integer.parseInt(comp[0]);
				int g = Integer.parseInt(comp[1]);
				int b = Integer.parseInt(comp[2]);
				color = new Color(r, g, b);
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
		if (location == null) {
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
	
	@Override
	public String toString() {
		return getPName() + ' ' + getPtName();
	}

}
