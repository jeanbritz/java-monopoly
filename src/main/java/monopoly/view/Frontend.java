package monopoly.view;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import monopoly.Game;
import monopoly.controller.Banker;
import monopoly.view.framework.Viewable;

/**
 * 
 * @author Jean Britz
 *
 */
public class Frontend extends JFrame implements Viewable, Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final int FRAMES_PER_SECOND = 25;
	private static final int SKIP_TICKS = 1000 / FRAMES_PER_SECOND;
	
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 600;

	private boolean running = false;

	private Banker banker;

	private BoardView boardView;
	private DiceView diceView;
	private PropertyManagerView propertyManagerView;
	private PlayerActionsView playerActionsView;

	private JPanel panelRight = new JPanel();
	private BoxLayout layoutRight = new BoxLayout(panelRight, BoxLayout.PAGE_AXIS);
	

	public Frontend(Banker banker) {
		this.banker = banker;
		boardView = new BoardView(Game.getPlayers().getInitNode());
		diceView = new DiceView(Game.getDice());
		propertyManagerView = new PropertyManagerView();
		playerActionsView = new PlayerActionsView();
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
		initView();
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
	 * @see main.java.monopoly.views.Viewable#initView()
	 */
	@Override
	public void initView() {



		// Initialise the main frame
		setTitle(Game.getTitle());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setLocationRelativeTo(null);
		setVisible(true);

		playerActionsView.setOnClickListener(banker.getCurrentPlayer());
		getContentPane().setLayout(new BorderLayout(2, 2));
		getContentPane().add(boardView, BorderLayout.CENTER);
		panelRight.setLayout(layoutRight);
		panelRight.add(propertyManagerView);
		panelRight.add(diceView);
		panelRight.setSize((int) (0.3 * WINDOW_WIDTH), WINDOW_HEIGHT);
		getContentPane().add(panelRight, BorderLayout.EAST);
		getContentPane().add(playerActionsView, BorderLayout.PAGE_END);
		
		boardView.initView();
		propertyManagerView.initView();
		diceView.initView();
		playerActionsView.initView();

		pack();
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see main.java.monopoly.views.FrontendViewable#updateView()
	 */
	@Override
	public void updateView() {
		diceView.updateView();
		propertyManagerView.updateView();
		playerActionsView.updateView();
		boardView.updateView();
	}
	
	/**
	 * 
	 * @return
	 */
	public BoardView getBoardView() {
		return this.boardView;
	}
	
	/**
	 * 
	 * @return
	 */
	public DiceView getDiceView() {
		return this.diceView;
	}
	
	/**
	 * 
	 * @return
	 */
	public PlayerActionsView getPlayerActionsView() {
		return playerActionsView;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.JFrame#update(java.awt.Graphics)
	 */
	@Override
	public void update(Graphics g) {
		// super.update(g);
		// boardView.update(g);
		// Where the actual animation comes
		
	}

}
