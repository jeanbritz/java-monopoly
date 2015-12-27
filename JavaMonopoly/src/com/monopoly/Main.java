package com.monopoly;

import com.monopoly.controllers.Referee;
import com.monopoly.views.Frontend;

public class Main {

	public static void main(String[] args) {
		Referee ref = new Referee();
		
		// Start up frontend
		Frontend fe = new Frontend(ref);
		fe.setVisible(true);
		
		// Start the Referee in a seperate Thread
		Thread refThread = new Thread(ref);
		refThread.setName("The Referee");
		refThread.start();
		

	}

}
