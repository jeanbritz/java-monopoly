package com.monopoly.views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import com.monopoly.AssetLoader;

public class Monopoly extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int FRAMES_PER_SECOND = 25;
	private static final int SKIP_TICKS = 1000 / FRAMES_PER_SECOND;
	
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 600;
	
	AssetLoader loader;
	private Board board;
	private DiceViewComponent dice;
	private PropertyViewComponent property;
	private PlayerViewComponent player;
	private boolean running = false;
	
	
	
	
	public Monopoly() {
		
		// Initialize the frame
		setTitle("Monopoly");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setLocationRelativeTo(null);
		//setResizable(false);
		setVisible(true);
		
		board = new Board();
		dice = new DiceViewComponent();
		getContentPane().setLayout(new BorderLayout());
		property = new PropertyViewComponent();
		player = new PlayerViewComponent();
		getContentPane().add(board, BorderLayout.CENTER);
		getContentPane().add(dice, BorderLayout.LINE_END);
		//getContentPane().add(property);
		getContentPane().add(player, BorderLayout.PAGE_END);
		pack();
		
		run();
		
	}

	public void stop() {
		running = false;
	}
	
	/**
	 *  Start the game loop
	 */
	private void run() {
		long nextGameTick = System.nanoTime() / 1000000;
		long sleepTime;
		
		while(running) {
			board.updateGame();
			board.repaint();
			
			nextGameTick += SKIP_TICKS;
			sleepTime = nextGameTick - System.nanoTime() / 1000000;
			
			if(sleepTime > 0) {
				try {
					Thread.sleep(sleepTime);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

}
