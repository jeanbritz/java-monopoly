package com.monopoly.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class PlayerWindow extends JComponent implements ActionListener, IView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Border border;
	TitledBorder titledBorder;
	
	JPanel panelTop = new JPanel(new BorderLayout (1,1));
	JPanel panelInfo = new JPanel(new FlowLayout());
	JPanel panelToken = new JPanel(new FlowLayout());
	JPanel panelActionButtons = new JPanel(new FlowLayout());
	
	JLabel labelMoney;
	JLabel labelJail;
	JLabel labelToken;
	
	JButton buttonBuy = new JButton("Make offer"); 
	JButton buttonRoll = new JButton("Roll the dice");
	JButton buttonViewProperty = new JButton("View properties");
	JButton buttonEndTurn = new JButton("End Turn");
	JButton buttonCheckRent = new JButton("Check if someone owes me rent");
	
	
	public PlayerWindow() {
		
	}
	
	@Override
	public void initUI() {
		setBounds(50, 660, 950, 150);
		
		labelMoney = new JLabel("None");
		labelJail = new JLabel("None");
		labelToken = new JLabel("None");
		border = BorderFactory.createMatteBorder(5, 5, 5, 5, new Color (184, 0, 0));
		titledBorder = new TitledBorder(border, "Pending", 1, 1, new Font("Arial", 1, 18), Color.black);
		panelActionButtons.add(buttonBuy);
		panelActionButtons.add(buttonRoll);
		panelActionButtons.add(buttonEndTurn);
		panelActionButtons.add(buttonCheckRent);
		panelToken.setLayout(new BoxLayout(panelInfo, 1));
		panelToken.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		panelToken.add(labelToken);
		panelInfo.add(panelToken);
		panelInfo.add(labelMoney);
		panelInfo.add(labelJail);
		panelTop.add(panelInfo, BorderLayout.WEST);
		panelTop.add(panelActionButtons, BorderLayout.CENTER);
		
		buttonEndTurn.addActionListener(this);
		buttonRoll.addActionListener(this);
		buttonBuy.addActionListener(this);
		buttonCheckRent.addActionListener(this);
		getContentPane().add(panelTop);
		pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

	@Override
	public void updateUI() {
		
		
	}
	
	
	
}
