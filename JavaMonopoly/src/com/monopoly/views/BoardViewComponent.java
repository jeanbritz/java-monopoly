package com.monopoly.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.monopoly.AssetLoader;

public class BoardViewComponent extends JPanel implements IViewComponent  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage image = null;
	private int height = 0;
	private int width = 0;
	
	BoardViewComponent() {
		super();
		initView();
		
	}
			
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this);
	}

	@Override
	public void initView() {
		image = AssetLoader.loadImage("Board");
		height = image.getHeight();
		width = image.getWidth();
		setSize(height, width);
		
		repaint();
	}

	@Override
	public void updateView() {
		
		
	}
}
