package com.monopoly.controllers;

import java.util.ArrayList;

import com.monopoly.views.Monopoly;

public class Referee implements Runnable {

	ArrayList<Player> players = new ArrayList<Player>();
	
	public Referee(Monopoly monopoly) {
		Player p1 = new Player(this);
		Player p2 = new Player(this);
		p1.setId(1);
		p2.setId(2);
		p1.setName("Jean");
		p2.setName("Paul");
		
		
		
		
	}

	
	
	@Override
	public void run() {
		
		
	}
	
	
}
