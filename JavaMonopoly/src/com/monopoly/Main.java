package com.monopoly;

import com.monopoly.controllers.Banker;
import com.monopoly.views.Frontend;

public class Main {

	public static void main(String[] args) {
		Banker ref = new Banker();
		Frontend fe = new Frontend(ref);
		
		// Start up frontend
		Thread feThread = new Thread(fe);
		feThread.setName("The Frontend");
		feThread.start();

		// Start the Referee
		// Thread refThread = new Thread(ref);
		// refThread.setName("The Referee");
		// refThread.start();
		

	}

}
