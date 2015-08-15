package com.monopoly.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 * 
 * @author BritzJ
 * @version 1.0
 * @since 1.0
 * 
 */
public class DiceWindow extends JComponent implements IView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String IMAGE_FOLDER = "images\\dice";
	
	JPanel panelTop = new JPanel(new BorderLayout());
	JPanel panelDice = new JPanel(new FlowLayout());
	
	JLabel labelFirst = new JLabel();
	JLabel labelSecond = new JLabel();
	JLabel labelOutcome = new JLabel("X");
	
	Font fontResult = new Font ("Arial", 1, 50);
	Font fontTitledBorder = new Font ("Arial", 1, 15);
	
	ImageIcon imageFirst;
	ImageIcon imageSecond;
	
	Border border;
	TitledBorder titledBorder;
	
	private int first;
	private int second;
		
	public DiceWindow() {
		super();
		initUI();
	}
	
	@Override
	public void initUI() {
		labelOutcome.setFont(fontResult);
		labelOutcome.setHorizontalAlignment(JLabel.CENTER);
		setBounds(660, 485, 340, 165);
		setLayout(new BorderLayout());
		panelDice.add(labelFirst);
		panelDice.add(labelSecond);
		panelTop.add(panelDice,BorderLayout.CENTER);
		panelTop.add(labelOutcome, BorderLayout.SOUTH);
		border = BorderFactory.createMatteBorder(5, 5, 5, 5, new Color(184,0,0));
		titledBorder = new TitledBorder(border, "The Dices", 1, 1, fontTitledBorder, Color.black);
		panelTop.setBorder(titledBorder);
		add(panelTop, BorderLayout.CENTER);
		
	}
	
	public void roll() {
		
		reset();
		this.first = (int)(Math.random() * 6) + 1;
		this.second = (int)(Math.random() * 6) + 1;
		updateUI();
		
	}
	
	public int getOutcome() {
		return this.first + this.second;
	}
	
	public boolean hasThrownDouble() {
		return (this.first == this.second);
	}
	
	@Override
	public void updateUI() {
		labelFirst.setIcon(new ImageIcon(IMAGE_FOLDER + this.first + ".jpg"));
		labelSecond.setIcon(new ImageIcon(IMAGE_FOLDER + this.second + ".jpg"));
		labelOutcome.setText(String.valueOf(getOutcome()));
		panelTop.updateUI();
	}
	
	private void reset () {
		
	}
	
	
}
