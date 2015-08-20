package com.monopoly.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JWindow;
import javax.swing.ListCellRenderer;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import com.monopoly.AssetLoader;
import com.monopoly.models.Property;

public class PropertyManagerViewComponent extends JPanel implements ActionListener, IViewComponent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JTabbedPane tabbedPane = new JTabbedPane();
	JPanel panelAll = new JPanel(new BorderLayout());
	JPanel panelOwn = new JPanel(new BorderLayout());
	JPanel panelButtons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	
	JList<Property> listAll = new JList<Property>();
	JList<Property> listOwn = new JList<Property>();
	
	JScrollPane scrollAll = new JScrollPane(listAll);
	JScrollPane scrollOwn = new JScrollPane(listOwn);
		
	JButton btnView = new JButton("View");
		
	Font listFont = new Font ("Arial", 0, 20);
	
	int selected = -1;
	PropertyCardDialog viewer = new PropertyCardDialog();
		
	PropertyManagerViewComponent() {
		initView();
		setSize(500, 400);
		
	}
		
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == btnView) {
			
		}
	}

	@Override
	public void initView() {
		setLayout(new BorderLayout());
		listAll.setListData(AssetLoader.getPropertyCards());
		
		
		Border border = BorderFactory.createMatteBorder(5, 5, 5, 5, new Color(184,0,0));
		TitledBorder titledBorder = new TitledBorder (border, "Property Manager", 1, 1, new Font("Arial", 1, 15), Color.black);
		setBorder(titledBorder);
		
		listAll.setCellRenderer(new PropertyListCell());
		
		tabbedPane.addTab("All", scrollAll);
		
		panelButtons.add(btnView);
		
		add(tabbedPane, BorderLayout.CENTER);
		add(panelButtons, BorderLayout.SOUTH);
		
		scrollAll.revalidate();
		scrollAll.repaint();
		btnView.addActionListener(this);
		
	}

	@Override
	public void updateView() {
				
	}
	
	class PropertyListCell extends JLabel implements ListCellRenderer<Property> {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public final ImageIcon TRAIN_ICON = new ImageIcon(AssetLoader.loadImage("train"));
		public final ImageIcon PROPERTY_ICON = new ImageIcon (AssetLoader.loadImage("property"));
	    public final ImageIcon ELEC_ICON = new ImageIcon (AssetLoader.loadImage("electricity"));
	    public final ImageIcon WATER_ICON = new ImageIcon (AssetLoader.loadImage("waterboard"));
	    public final ImageIcon HOUSE_ICON = new ImageIcon (AssetLoader.loadImage("house"));
		
		
		@Override
		public Component getListCellRendererComponent(
				JList<? extends Property> list, Property property, int index,
				boolean isSelected, boolean cellHasFocus) {
			if(property != null) {
				if(property.getType().equals("Station")) {
					setIcon(TRAIN_ICON);
				} else if (property.getName().equals("Water")) {
					setIcon(WATER_ICON);
				} else if (property.getName().equals("Electricity")) {
					setIcon(ELEC_ICON);
				} else {
					// Most probably a Street, Avenue, etc...
					setIcon(PROPERTY_ICON);
				}
				setText(property.getName() + " " + property.getType());
			}
			if(isSelected) {
							
			}
			return this;
		}
		
	}

}
