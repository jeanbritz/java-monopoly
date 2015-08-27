package com.monopoly.views;


import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import com.monopoly.AssetLoader;
import com.monopoly.models.Property;

public class PropertyCardDialog extends AbstractDialog<Object> {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Icon imageHouseCost = new ImageIcon("house.png");
	
	JLabel labelPropertyType = new JLabel("Property Type");
	JLabel labelPropertyCost = new JLabel("Property Cost");
	
	JLabel labelHouseCost = new JLabel("Cost of house");
	
	JLabel labelHeader;
	JLabel labelBody;
	JButton buttonClose;
	
	
	public PropertyCardDialog() {
		super();
		
		setTitle("Monopoly");
		setBounds(70, 70, 270, 300);
		
		
		
	}
		
	public void onCloseClick() {
		dispose();
	}

	@Override
	public void setData(Object data) {
		Property prop = (Property)data;
		labelHeader.setText(prop.getName() + " " + prop.getType());
		labelHeader.setBackground(prop.getColour());
		labelBody.setText(prop.getHouseCost()+" ZAR");
		
	}

	
	@Override
	public void initView() {
		labelHeader = new JLabel("Header");
		labelHeader.setBackground(Color.white);
		labelHeader.setFont(AssetLoader.loadFont("h2"));
		labelHeader.setVerticalAlignment(JLabel.CENTER);
		labelHeader.setHorizontalAlignment(JLabel.CENTER);
		
		labelBody = new JLabel("Body");
		labelBody.setFont(AssetLoader.loadFont("h2"));
		buttonClose = new JButton("Close");
				
		getHeaderPanel().add(labelHeader);
		getBodyPanel().add(labelBody);
		getFooterPanel().add(buttonClose);
		
		buttonClose.addActionListener(this);
		
		
	}
	
	@Override
	public void updateView() {
				
	}
	
	/**
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource().equals(buttonClose)) {
			onCloseClick();
		}
	}

}