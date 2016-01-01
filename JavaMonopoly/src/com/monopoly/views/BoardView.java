package com.monopoly.views;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import com.monopoly.AssetLoader;
import com.monopoly.controllers.PlayerLinkedList;
import com.monopoly.views.intefaces.Animatable;

public class BoardView extends JPanel implements Animatable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage image = null;
	private int height = 0;
	private int width = 0;
	private PlayerLinkedList players;
	
	BoardView(PlayerLinkedList players) {
		super();
		this.players = players;
		initView();
		
	}
			
	public void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, this);
		if (players != null) {
			for (int i = 0; i < players.getSize(); i++) {
				Point pos = players.get(i).getPropertyAt().getLocation();
				g.drawImage(players.get(i).getToken(), (int) pos.getX() + players.get(i).getId() * 3,
				    (int) pos.getY() + players.get(i).getId() * 3,
				    this);

			}
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
