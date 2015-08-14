package com.monopoly.dialog;


import java.awt.BorderLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.monopoly.models.ChanceCard;

public class PropertyCardViewer extends AbstractViewer {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Icon imageHouseCost = new ImageIcon("house.png");
	
	JLabel labelPropertyType = new JLabel("Property Type");
	JLabel labelPropertyCost = new JLabel("Property Cost");
	
	JLabel labelHouseCost = new JLabel("Cost of house");
	
	public PropertyCardViewer() {
		super();
		
		setTitle("Monopoly");
		setBounds(70, 70, 270, 300);
		
	}
	
	public void setData(ChanceCard propertyCard) {
		
	}
	
	@Override
	public void onCloseClick() {
		dispose();
		
	}

	@Override
	public void initUI() {
		getContentPane().setLayout(new BorderLayout(0,1));
		getContentPane().add(panelHeader, BorderLayout.NORTH);
		getContentPane().add(panelBody, BorderLayout.CENTER);
		getContentPane().add(panelFooter, BorderLayout.SOUTH);
		
		buttonClose.addActionListener(this);
		labelHeader.setFont(fontHeader);
		labelHeader.setVerticalAlignment(JLabel.CENTER);
		labelHeader.setHorizontalAlignment(JLabel.CENTER);
		
		
		
	}

}