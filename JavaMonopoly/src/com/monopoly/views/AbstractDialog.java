
package com.monopoly.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 * 
 * Skeleton class of a typical dialog. The dialog has three sections: header, body and footer
 * @author BritzJ
 * @param <T>
 *
 */
public abstract class AbstractDialog<T> extends JDialog implements ActionListener, IViewComponent {

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
		initView();
		getContentPane().setLayout(new BorderLayout(0,1));
		getContentPane().add(panelHeader, BorderLayout.NORTH);
		getContentPane().add(panelBody, BorderLayout.CENTER);
		getContentPane().add(panelFooter, BorderLayout.SOUTH);
			
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
	 * Needs to be implemented by the subclass 
	 * for the subclass to be able to add more GUI to the dialog
	 * 
	 */
	@Override
	public abstract void initView();
	
	public abstract void setData(T data);
	/**
	 * 
	 * @param colour
	 */
	public void setColour(Color colour) {
		getContentPane().setBackground(colour);
	}


}
