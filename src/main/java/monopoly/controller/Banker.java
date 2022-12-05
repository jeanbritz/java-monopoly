package monopoly.controller;

import monopoly.Asset;
import monopoly.Dice;
import monopoly.util.LinkedList;
import monopoly.view.framework.PlayerActionEvents;

public class Banker implements Runnable {

	private static final int FRAMES_PER_SECOND = 25;
	private static final int SKIP_TICKS = 1000 / FRAMES_PER_SECOND;
	public static final int INITIAL_BANK_BALANCE = 2000;
	public int currentRound = 1;
	
	private Player currentPlayer = null;
	private LinkedList players = null;
	private static Dice dice = new Dice();
	private boolean busy = false;
	
	public Banker() {
		players = new LinkedList();
		dice = new Dice();
		Player p1 = new Player(this);
		Player p2 = new Player(this);
		p1.setId(1);
		p2.setId(2);

		p1.setName("Jean");
		p2.setName("Paul");
		p1.setToken(Asset.loadImage("token1"));
		p2.setToken(Asset.loadImage("token2"));
		
		p1.setBankBalance(INITIAL_BANK_BALANCE);
		p1.setBankBalance(INITIAL_BANK_BALANCE);
		players.add(p1);
		players.add(p2);
		
		
		
	}
	
	@Override
	public void run() {
		long nextGameTick = System.nanoTime() / 1000000;
		long sleepTime;
		boolean running = true;

		currentPlayer = players.moveToNext();
		while(running) {
		
			nextGameTick += SKIP_TICKS;
			sleepTime = nextGameTick - System.nanoTime() / 1000000;
			
			if(sleepTime > 0) {
				try {
					Thread.sleep(sleepTime);
					if(currentPlayer.getRound() < currentRound) {
						// wait
					} else {
						// TODO: Should make a linked list of players or something to
						// implement a more realistic model of handling each round

						/*if(currentPlayerId >= players.size()) {
							currentPlayerId = 0;
						}*/
					//	currentPlayer = players.get(currentPlayerId);
					}
					
					
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public boolean isBusy() {
		return this.busy;
	}

	public void moveCurrentPlayer(int spaces) {
		busy = true;

			this.currentPlayer.move(spaces);

		busy = false;
	}

	public Dice getDice() {
		return dice;
	}

	public PlayerActionEvents getCurrentPlayer() {
		return this.currentPlayer;
	}
	
	public LinkedList getPlayers() {
		return this.players;
	}

	private void endRound() {
		currentRound++;
	}
	
}
