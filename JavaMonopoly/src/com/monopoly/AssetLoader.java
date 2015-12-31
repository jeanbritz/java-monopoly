package com.monopoly;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.monopoly.models.db.CardDbModel;
import com.monopoly.models.db.PropertyDbModel;
import com.monopoly.models.persistent.Card;
import com.monopoly.models.persistent.Property;

/**
 * 
 * Load external resources into Java objects
 * 
 * @author Jean Britz
 * @version 1.0
 * @since 1.0
 */

public class AssetLoader {
	
	private static PropertyDbModel propertyModel;
	private static CardDbModel cardDbModel;
	
	private static final String ASSET_FOLDER = System.getProperty("user.dir") + File.separatorChar +"assets";
	private static final String DB_FILENAME = "database.db"; 
	private static final int DB_VERSION = 1;
	
	private static List<Property> propertyRecords = null;
	private static List<Card> chanceCardRecords = null;
	
	protected AssetLoader() {
				
	}
	
	
	/**
	 * Helper function of displaying a dialog with a message
	 */
	public static void showErrorMessage(String text) {
		JOptionPane.showMessageDialog(null, text, "Monopoly", JOptionPane.WARNING_MESSAGE);
	}
	
	/**
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws NoSuchFieldException
	 */
	public static List<Property> getProperties() throws SQLException, ClassNotFoundException, NoSuchFieldException {
		propertyModel = new PropertyDbModel();
		List<Property> properties = propertyModel.getObjectModel(Property.class).getAll();
		return properties;
		
	}
	
	/**
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws NoSuchFieldException
	 * @throws SQLException
	 */
	public static Vector<Property> getOwnablePropertyCards() throws ClassNotFoundException, NoSuchFieldException, SQLException {
		List<Property> props = getProperties();
		Vector<Property> result = new Vector<Property>(4);
		for(Property prop : props) {
			if(prop.isOwnable()) {
				result.addElement(prop);
			}
		}
		return result;
		
	}
	
	/**
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws NoSuchFieldException
	 * @throws SQLException
	 */
	public static List<Card> getChanceCards() {
		try {
			cardDbModel = new CardDbModel();
			if (chanceCardRecords == null) {
				chanceCardRecords = cardDbModel.getObjectModel(Card.class).getAll();
			}
		} catch (ClassNotFoundException | NoSuchFieldException | SQLException e) {
			e.printStackTrace();
		}

		return chanceCardRecords;
		
	}
	
	/**
	 * @return
	 */
	public static  List<Property> getAllPropertyRecords() {
		
		
		if(propertyRecords == null) {
			try {
				propertyModel = new PropertyDbModel();
				propertyRecords = propertyModel.getObjectModel(Property.class).getAll();
			} catch (SQLException | ClassNotFoundException | NoSuchFieldException e) {
				e.printStackTrace();
			}
		}
		return propertyRecords;
		
	}
			
	
	/**
	 * 
	 * @param resource
	 * @return
	 */
	public static BufferedImage loadImage(String resource) {
		File folder = new File(ASSET_FOLDER);
		File list[] = folder.listFiles(new ImageFileFilter());
		for (int i = 0; i < list.length; i++) {
			if(list[i].getName().contains(resource.toLowerCase())) {
				try {
					return ImageIO.read(list[i]);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	/**
	 * 
	 * @param resource
	 * @return
	 */
	public static ImageIcon loadImageIcon(String resource) {
		return new ImageIcon (loadImage(resource));
	}
	
	
	/**
	 * 
	 * @param heading
	 * @return
	 */
	public static Font loadFont(String heading) {
		if(heading.equalsIgnoreCase("h1")) {
			return new Font ("Arial", Font.BOLD, 50);
		} else if(heading.equalsIgnoreCase("h2")) {
			return new Font("Arial", Font.BOLD, 25);
		} else if(heading.equalsIgnoreCase("h3")) {
			return new Font("Arial", Font.PLAIN, 10);
		} else if(heading.equalsIgnoreCase("body")) {
			return new Font("Arial", Font.PLAIN, 12);
		}
		else if(heading.equalsIgnoreCase("li")) {
			return new Font ("Arial", Font.PLAIN, 20);
		}
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	public static String getDbName() {
		return DB_FILENAME;
	}
	
	/**
	 * 
	 * @return
	 */
	public static int getDbVersion() {
		return DB_VERSION;
	}
	
	public static class ImageFileFilter implements FileFilter {
	  private static final String[] allowedfileExt = 
	    new String[] {"jpg", "png", "gif"};
	 
	  public boolean accept(File file) {
	    for (String extension : allowedfileExt) {
	      if (file.getName().toLowerCase().endsWith(extension)) {
	        return true;
	      }
	    }
	    return false;
	  }
	}
	
}
