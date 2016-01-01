package com.monopoly.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import com.monopoly.views.interfaces.Viewable;

public abstract class AbstractView extends JPanel 
											implements Viewable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Color BORDER_COLOUR = new Color(184, 0, 0);
		
	JPanel panelTop;
	
	Border border;
	TitledBorder titledBorder;
		
	Font fontTitledBorder;
	
	
	
	public AbstractView(String title) {
		super();
		
		setLayout(new BorderLayout());
		panelTop = new JPanel(new BorderLayout());
		fontTitledBorder = new Font ("Arial", 1, 15);
		border = BorderFactory.createMatteBorder(5, 5, 5, 5, BORDER_COLOUR);
		titledBorder = new TitledBorder(border, title, 1, 1, fontTitledBorder, Color.black);
		panelTop.setBorder(titledBorder);
		add(panelTop, BorderLayout.CENTER);
		initView();
	}
	
	public void setBorderTitle(String title) {
		titledBorder.setTitle(title);
	}
	
	@Override
	public abstract void initView();

	@Override
	public abstract void updateView();
	
	
	

}
