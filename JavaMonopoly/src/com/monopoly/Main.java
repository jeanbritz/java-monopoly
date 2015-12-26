package com.monopoly;

import com.monopoly.controllers.Referee;
import com.monopoly.views.Monopoly;

public class Main {

	public static void main(String[] args) {
		Referee ref = new Referee();
		Thread refThread = new Thread(ref);
		refThread.setName("The Referee");
		refThread.start();
		

	}

}
