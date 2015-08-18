package com.monopoly.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.io.FileNotFoundException;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.monopoly.AssetLoader;

public class Board extends JPanel implements IViewComponent  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String imagePath = "data\\board.jpg";
	private Image image = null;
	private int height = 550;
	private int width = 560;
	private float alignmentX = 0;
	private float alignmentY = 0;
	
	Board() {
		super();
		initView();
		
	}
	
	public Image getImage() {
		if(this.image == null) {
			try {
				this.image = AssetLoader.loadImage("Board");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
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
		Dimension d = getSize();
		Insets insets = getInsets();
		int width = d.width - insets.left - insets.right;
		int height = d.height - insets.top - insets.left;
		float x = (width - image.getWidth(null)) * alignmentX;
		float y = (height - image.getHeight(null)) * alignmentY;
		g.drawImage(image, (int)x + insets.left, (int)y + insets.top, this);
	}

	@Override
	public void initView() {
		image = getImage();
		repaint();
	}

	@Override
	public void updateView() {
		
		
	}
}
