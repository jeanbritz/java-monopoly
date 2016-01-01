package com.monopoly.views;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.monopoly.controllers.Banker;
import com.monopoly.models.Dices;
import com.monopoly.views.PlayerActionsView.PlayerActionEvents;
import com.monopoly.views.interfaces.Viewable;

/**
 * 
 * @author Jean Britz
 *
 */
public class Frontend extends JFrame implements ActionListener, Viewable, Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final int FRAMES_PER_SECOND = 25;
	private static final int SKIP_TICKS = 1000 / FRAMES_PER_SECOND;
	
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 600;

	private BoardView board;
	private DiceView dice;
	private PropertyManagerView propertyManager;
	private PlayerActionsView playerActions;
	private boolean running = false;
	private JPanel panelRight = new JPanel();
	private BoxLayout layoutRight = new BoxLayout(panelRight, BoxLayout.PAGE_AXIS);
	private Banker banker;
	
	public Frontend(Banker banker) {
		this.banker = banker;
		initView();
	}

	/**
	 * 
	 */
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

		while (running) {

			nextGameTick += SKIP_TICKS;
			sleepTime = nextGameTick - System.nanoTime() / 1000000;

			if (sleepTime > 0) {
				try {
					Thread.sleep(sleepTime);
					updateView();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.monopoly.views.FrontendViewable#initView()
	 */
	@Override
	public void initView() {

		/*
		 * try {
		 * UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); }
		 * catch (ClassNotFoundException | InstantiationException |
		 * IllegalAccessException | UnsupportedLookAndFeelException ex) { }
		 */

		// Initialise the main frame
		setTitle("Monopoly");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setLocationRelativeTo(null);
		setVisible(true);

		board = new BoardView(banker.getPlayers().getInitNode());
		dice = new DiceView();
		propertyManager = new PropertyManagerView();
		playerActions = new PlayerActionsView();
		playerActions.setOnClickListener(new PlayerActions());
		getContentPane().setLayout(new BorderLayout(2, 2));
		getContentPane().add(board, BorderLayout.CENTER);
		panelRight.setLayout(layoutRight);
		panelRight.add(propertyManager);
		panelRight.add(dice);
		panelRight.setSize((int) (0.3 * WINDOW_WIDTH), WINDOW_HEIGHT);
		getContentPane().add(panelRight, BorderLayout.EAST);
		getContentPane().add(playerActions, BorderLayout.PAGE_END);
		pack();
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.monopoly.views.FrontendViewable#updateView()
	 */
	@Override
	public void updateView() {
		dice.updateView();
		propertyManager.updateView();
		playerActions.updateView();
		board.updateView();
	}
	
	/**
	 * 
	 * @return
	 */
	public BoardView getBoardView() {
		return this.board;
	}
	
	/**
	 * 
	 * @return
	 */
	public DiceView getDiceView() {
		return this.dice;
	}
	
	/**
	 * 
	 * @return
	 */
	public PlayerActionsView getPlayerActionsView() {
		return playerActions;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.JFrame#update(java.awt.Graphics)
	 */
	@Override
	public void update(Graphics g) {
		super.update(g);
		board.update(g);
		// Where the actual animation comes
		
	}

	/**
	 * 
	 * @author Jean Britz
	 *
	 */
	public class PlayerActions implements PlayerActionEvents {

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
			banker.getCurrentPlayer().nextRound();
			System.out.println(banker.getCurrentPlayer().getName() + " has end its turn");
			
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
