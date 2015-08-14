package com.monopoly.dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JWindow;

import com.monopoly.models.Property;

public class PropertyDialog extends JWindow implements ActionListener {
	
	ImageIcon icon = new ImageIcon("data\\icons\\info.gif");
	
	JPanel topPanel = new JPanel(new BorderLayout(1,1));
	JTabbedPane tabbedPane = new JTabbedPane();
	JPanel allPanel = new JPanel(new BorderLayout());
	JPanel ownPanel = new JPanel(new BorderLayout());
	JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	
	JList allList = new JList();
	JList ownList = new JList();
	
	Vector allVector = new Vector(40);
	Vector ownVector = new Vector(28);
	
	JButton btnView = new JButton("View");
	
	JScrollPane allScroll = new JScrollPane(allList);
	JScrollPane ownScroll = new JScrollPane(ownList);
	
	Font listFont = new Font ("Arial", 0, 20);
	
	int selected = -1;
	CardDialog viewer = new CardDialog();
	
	Property properties[] = new Property[40];
	Property forSaleProps[] = new Property[40];
	
	PropertyDialog() {
		init();
		setBounds(660, 175, 340, 300);
		addPropArray(properties, "All");
	}
	
	public void addPropArray(Property props[], String pane) {
		ownVector.removeAllElements();
		if(pane.equalsIgnoreCase("All")) {
			
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == btnView) {
			
		}
	}

}
