package com.monopoly.models.persistent;

import za.co.neilson.sqlite.orm.annotations.ForeignKey;
import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

public class CardAction {

	/** Database table fields **/
	@PrimaryKey(autoIncrement = true)
	@ForeignKey(table = "Card", column = "CCaId", parentReference = "action")
	private int CaId;
	private String CaAction;
	private String CaParams;

	public int getCaId() {
		return CaId;
	}

	public String getCaAction() {
		return CaAction;
	}

	public String getCaParams() {
		return CaParams;
	}

}
