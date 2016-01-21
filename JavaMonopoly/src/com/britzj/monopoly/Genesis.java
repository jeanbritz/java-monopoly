package com.britzj.monopoly;

import javax.swing.UIManager;

import com.britzj.monopoly.controller.Banker;
import com.britzj.monopoly.view.Frontend;

public class Genesis {
	Banker banker;
	Frontend fe;

	Genesis() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			banker = new Banker();
			fe = new Frontend(banker);
		} catch (Exception e) {
			e.printStackTrace(System.err);
			Asset.showErrorMessage("Error has occurred, check the logs \n" + e.getMessage());
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

		Genesis m = new Genesis();

	}

}
