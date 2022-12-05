package monopoly.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.ListCellRenderer;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import monopoly.Asset;
import monopoly.model.persistent.Property;
import monopoly.model.persistent.PropertyType;
import monopoly.view.dialog.PropertyCardDialog;

/**
 * 
 * @version 1.0
 * @since 1.0
 * @author Jean Britz
 *
 */
public class PropertyManagerView extends AbstractView 
										  implements ActionListener, ListSelectionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final int NONE_SELECTED = -1;

	private static JTabbedPane tabbedPane;
	private static JPanel panelButtons;
	
	private static JList<Property> listAll;
	private JList<Property> listOwn;
	
	private static JScrollPane scrollAll;
	private static JScrollPane scrollOwn;
		
	private static JButton buttonView;
		
	private static final int selected = NONE_SELECTED;
	private PropertyCardDialog viewer = new PropertyCardDialog();
		
	PropertyManagerView() {
		super("Property Manager");
		
	}
	

	@Override
	public void initView() {
		listAll = new JList<Property>();
		try {
			listAll.setListData(Asset.getOwnablePropertyCards());
		} catch (ClassNotFoundException | NoSuchFieldException | SQLException e) {

		}
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
		
		setSize(500, 400);

	}

	@Override
	public void updateView() {
				
	}
	

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equals("View")) {
			if(listAll.getSelectedValue() != null) {
				viewer.setData(listAll.getSelectedValue());
				viewer.setVisible(true);
			}
		}
	}
	

	@Override
	public void valueChanged(ListSelectionEvent event) {
		if(event.getValueIsAdjusting()) {
			if(event.getSource() == listAll) {
				
			}
			if(event.getSource() == listOwn) {
				
			}
			
		}
		
	}

	/**
	 * 
	 * @author Jean
	 *
	 */
	class PropertyListCell extends JLabel implements ListCellRenderer<Property> {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		public PropertyListCell() {
			super();
			setOpaque(true);
		}



		@Override
		public Component getListCellRendererComponent(
				JList<? extends Property> list, Property property, int index,
				boolean isSelected, boolean cellHasFocus) {
							
			if (property.getPtId() == PropertyType.STATION) {
					setIcon(Asset.loadImageIcon("train"));
			} else if (property.getPtId() == PropertyType.BOARD) {
				if (property.getPName().equals("Water")) {
					setIcon(Asset.loadImageIcon("waterboard"));
				} else {
					setIcon(Asset.loadImageIcon("electricity"));
				}
			} else {
					// Most probably a Street, Avenue, etc...
					setIcon(Asset.loadImageIcon("property"));
				}
				
				buttonView.setEnabled(true);
			setText(property.toString());
						
			if(isSelected) {
				setBackground(Color.BLACK);
				setForeground(Color.WHITE);
			} else {
				setBackground(Color.WHITE);
				setForeground(Color.BLACK);
			}
			if(cellHasFocus) {
				setBackground(Color.GREEN);
			}
			return this;
		}
		
	}
}
