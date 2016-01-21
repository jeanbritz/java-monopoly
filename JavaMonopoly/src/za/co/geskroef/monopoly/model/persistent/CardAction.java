package za.co.geskroef.monopoly.model.persistent;

import za.co.neilson.sqlite.orm.annotations.ForeignKey;
import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

public class CardAction {

	/** Database table fields **/
	@PrimaryKey(autoIncrement = true)
	@ForeignKey(table = "Card", column = "CCaId", parentReference = "action")
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
