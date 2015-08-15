package com.monopoly.views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class Board extends JComponent implements IView  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String imagePath = "data\\board.jpg";
	private Image image = null;
	private int height = 550;
	private int width = 560;
	
	Board() {
		initUI();
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
	
	public void updateGame() {
		// Receive game data from server to update board
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

	@Override
	public void initUI() {
		setBounds(0, 0, 300, 300);
		setBackground(Color.black);
		
	}
}
