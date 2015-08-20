package com.monopoly.views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.monopoly.AssetLoader;
import com.monopoly.models.Dices;

public class Monopoly extends JFrame implements ActionListener, IViewComponent, Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int FRAMES_PER_SECOND = 25;
	private static final int SKIP_TICKS = 1000 / FRAMES_PER_SECOND;
	
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 600;
	
	AssetLoader loader;
	private BoardViewComponent board;
	private DiceViewComponent dice;
	private PropertyManagerViewComponent propertyManager;
	private PlayerActionsViewComponent playerActions;
	private boolean running = false;
	
	JPanel panelRight = new JPanel();
	BoxLayout layoutRight = new BoxLayout(panelRight, BoxLayout.PAGE_AXIS);
	
	
	public Monopoly() {
		
		// Initialize the frame
		setTitle("Monopoly");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setLocationRelativeTo(null);
		//setResizable(false);
		setVisible(true);
		
		board = new BoardViewComponent();
		dice = new DiceViewComponent();
		propertyManager = new PropertyManagerViewComponent();
		playerActions = new PlayerActionsViewComponent();
		getContentPane().setLayout(new BorderLayout(2,2));
		getContentPane().add(board, BorderLayout.CENTER);
		panelRight.setLayout(layoutRight);
		panelRight.add(propertyManager);
		panelRight.add(dice);
		panelRight.setSize((int) (0.3*WINDOW_WIDTH), WINDOW_HEIGHT);
		getContentPane().add(panelRight, BorderLayout.EAST);
		getContentPane().add(playerActions, BorderLayout.PAGE_END);
		Dices.getInstance().throwDices();
		pack();
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		run();
		
	}

	public void stop() {
		running = false;
	}
	
	/**
	 *  Start the game loop
	 */
	@Override
	public void run() {
		long nextGameTick = System.nanoTime() / 1000000;
		long sleepTime;
		running = true;
		while(running) {
		
			nextGameTick += SKIP_TICKS;
			sleepTime = nextGameTick - System.nanoTime() / 1000000;
			
			if(sleepTime > 0) {
				try {
					Thread.sleep(sleepTime);
					updateView();
					
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

	@Override
	public void initView() {
		
		
	}

	@Override
	public void updateView() {
		board.updateView();
		dice.updateView();
		propertyManager.updateView();
		playerActions.updateView();
	}

}
