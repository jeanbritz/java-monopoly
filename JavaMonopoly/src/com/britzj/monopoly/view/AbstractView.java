package com.britzj.monopoly.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import com.britzj.monopoly.view.framework.Viewable;

/**
 * 
 * @author Jean
 *
 */
abstract class AbstractView extends JPanel implements Viewable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected static final Color BORDER_COLOUR = new Color(184, 0, 0);
		
	protected JPanel panelTop;
	
	protected Border border;
	protected TitledBorder titledBorder;
	protected Font font;
	
	
	/**
	 * 
	 * @param title
	 */
	protected AbstractView(String title) {
		super();
		
		setLayout(new BorderLayout());
		panelTop = new JPanel(new BorderLayout());
		font = new Font ("Arial", 1, 15);
		border = BorderFactory.createMatteBorder(5, 5, 5, 5, BORDER_COLOUR);
		titledBorder = new TitledBorder(border, title, 1, 1, font, Color.black);
		panelTop.setBorder(titledBorder);
		add(panelTop, BorderLayout.CENTER);
		initView();
	}
	
	/**
	 * 
	 * @param title
	 */
	protected void setBorderTitle(String title) {
		titledBorder.setTitle(title);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.britzj.monopoly.views.interfaces.Viewable#initView()
	 */
	@Override
	public abstract void initView();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.britzj.monopoly.views.interfaces.Viewable#updateView()
	 */
	@Override
	public abstract void updateView();
	
	
	

}
