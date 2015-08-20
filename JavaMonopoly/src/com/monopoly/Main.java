package com.monopoly;

import com.monopoly.views.Monopoly;

public class Main {

	public static void main(String[] args) {
		Monopoly m = new Monopoly();
		Thread mthread = new Thread(m);
		mthread.start();

	}

}
