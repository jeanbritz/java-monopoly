package com.monopoly.views.dialogs;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import com.monopoly.Asset;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.monopoly.views.dialogs.AbstractDialog#setData(java.lang.Object)
	 */
	@Override
	public void setData(Property data) {
		property = data;
		
		labelHeader.setText(property.toString());
		getHeaderPanel().setBackground(property.getColour());
		
		String type = data.getType().getPtName();

		if (type.equalsIgnoreCase("Station")) {
			setStationPropertyData(data);
		} else if (type.equalsIgnoreCase("Board")) {
			setBoardPropertyData(data);
		} else {
			setEstatePropertyData(data);
		}
		tableTariffs.setAlignmentX((float) (getBodyPanel().getWidth() * 0.5));
		((CenteredLabel) labelMortage).setText("MORTAGE value of site, R " + data.getPMortageVal());
		((CenteredLabel) labelMortage).adjustToPreferredSize();
		((CenteredLabel) labelSmallNote).adjustToPreferredSize();
		((CenteredLabel) labelHouseCost).adjustToPreferredSize();
	}
	
	/**
	 * 
	 * @param data
	 */
	private void setEstatePropertyData(Property data) {
		tableTariffs.setVisible(true);
		tableTariffs.setModel(new EstateTariffTable(property.getTariffs()));
		// Auto-resize is not triggered after table's model is set, therefore need
		// to resize the column manually.
		tableTariffs.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableTariffs.getColumnModel().getColumn(0).setPreferredWidth(150);

		((CenteredLabel) labelSmallNote).setText(
"If a player owns ALL the Sites of any Colour-Group,"
		    + " the rent is Doubled on Unimproved Sites in that group");

		Tariff oneHouse = data.getTariffs().get(1);
		((CenteredLabel) labelHouseCost).setText(
"COST of Houses, R " + oneHouse.getTCost() + " each <br> COST of Hotels, R "
		    + oneHouse.getTCost() * 5 + " each");

	}

	/**
	 * 
	 * @param data
	 */
	private void setStationPropertyData(Property data) {
		tableTariffs.setVisible(true);
		tableTariffs.setModel(new StationTariffTable(property.getTariffs()));
		// Auto-resize is not triggered after table's model is set, therefore need
		// to resize the column manually.
		tableTariffs.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableTariffs.getColumnModel().getColumn(0).setPreferredWidth(150);

		((CenteredLabel) labelSmallNote).setText("");
		((CenteredLabel) labelHouseCost).setText("");
	}

	/**
	 * 
	 * @param data
	 */
	private void setBoardPropertyData(Property data) {
		tableTariffs.setVisible(false);
		((CenteredLabel) labelSmallNote).setText("");
		((CenteredLabel) labelHouseCost).setText("If one <em>Utilty</em> is owned, rent is 4 times amount shown on dice."
		    + "<br> If both <em>Utilities</em> are owned rent is 10 times amount shown on dice.");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.monopoly.views.dialogs.AbstractDialog#initView()
	 */
	@Override
	public void initView() {
		labelHeader = new CenteredLabel("Header", Asset.loadFont("h2"));

		tableTariffs = new JTable();
		tableTariffs.setGridColor(Color.white);

		labelSmallNote = new CenteredLabel("Small Note", 70, Asset.loadFont("h3"));
		labelHouseCost = new CenteredLabel("Cost of House", 70);
		labelMortage = new CenteredLabel("Mortage", null);
		
		buttonClose = new JButton("Close");

		getHeaderPanel().add(labelHeader);

		getBodyPanel().add(tableTariffs);
		getBodyPanel().add(labelSmallNote);
		getBodyPanel().add(labelHouseCost);
		getBodyPanel().add(labelMortage);

		getFooterPanel().add(buttonClose);
		
		buttonClose.addActionListener(this);
		
		
	}
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.monopoly.views.FrontendViewable#updateView()
	 */
	@Override
	public void updateView() {
		// The Dialog does not have any animations yet to be updated.
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource().equals(buttonClose)) {
			onCloseClick();
		}
	}
	
	/**
	 * Custom table model to display the tariffs for a estate property card
	 * 
	 * @author Jean Britz
	 * @version 1.0
	 * @since 1.0
	 *
	 */
	private class EstateTariffTable extends AbstractTableModel {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		ArrayList<Tariff> tariffs = null;

		public EstateTariffTable(ArrayList<Tariff> tariffs) {
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
	
	/**
	 * Custom table model to display the tariffs for a station property card
	 * 
	 * @author Jean Britz
	 * @version 1.0
	 * @since 1.0
	 *
	 */
	private class StationTariffTable extends AbstractTableModel {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		ArrayList<Tariff> tariffs = null;

		public StationTariffTable(ArrayList<Tariff> tariffs) {
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
				} else {
					return "    If " + (code + 1) + " Stations are owned";
				}
			}
		}
	}


}