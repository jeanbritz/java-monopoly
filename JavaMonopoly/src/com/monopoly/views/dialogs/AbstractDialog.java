
package com.monopoly.views.dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JPanel;

import com.monopoly.views.intefaces.Viewable;

/**
 * 
 * Skeleton class of a typical dialog. The dialog has three sections: header,
 * body and footer <br>
 * <br>
 * <table border="1px">
 * <tbody>
 * <tr>
 * <td>Header panel</td>
 * </tr>
 * <tr>
 * <td>Body panel</td>
 * </tr>
 * <tr>
 * <td>Footer panel</td>
 * </tr>
 * </tbody>
 * </table>
 * 
 * 
 * @author Jean Britz
 * @param <T>
 * @version 1.0
 * @since 1.0
 *
 */
public abstract class AbstractDialog<T> extends JDialog implements ActionListener, Viewable {

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
	
	/**
	 * Returns object reference for header panel
	 * 
	 * @return
	 */
	public JPanel getHeaderPanel() {
		return this.panelHeader;
	}
	
	/**
	 * Returns object reference for body panel
	 * 
	 * @return
	 */
	public JPanel getBodyPanel() {
		return this.panelBody;
	}
	
	/**
	 * Returns object reference for footer panel
	 * 
	 * @return
	 */
	public JPanel getFooterPanel() {
		return this.panelFooter;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.monopoly.views.FrontendViewable#initView()
	 */
	@Override
	public abstract void initView();
	
	/**
	 * Data of type {@link T} to be displayed on the dialog. Note: Needs to be
	 * implemented by the subclass
	 * 
	 * @param data
	 *          - Reference to data
	 */
	public abstract void setData(T data);

	/**
	 * Set the colour of the content pane.
	 * 
	 * @param colour
	 *          - Colour to be set
	 */
	public void setColour(Color colour) {
		getContentPane().setBackground(colour);
	}


}
