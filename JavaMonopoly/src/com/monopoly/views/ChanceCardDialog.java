package com.monopoly.views;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;

import com.monopoly.models.ChanceCard;

public class ChanceCardDialog extends AbstractDialog<ChanceCard> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel labelHeader;
	private JLabel labelBody;
	private JButton buttonClose;
	
	
	public ChanceCardDialog() {
		super();
		
		setTitle("Monopoly");
		setBounds(70, 70, 270, 300);
		getBodyPanel().setBackground(Color.WHITE);
		getFooterPanel().setBackground(Color.WHITE);
		
		
	}
	
	@Override
	public void setData(ChanceCard data) {
		labelHeader.setText(data.getType());
		labelBody.setText(data.getMessage());
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
	}

	@Override
	public void initView() {
		labelHeader = new JLabel("Header");
		labelBody = new JLabel("Body");
		buttonClose = new JButton("Close");
		getHeaderPanel().add(labelHeader);
		getBodyPanel().add(labelBody);
		getFooterPanel().add(buttonClose);
	}

	
	@Override
	public void updateView() {
				
	}

	
	

}
