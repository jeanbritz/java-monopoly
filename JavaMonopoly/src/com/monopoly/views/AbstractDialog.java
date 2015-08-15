/**
 * 
 */
package com.monopoly.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author BritzJ
 *
 */
public abstract class AbstractDialog extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Font fontHeader = new Font("Arial", 1, 25);
	Font fontBody = new Font("Arial", 1, 17);
	Font fontFooter = new Font("Arial", 1, 18);
	
	JPanel panelHeader = new JPanel (new FlowLayout());
	JPanel panelBody = new JPanel(new FlowLayout());
	JPanel panelFooter = new JPanel(new FlowLayout());
	
	JLabel labelHeader = new JLabel("Header");
	JLabel labelBody = new JLabel("Body");
	
	JButton buttonClose = new JButton("Close");
	
	
	
	public AbstractDialog() {
		super();
		initUI();
		pack();
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	/**
	 * 
	 */
	public abstract void initUI();
	
	/**
	 * 
	 * @param colour
	 */
	public void setColour(Color colour) {
		labelHeader.setBackground(colour);
		labelBody.setBackground(colour);
		getContentPane().setBackground(colour);
	}
	
	/**
	 * 
	 * @param header
	 */
	public void setHeaderText(String header) {
		labelHeader.setText(header);
	}
	
	/**
	 * 
	 * @param body
	 */
	public void setBodyText(String body) {
		labelBody.setText(body);
	}
	/**
	 * 
	 */
	public abstract void onCloseClick();
	
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
