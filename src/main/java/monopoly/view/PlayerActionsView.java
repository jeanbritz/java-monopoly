package monopoly.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import monopoly.view.framework.PlayerActionEvents;

/**
 * 
 * @author Jean Britz
 *
 */
public class PlayerActionsView extends AbstractView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
	private static JPanel panelInfo;
	private static JPanel panelToken;
	private static JPanel panelActionButtons;
	
	private static JLabel labelMoney;
	private static JLabel labelJail;
	private static JLabel labelToken;
	
	private static JButton buttonBuy;
	private static JButton buttonRoll;
	private static JButton buttonEndTurn;
	private static JButton buttonCheckRent;
	
	private PlayerActionListener actionlistener;
	private PlayerActionEvents actionEvents;
	
	
	public PlayerActionsView() {
		super("Player Actions");
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see main.java.monopoly.views.AbstractView#initView()
	 */
	@Override
	public void initView() {
		setBounds(50, 660, 950, 150);
		setBorderTitle("Actions");
		actionlistener = new PlayerActionListener();
		panelInfo = new JPanel(new FlowLayout());
		panelToken = new JPanel(new FlowLayout());
		panelActionButtons = new JPanel(new FlowLayout());
		labelMoney = new JLabel("2000");
		labelJail = new JLabel("None");
		labelToken = new JLabel("None");
		buttonBuy = new JButton("Make offer");
		buttonRoll = new JButton("Roll the dice");
		buttonEndTurn = new JButton("End Turn");
		buttonCheckRent = new JButton("Check if someone owes me rent");
		panelActionButtons.add(buttonBuy);
		panelActionButtons.add(buttonRoll);
		panelActionButtons.add(buttonEndTurn);
		panelActionButtons.add(buttonCheckRent);
		//panelToken.setLayout(new BoxLayout(panelInfo, 1));
		panelToken.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		panelToken.add(labelToken);
		panelInfo.add(panelToken);
		panelInfo.add(labelMoney);
		panelInfo.add(labelJail);
		panelTop.add(panelInfo, BorderLayout.WEST);
		panelTop.add(panelActionButtons, BorderLayout.CENTER);
		
		buttonEndTurn.addActionListener(actionlistener);
		buttonRoll.addActionListener(actionlistener);
		buttonBuy.addActionListener(actionlistener);
		buttonCheckRent.addActionListener(actionlistener);
		buttonEndTurn.addActionListener(actionlistener);
		add(panelTop);
		
	}
	
	
	/**
	 * 
	 * @param actions
	 */
	public void setOnClickListener(PlayerActionEvents actions) {
		try {
			actionEvents = (PlayerActionEvents) actions;
		} catch(ClassCastException e) {
			e.printStackTrace();
		}
	}	

	/*
	 * (non-Javadoc)
	 * 
	 * @see main.java.monopoly.views.AbstractView#updateView()
	 */
	@Override
	public void updateView() {
		
		
	}
	
	/**
	 * Inner class to map each callback method to 'listen' 
	 * for the correct {@link JButton} when the user clicks on
	 * the button
	 * 
	 * @author BritzJ
	 *
	 */
	private class PlayerActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {

			if(event.getSource() == buttonRoll) {
				actionEvents.onRollClick();
			} else if (event.getSource() == buttonEndTurn) {
				actionEvents.onEndTurnClick();
			} else if (event.getSource() == buttonBuy) {
				actionEvents.onBuyClick();
			} else if (event.getSource() == buttonCheckRent) {
				actionEvents.onCheckRentClick();
			}
			
		}
		
	}
		
}
