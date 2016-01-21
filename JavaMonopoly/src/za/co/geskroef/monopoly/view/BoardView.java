package za.co.geskroef.monopoly.view;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import za.co.geskroef.monopoly.Asset;
import za.co.geskroef.monopoly.controller.Player;
import za.co.geskroef.monopoly.util.LinkedList.Node;
import za.co.geskroef.monopoly.view.framework.Animatable;

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
		image = Asset.loadImage("Board");
		height = image.getHeight();
		width = image.getWidth();
		setSize(height, width);
		
	}

	@Override
	public void updateView() {
		repaint();
	}
}
