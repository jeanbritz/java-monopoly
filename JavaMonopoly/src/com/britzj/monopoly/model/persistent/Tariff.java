package com.britzj.monopoly.model.persistent;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Tariff")
public class Tariff {

	@Id
	@Column(name = "TId")
	private long TId;
	
	@ManyToOne
	@JoinColumn(name = "TPId")
	private Property property;


	@Column(name = "TCode")
	private long TCode;

	@Column(name = "TCost")
	private long TCost;

	Tariff() {

	}

	public long getTId() {
		return TId;
	}

	public void setTId(long tId) {
		TId = tId;
	}

	// public int getTPId() {
	// return TPId;
	// }

	// public void setTPId(int tPId) {
	// TPId = tPId;
	// }
	public long getTCode() {
		return TCode;
	}

	public void setTCode(long tCode) {
		TCode = tCode;
	}

	public long getTCost() {
		return TCost;
	}

	public void setTCost(long tCost) {
		TCost = tCost;
	}
	
	
}
