package com.monopoly;

import com.monopoly.controllers.Referee;
import com.monopoly.views.Monopoly;

public class Main {

	public static void main(String[] args) {
		Referee ref = new Referee();
		Monopoly m = new Monopoly(ref);
		Thread refThread = new Thread(ref);
		refThread.start();
		/*Thread mpThread = new Thread(m);
		
		mpThread.setName("Monopoly");
		refThread.setName("Referee");
		mpThread.start();
		refThread.start();*/

	}

}
