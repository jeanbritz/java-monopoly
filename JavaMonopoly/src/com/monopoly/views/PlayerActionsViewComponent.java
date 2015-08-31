package com.monopoly.views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class PlayerActionsViewComponent extends AbstractViewComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
	JPanel panelInfo;
	JPanel panelToken;
	JPanel panelActionButtons;
	
	JLabel labelMoney;
	JLabel labelJail;
	JLabel labelToken;
	
	JButton buttonBuy; 
	JButton buttonRoll;
	JButton buttonViewProperty;
	JButton buttonEndTurn;
	JButton buttonCheckRent;
	
	private PlayerActionListener actionlistener;
	private IPlayerActionEvents actionEvents;
	
	
	public PlayerActionsViewComponent() {
		super("Player Actions");
		
	}
	
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
		buttonViewProperty = new JButton("View properties");
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
	public void setOnClickListener(IPlayerActionEvents actions) {
		try {
			actionEvents = (IPlayerActionEvents) actions;
		} catch(ClassCastException e) {
			e.printStackTrace();
		}
	}	

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
			}
			if(event.getSource() == buttonEndTurn) {
				actionEvents.onEndTurnClick();
			}
			if(event.getSource() == buttonBuy) {
				actionEvents.onBuyClick();
			}
			if(event.getSource() == buttonCheckRent) {
				actionEvents.onCheckRentClick();
			}
			
		}
		
	}
	
	/**
	 * Interface class which defines the callback methods
	 * In this way the callback methods acts as an API and gives the
	 * user the ability to defined the callback methods in the
	 * class this view is declared in.
	 * @author BritzJ
	 *
	 */
	public  interface IPlayerActionEvents {
		public void onRollClick();
		public void onEndTurnClick();
		public void onBuyClick();
		public void onCheckRentClick();
		
	}
	
}
