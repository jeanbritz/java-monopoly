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

/**
 * 
 * @author BritzJ
 *
 */
public class PropertyManagerViewComponent extends AbstractViewComponent implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JTabbedPane tabbedPane;
	JPanel panelButtons;
	
	JList<Property> listAll;
	JList<Property> listOwn;
	
	JScrollPane scrollAll;
	JScrollPane scrollOwn;
		
	JButton buttonView;
		
	int selected = -1;
	PropertyCardDialog viewer = new PropertyCardDialog();
		
	PropertyManagerViewComponent() {
		super("Property Manager");
		
		setSize(500, 400);
		
	}
	
	@Override
	public void initView() {
		listAll = new JList<Property>();
		listAll.setListData(AssetLoader.getPropertyCards());
		listAll.setCellRenderer(new PropertyListCell());
		scrollAll = new JScrollPane(listAll);
		tabbedPane = new JTabbedPane();
		tabbedPane.addTab("All", scrollAll);
		buttonView = new JButton("View");
		panelButtons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panelButtons.add(buttonView);
		
		panelTop.add(tabbedPane, BorderLayout.CENTER);
		panelTop.add(panelButtons, BorderLayout.SOUTH);
		
		buttonView.addActionListener(this);
		buttonView.setEnabled(false);
		
		scrollAll.revalidate();
		scrollAll.repaint();
		
	}

	@Override
	public void updateView() {
				
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == buttonView) {
			if(listAll.getSelectedValue() != null) {
				viewer.setData(listAll.getSelectedValue());
				viewer.setVisible(true);
			}
		}
	}
	
	/**
	 * 
	 * @author BritzJ
	 *
	 */
	class PropertyListCell extends JLabel implements ListCellRenderer<Property> {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
				
		@Override
		public Component getListCellRendererComponent(
				JList<? extends Property> list, Property property, int index,
				boolean isSelected, boolean cellHasFocus) {
			if(property != null) {
				if(property.getType().equals("Station")) {
					setIcon(AssetLoader.loadImageIcon("train"));
				} else if (property.getName().equals("Water")) {
					setIcon(AssetLoader.loadImageIcon("waterboard"));
				} else if (property.getName().equals("Electricity")) {
					setIcon(AssetLoader.loadImageIcon("electricity"));
				} else {
					// Most probably a Street, Avenue, etc...
					setIcon(AssetLoader.loadImageIcon("property"));
				}
				buttonView.setEnabled(true);
				setText(property.getName() + " " + property.getType());
			}
			if(isSelected) {
							
			}
			return this;
		}
		
	}

}
