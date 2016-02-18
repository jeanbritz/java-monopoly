package com.britzj.monopoly.model.persistent;

public class CardAction {

	/** Database table fields **/
	private int CaId;
	private String CaAction;
	private String CaParams;

	/**
	 * 
	 * @return
	 */
	public int getCaId() {
		return CaId;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getCaAction() {
		return CaAction;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getCaParams() {
		return CaParams;
	}

}
