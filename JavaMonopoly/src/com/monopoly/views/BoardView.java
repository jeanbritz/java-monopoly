package com.monopoly.views;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import com.monopoly.AssetLoader;
import com.monopoly.controllers.LinkedList.Node;
import com.monopoly.controllers.Player;
import com.monopoly.views.interfaces.Animatable;

public class BoardView extends JPanel implements Animatable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage image = null;
	private int height = 0;
	private int width = 0;
	private Node initNode;
	
	BoardView(Node initNode) {
		super();
		this.initNode = initNode;
		initView();
		
	}
			
	public void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, this);
		Node currentNode = initNode;
		while ((currentNode = currentNode.getNextNode()) != null) {

			Player player = currentNode.getData();
			Point pos = player.getPropertyAt().getLocation();
			g.drawImage(player.getToken(), (int) pos.getX() + player.getId() * 3, (int) pos.getY() + player.getId() * 3,
				    this);

		}

	}

	@Override
	public void initView() {
		image = AssetLoader.loadImage("Board");
		height = image.getHeight();
		width = image.getWidth();
		setSize(height, width);
		
	}

	@Override
	public void updateView() {
		repaint();
	}
}
