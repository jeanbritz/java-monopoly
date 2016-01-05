package com.monopoly;

import com.monopoly.controllers.Banker;
import com.monopoly.views.Frontend;

public class Main {
	Banker banker;
	Frontend fe;

	Main() {
		try {
			banker = new Banker();
			fe = new Frontend(banker);
		} catch (RuntimeException e) {
			Asset.showErrorMessage("Error has occurred, check the logs");
		}

		Thread bankerThread = new Thread(banker);
		bankerThread.setName("The Banker");
		bankerThread.start();

		// Start up frontend
		Thread feThread = new Thread(fe);
		feThread.setName("The Frontend");
		feThread.start();
	}

	public static void main(String[] args) {

		Main m = new Main();

	}

}
