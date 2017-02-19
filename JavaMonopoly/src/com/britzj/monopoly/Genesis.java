package com.britzj.monopoly;

import java.lang.Thread.UncaughtExceptionHandler;

import javax.swing.UIManager;

import com.britzj.monopoly.controller.Banker;
import com.britzj.monopoly.view.Frontend;

public class Genesis implements UncaughtExceptionHandler {
	private static Banker banker;
	private static Frontend fe;

	private Genesis() {

	}

	public void init() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			banker = new Banker();
			fe = new Frontend(banker);
		} catch (Exception e) {
			AppLogger.severe(e.getMessage(), e);
			Asset.showErrorMessage("Error has occurred, check the logs \n" + e.getMessage());
		}

		Thread bankerThread = new Thread(banker);
		bankerThread.setName("The Banker");
		bankerThread.start();

		// Start up frontend
		Thread feThread = new Thread(fe);
		feThread.setName("The Frontend");
		feThread.start();

		Thread.setDefaultUncaughtExceptionHandler(this);
	}

	public static void main(String[] args) {
		Genesis g = new Genesis();
		g.init();

	}

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		AppLogger.severe("Thread [" + t.getName() + "] caused to throw an uncaught exception", e);
	}

}
