package com.monopoly.models;

public class Dices {
	
	private int first = 0;
	private int second = 0;
	
	private static Dices dices;
	
	public static Dices getInstance() {
		if(dices == null) {
			dices = new Dices();
		}
		return dices;
	}
	
	public int getOutcome() {
		return this.first + this.second;
	}
	
	public boolean hasThrownDouble() {
		return this.first == this.second;
	}
	
	public void throwDices() {
		this.first = (int)(Math.random() * 6) + 1;
		this.second = (int)(Math.random() * 6) + 1;
	}
}
