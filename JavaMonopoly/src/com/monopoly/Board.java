package com.monopoly;

import java.awt.Image;
import java.awt.Toolkit;

public class Board {
	
	private static String imagePath = "data\\board.jpg";
	private Image image = null;
	private int height = 550;
	private int width = 560;
	
	Board() {
	
	}
	
	public Image getImage() {
		if(this.image == null) {
			this.image = Toolkit.getDefaultToolkit().getImage(imagePath);
		}
		return this.image;
	}
	
	public int getWidth() {
		return this.height;
	}
	
	public int getHeight() {
		return this.width;
	}
}
