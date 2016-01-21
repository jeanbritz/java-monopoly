package za.co.geskroef.monopoly.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import za.co.geskroef.monopoly.Asset;
import za.co.geskroef.monopoly.Dice;

/**
 * 
 * @author Jean Britz
 * @version 1.0
 * @since 1.0
 * 
 */
public class DiceView extends AbstractView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static JPanel panelDice;
	
	private static JLabel labelFirst;
	private static JLabel labelSecond;
	private static JLabel labelOutcome;
			
	private static ImageIcon imageFirst;
	private static ImageIcon imageSecond;

	private Dice dice;

	public DiceView(Dice dice) {
		super("The Dice");
		this.dice = dice;
		
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see za.co.geskroef.monopoly.views.AbstractView#initView()
	 */
	@Override
	public void initView() {
		labelOutcome = new JLabel("X");
		labelFirst = new JLabel();
		labelSecond = new JLabel();
		panelDice = new JPanel(new FlowLayout());
		labelOutcome.setFont(Asset.loadFont("h1"));
		labelOutcome.setHorizontalAlignment(JLabel.CENTER);
		setBounds(660, 485, 340, 165);
		panelDice.add(labelFirst);
		panelDice.add(labelSecond);
		panelTop.add(panelDice,BorderLayout.CENTER);
		panelTop.add(labelOutcome, BorderLayout.SOUTH);		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see za.co.geskroef.monopoly.views.AbstractView#updateView()
	 */
	@Override
	public void updateView() {

		//ImageIcon iconFirst = new ImageIcon(IMAGE_FOLDER + this.first + ".jpg"); 
		//labelFirst.setIcon(iconFirst);
		//labelSecond.setIcon(new ImageIcon(IMAGE_FOLDER + this.second + ".jpg"));
		// labelOutcome.setText(String.valueOf(Game.getDice().getOutcome()));

	}
	
}
