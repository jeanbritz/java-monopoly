package com.monopoly.views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.monopoly.AssetLoader;
import com.monopoly.controllers.Player;
import com.monopoly.controllers.Referee;
import com.monopoly.models.Dices;
import com.monopoly.views.PlayerActionsView.IPlayerActionEvents;

public class Frontend extends JFrame implements ActionListener, FrontendViewable, Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 600;
	
	AssetLoader loader;
	private BoardView board;
	private DiceView dice;
	private PropertyManagerView propertyManager;
	private PlayerActionsView playerActions;
	private boolean running = false;
	ArrayList<Player> players = new ArrayList<Player>();
	JPanel panelRight = new JPanel();
	BoxLayout layoutRight = new BoxLayout(panelRight, BoxLayout.PAGE_AXIS);
	Referee ref;
	
	public Frontend(Referee ref) {
		
		// Initialize the frame
		setTitle("Monopoly");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setLocationRelativeTo(null);
		this.ref = ref;
		//setResizable(false);
		setVisible(true);
		//ref.getPlayers()
		board = new BoardView(null);
		dice = new DiceView();
		propertyManager = new PropertyManagerView();
		playerActions = new PlayerActionsView();
		playerActions.setOnClickListener(new PlayerActions());
		getContentPane().setLayout(new BorderLayout(2,2));
		getContentPane().add(board, BorderLayout.CENTER);
		panelRight.setLayout(layoutRight);
		panelRight.add(propertyManager);
		panelRight.add(dice);
		panelRight.setSize((int) (0.3*WINDOW_WIDTH), WINDOW_HEIGHT);
		getContentPane().add(panelRight, BorderLayout.EAST);
		getContentPane().add(playerActions, BorderLayout.PAGE_END);
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
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

	@Override
	public void initView() {
		
		
	}

	@Override
	public void updateView() {
		dice.updateView();
		propertyManager.updateView();
		playerActions.updateView();
	}
	
	public BoardView getBoardView() {
		return this.board;
	}
	
	public DiceView getDiceView() {
		return this.dice;
	}
	
	public PlayerActionsView getPlayerActionsView() {
		return playerActions;
	}
	
	@Override
	public void update(Graphics g) {
		super.update(g);
		
	}
	
	public class PlayerActions implements IPlayerActionEvents {

		@Override
		public void onRollClick() {
			System.out.println("Roll");
			Dices.getInstance().throwDices();
			if(Dices.getInstance().hasThrownDouble()) {
				System.out.println("You have thrown a double!!");
			}
		}

		@Override
		public void onEndTurnClick() {
			ref.getCurrentPlayer().nextRound();
			System.out.println(ref.getCurrentPlayer().getName() + " has end its turn");
			
		}

		@Override
		public void onBuyClick() {
			System.out.println("Buy clicked");
			
			
		}

		@Override
		public void onCheckRentClick() {
			System.out.println("Check rent clicked");
			
		}
		
	}
}
