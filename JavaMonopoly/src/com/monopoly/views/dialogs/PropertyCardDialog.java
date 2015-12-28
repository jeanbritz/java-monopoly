package com.monopoly.views.dialogs;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import com.monopoly.AssetLoader;
import com.monopoly.models.persistent.Property;
import com.monopoly.models.persistent.Tariff;

public class PropertyCardDialog extends AbstractDialog<Property> {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Icon imageHouseCost = new ImageIcon("house.png");

	JLabel labelHeader;
	JTable tableTariffs;
	JLabel labelSmallNote;
	JLabel labelHouseCost;
	JLabel labelMortage;

	JButton buttonClose;
	
	Property property;
	
	public PropertyCardDialog() {
		super();
		
		setTitle("Monopoly");
		setBounds(70, 70, 270, 400);
		getBodyPanel().setBackground(Color.WHITE);
		getFooterPanel().setBackground(Color.WHITE);
		
		
	}
		
	public void onCloseClick() {
		dispose();
	}

	@Override
	public void setData(Property data) {
		property = data;
		
		labelHeader.setText(property.toString());
		getHeaderPanel().setBackground(property.getColour());

		tableTariffs.setModel(new TariffTableModel(property.getTariffs()));
		// Auto-resize is not triggered after table's model is set, therefore need
		// to resize the column manually.
		tableTariffs.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableTariffs.getColumnModel().getColumn(0).setPreferredWidth(150);

		labelSmallNote.setText(
"<html>If a player owns ALL the Sites of any Colour-Group,"
		    + " the rent is Doubled on Unimproved Sites in that group</html>");
		// labelSmallNote.setMaximumSize();
		labelSmallNote.setPreferredSize(new Dimension((int) (getBodyPanel().getWidth() * 0.9), 50));
		
		Tariff oneHouse = data.getTariffs().get(1);

		labelHouseCost.setText(
"<html>COST of Houses, R " + oneHouse.getTCost() + " each <br> COST of Hotels, R "
		    + oneHouse.getTCost() * 5 + " each</html>");
		labelHouseCost.setPreferredSize(new Dimension((int) (getBodyPanel().getWidth() * 0.9), 50));
	}

	
	@Override
	public void initView() {
		labelHeader = new JLabel("Header");
		labelHeader.setFont(AssetLoader.loadFont("h2"));
		labelHeader.setVerticalAlignment(JLabel.CENTER);
		labelHeader.setHorizontalAlignment(JLabel.CENTER);
		
		labelSmallNote = new JLabel("Small Note");
		labelSmallNote.setFont(AssetLoader.loadFont("h3"));
		labelSmallNote.setVerticalAlignment(JLabel.CENTER);
		
		labelHouseCost = new JLabel("Cost of House");
		labelHouseCost.setVerticalAlignment(JLabel.CENTER);

		tableTariffs = new JTable();
		tableTariffs.setGridColor(Color.white);

		buttonClose = new JButton("Close");

		getHeaderPanel().add(labelHeader);

		getBodyPanel().add(tableTariffs);
		getBodyPanel().add(labelSmallNote);
		getBodyPanel().add(labelHouseCost);
		// getBodyPanel().add(labelMortage);

		getFooterPanel().add(buttonClose);
		
		buttonClose.addActionListener(this);
		
		
	}
	
	@Override
	public void updateView() {
		// The Dialog does not have any animations yet to be updated.
	}
	
	/**
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource().equals(buttonClose)) {
			onCloseClick();
		}
	}
	
	/**
	 * Custom table model to display the tariffs for each property card
	 * 
	 * @author Jean
	 *
	 */
	public class TariffTableModel extends AbstractTableModel {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		ArrayList<Tariff> tariffs = null;

		public TariffTableModel(ArrayList<Tariff> tariffs) {
			super();
			this.tariffs = tariffs;

		}

		@Override
		public int getRowCount() {
			
			return tariffs.size();
		}

		@Override
		public int getColumnCount() {
			
			return 2;
		}

		@Override
		public Object getValueAt(int rowIdx, int colIdx) {
			
			if (colIdx != 0) {
				return tariffs.get(rowIdx).getTCost();
			} else {
				long code = tariffs.get(rowIdx).getTCode();
				if (code == 0) {
					return "RENT - Site only ";
				} else if (code == 1) {
					return "         With " + code + " House";
				} else if (code == 5) {
					return "         With HOTEL";
				} else {
					return "         With " + code + " Houses";

				}
			}
		}
		
		
	
	}

}