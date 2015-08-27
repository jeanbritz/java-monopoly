
package com.monopoly.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.monopoly.AssetLoader;

/**
 * @author BritzJ
 *
 */
public abstract class AbstractDialog extends JDialog implements ActionListener, IViewComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel panelHeader;
	private JPanel panelBody;
	private JPanel panelFooter;
		
	public AbstractDialog() {
		super();
		panelHeader = new JPanel(new FlowLayout());
		panelBody = new JPanel(new FlowLayout());
		panelFooter = new JPanel(new FlowLayout());
		
		labelHeader = new JLabel("Header");
		labelHeader.setFont(AssetLoader.loadFont("h2"));
		labelHeader.setVerticalAlignment(JLabel.CENTER);
		labelHeader.setHorizontalAlignment(JLabel.CENTER);
		
		labelBody = new JLabel("Body");
		labelBody.setFont(AssetLoader.loadFont("body"));
		buttonClose = new JButton("Close");
		
		getContentPane().setLayout(new BorderLayout(0,1));
		initView();
		getContentPane().add(panelHeader, BorderLayout.NORTH);
		getContentPane().add(panelBody, BorderLayout.CENTER);
		getContentPane().add(panelFooter, BorderLayout.SOUTH);
		buttonClose.addActionListener(this);
		
		pack();
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public JPanel getHeaderPanel() {
		return this.panelHeader;
	}
	
	public JPanel getBodyPanel() {
		return this.panelBody;
	}
	
	public JPanel getFooterPanel() {
		return this.panelFooter;
	}
	
	/**
	 * 
	 */
	@Override
	public abstract void initView();
	
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
