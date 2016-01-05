package com.monopoly.models.persistent;

import java.util.ArrayList;

import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

public class Card {

	/** Database table fields **/
	@PrimaryKey(autoIncrement = true)
	private int CId;
	private String CGroup;
	private int CCaId;
	private String CParamValues;
	private String CMessage;

	/** Database foreign fields **/
	private ArrayList<CardAction> action;

	/**
	 * 
	 * @return
	 */
	public int getCId() {
		return CId;
	}

	/**
	 * 
	 * @return
	 */
	public String getCGroup() {
		return CGroup;
	}

	/**
	 * 
	 * @return
	 */
	public int getCCaId() {
		return CCaId;
	}

	/**
	 * 
	 * @return
	 */
	public String getCParamValues() {
		return CParamValues;
	}

	/**
	 * 
	 * @return
	 */
	public String getCMessage() {
		return CMessage;
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<CardAction> getAction() {
		return action;
	}

}
