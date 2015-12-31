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

	public int getCId() {
		return CId;
	}

	public String getCGroup() {
		return CGroup;
	}

	public int getCCaId() {
		return CCaId;
	}

	public String getCParamValues() {
		return CParamValues;
	}

	public String getCMessage() {
		return CMessage;
	}

	public ArrayList<CardAction> getAction() {
		return action;
	}

}
