package com.monopoly.views;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.List;

import javax.swing.JPanel;

import com.monopoly.AssetLoader;
import com.monopoly.controllers.Player;

public class BoardViewComponent extends JPanel implements IViewComponent  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage image = null;
	private int height = 0;
	private int width = 0;
	private List<Player> players;
	
	BoardViewComponent(List<Player> players) {
		super();
		this.players = players;
		initView();
		
	}
			
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(image, 0, 0, this);
		/*for(Player player : players) {
			Point pos = player.getPropertyAt().getBoardLocation();
			g.drawImage(player.getToken(), (int)pos.getX()+player.getId()*3, (int)pos.getY()+player.getId()*3, this);
					
		}*/
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
