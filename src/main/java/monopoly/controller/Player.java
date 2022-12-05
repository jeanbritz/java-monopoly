package monopoly.controller;

import java.awt.Image;
import java.util.List;
import java.util.Vector;

import monopoly.Asset;
import monopoly.Game;
import monopoly.AppLogger;
import monopoly.model.persistent.Property;
import monopoly.view.framework.PlayerActionEvents;


public class Player implements PlayerActionEvents {
	
	private int id;
	private String name;
	private Vector<Property> ownedProperties;
	private Property propertyAt;
	private boolean isInJail = false;
	private int bankBalance = 0;
	private Image token;
	private int round;
	
	Player(Banker banker) {
		List<Property> properties = Asset.getProperties();
		// propertyAt = Asset.getAllPropertyRecords().get(0);
		bankBalance = banker.INITIAL_BANK_BALANCE;
	}
	
	public Player(Banker ref, String name) {
		this(ref);
		this.name = name;
	}

	public Vector<Property> getOwnedProperties() {
		return ownedProperties;
	}

	public void setOwnedProperties(Vector<Property> ownedProperties) {
		this.ownedProperties = ownedProperties;
	}
	
	public void addProperty(Property property) {
		ownedProperties.add(property);
	}
	
	public void removeProperty(Property property) {
		ownedProperties.remove(property);
	}
	
	public boolean isInJail() {
		return isInJail;
	}

	public void setInJail(boolean isInJail) {
		this.isInJail = isInJail;
	}

	public int getBankBalance() {
		return bankBalance;
	}

	public void setBankBalance(int bankBalance) {
		this.bankBalance = bankBalance;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public Image getToken() {
		return token;
	}

	public void setToken(Image token) {
		this.token = token;
	}
	
	public Property getPropertyAt() {
		return propertyAt;
	}
	
	public void setPropertyAt(Property property) {
		this.propertyAt = property;
	}
	
	public void nextRound() {
		this.round++;
	}
	
	public int getRound() {
		return this.round;
	}

	public void move(int spaces) {
		long currentProp = propertyAt.getPId();
		long nextProp = currentProp + spaces;
		Property next = Asset.getSingleProperty(nextProp);
		propertyAt = next;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", propertyAt=" + propertyAt.getPId()
				+ ", isInJail=" + isInJail + ", bankBalance=" + bankBalance
				+ ", round=" + round + "]";
	}

	@Override
	public void onRollClick() {
		Game.getDice().roll();
		AppLogger.info("onRollClick");

	}

	@Override
	public void onEndTurnClick() {
		AppLogger.info("onEndTurnClick");

	}

	@Override
	public void onBuyClick() {
		AppLogger.info("onBuyClick");

	}

	@Override
	public void onCheckRentClick() {
		AppLogger.info("onCheckRentClick");

	}

}
