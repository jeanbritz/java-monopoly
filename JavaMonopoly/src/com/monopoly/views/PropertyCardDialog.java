package com.monopoly.views;


import java.awt.Color;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.monopoly.models.Property;

public class PropertyCardDialog extends AbstractDialog {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Icon imageHouseCost = new ImageIcon("house.png");
	
	JLabel labelPropertyType = new JLabel("Property Type");
	JLabel labelPropertyCost = new JLabel("Property Cost");
	
	JLabel labelHouseCost = new JLabel("Cost of house");
	
	
	
	public PropertyCardDialog() {
		super();
		
		setTitle("Monopoly");
		setBounds(70, 70, 270, 300);
		
		
	}
	
	public void setData(Property property) {
		labelBody.setText(property.getName() + " " + property.getType());
	}
	
	@Override
	public void onCloseClick() {
		dispose();
		
	}

	@Override
	public void initView() {
		getHeaderPanel().add(labelHeader);
		getBodyPanel().add(labelBody);
		getFooterPanel().add(buttonClose);
		
		
		
	}

	@Override
	public void updateView() {
				
	}

}