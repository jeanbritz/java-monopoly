package com.monopoly;

import com.monopoly.controllers.LinkedList;
import com.monopoly.controllers.Player;
import com.monopoly.models.Dice;

public class Game {

	private static final String TITLE = "Monopoly";

	private static int round = 0;

	private static Dice dice = new Dice();
	private static LinkedList players = new LinkedList();


	/**
	 * 
	 * @return
	 */
	public static LinkedList getPlayers() {
		return players;
	}

	/**
	 * 
	 * @param player
	 */
	public void addPlayer(Player player) {
		players.add(player);
	}

	/**
	 * 
	 * @return
	 */
	public int getRound() {
		return round;
	}

	/**
	 * 
	 * @return
	 */
	public static Dice getDice() {
		return dice;
	}

	public static String getTitle() {
		return TITLE;
	}
}
